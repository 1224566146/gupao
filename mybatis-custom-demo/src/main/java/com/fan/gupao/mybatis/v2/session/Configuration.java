package com.fan.gupao.mybatis.v2.session;


import com.fan.gupao.mybatis.v2.TestMybatis;
import com.fan.gupao.mybatis.v2.annotation.Entity;
import com.fan.gupao.mybatis.v2.annotation.Select;
import com.fan.gupao.mybatis.v2.binding.MapperRegistry;
import com.fan.gupao.mybatis.v2.executor.CachingExecutor;
import com.fan.gupao.mybatis.v2.executor.Executor;
import com.fan.gupao.mybatis.v2.executor.SimpleExecutor;
import com.fan.gupao.mybatis.v2.plugin.Interceptor;
import com.fan.gupao.mybatis.v2.plugin.InterceptorChain;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @Description: 全局配置类
 * @Author: 樊高风
 * @Date: 10:12 2020/5/15
 */
public class Configuration {

    // SQL映射关系配置，使用注解时不用重复配置
    public static final ResourceBundle SQL_MAPPINGS;

    // 全局配置
    public static final ResourceBundle PROPERTIES;

    // 维护接口与工厂类关系
    public static final MapperRegistry MAPPER_REGISTRY = new MapperRegistry();

    // 维护接口方法与SQL关系
    public static final Map<String, String> MAPPED_STATEMENTS = new HashMap<>();

    // 插件
    private InterceptorChain interceptorChain = new InterceptorChain();

    // 所有Mapper接口
    private List<Class<?>> mapperList = new ArrayList<>();
    // 类所有文件
    private List<String> classPaths = new ArrayList<>();

    static {
        SQL_MAPPINGS = ResourceBundle.getBundle("v2sql");
        PROPERTIES = ResourceBundle.getBundle("mybatis");
    }

    public Configuration(){
        // Note:在properties和注解中重复配置SQL会覆盖
        // 1.解析sql.properties
        for (String key : SQL_MAPPINGS.keySet()) {
            Class mapper = null;
            String statement = null;
            String pojoStr = null;
            Class pojo = null;
            // properties中的value用--隔开，第一个是SQL语句
            statement = SQL_MAPPINGS.getString(key).split("--")[0];
            // properties中的value用--隔开，第二个是需要转换的POJO类型
            pojoStr = SQL_MAPPINGS.getString(key).split("--")[1];
            try {
                // properties中的key是接口类型+方法
                // 从接口类型+方法中截取接口类型
                mapper = Class.forName(key.substring(0,key.lastIndexOf(".")));
                pojo = Class.forName(pojoStr);
            }catch (ClassNotFoundException e){
                e.printStackTrace();
            }
            MAPPER_REGISTRY.addMapper(mapper, pojo); // 接口与返回的实体类关系
            MAPPED_STATEMENTS.put(key, statement);// 接口方法与SQL关系
        }

        // 2.解析接口上的注解(会覆盖XML中的接口与实体类的关系)
        String mapperPath = PROPERTIES.getString("mapper.path");
        scanPackage(mapperPath);
        for (Class<?> mapper : mapperList) {
            parsingClass(mapper);
        }

        // 3.解析插件，可配置多个插件
        String pluginPathValue = PROPERTIES.getString("plugin.path");
        String[] pluginPaths = pluginPathValue.split(",");
        if(pluginPaths != null){
            // 将插件添加到interceptorChain中
            for (String plugin : pluginPaths) {
                Interceptor interceptor = null;
                try {
                    interceptor = (Interceptor)Class.forName(plugin).newInstance();
                }catch (Exception e){
                    e.printStackTrace();
                }
                interceptorChain.addInterceptor(interceptor);
            }
        }
    }

    /**
     * 功能描述：根据statement ID获取SQL
     * @authorer: 樊高风
     * @date: 2020/5/15 10:42
     * @param:
     * @return:
     */
    public String getMappedStatement(String id){
        return MAPPED_STATEMENTS.get(id);
    }

    public <T> T getMapper(Class<T> clazz, DefaultSqlSession sqlSession){
        return MAPPER_REGISTRY.getMapper(clazz, sqlSession);
    }

    /**
     * 功能描述：创建执行器，当开启缓存时使用缓存装饰
     *       当配置插件时，使用插件代理
     * @authorer: 樊高风
     * @date: 2020/5/15 10:46
     * @param:
     * @return:
     */
    public Executor newExecutor(){
        Executor executor = null;
        if(PROPERTIES.getString("cache.enabled").equals("true")){
            executor = new CachingExecutor(new SimpleExecutor());
        }else{
            executor = new SimpleExecutor();
        }
        // 目前只拦截了Executor，所有的插件都对Executor进行代理，没有对拦截类和方法签名进行判断
        if(interceptorChain.hasPlugin()){
            return (Executor) interceptorChain.pluginAll(executor);
        }
        return executor;
    }

    private void parsingClass(Class<?> mapper){
        // 1.解析类上的注解
        // 如果有Entity注解，说明是查询数据库的接口
        if(mapper.isAnnotationPresent(Entity.class)){
            for (Annotation annotation : mapper.getAnnotations()) {
                if(annotation.annotationType().equals(Entity.class)){
                    // 注册接口与实体类的映射关系
                    MAPPER_REGISTRY.addMapper(mapper, ((Entity)annotation).value());
                }
            }
        }

        // 2.解析方法上的注解
        Method[] methods = mapper.getMethods();
        for (Method method : methods) {
            // TODO 其他操作
            // 解析@Select注解的SQL语句
            if(method.isAnnotationPresent(Select.class)){
                for (Annotation annotation : method.getDeclaredAnnotations()) {
                    if(annotation.annotationType().equals(Select.class)){
                        // 注册接口类型+方法名和SQL语句的映射关系
                        String statement = method.getDeclaringClass().getName()+"."+method.getName();
                        MAPPED_STATEMENTS.put(statement, ((Select)annotation).value());
                    }
                }
            }
        }
    }

    /**
     * 功能描述：根据全局配置文件的Mapper接口路径，扫描所有接口
     * @authorer: 樊高风
     * @date: 2020/5/15 11:00
     * @param:
     * @return:
     */
    private void scanPackage(String mapperPath){
        String classPath = TestMybatis.class.getResource("/").getPath();
        mapperPath = mapperPath.replace(".", File.separator);
        String mainPath = classPath + mapperPath;
        doPath(new File(mainPath));
        for (String className : classPaths) {
            className = className.replace(classPath.replace("/", "\\")
                    .replaceFirst("\\\\",""),"")
                    .replace("\\", ".")
                    .replace(".class", "");
            Class<?> clazz = null;
            try {
                clazz = Class.forName(className);
            }catch (ClassNotFoundException e){
                e.printStackTrace();
            }
            if(clazz.isInterface()){
                mapperList.add(clazz);
            }

        }
    }

    /**
     * 功能描述：获取文件或文件夹下所有的类.class
     * @authorer: 樊高风
     * @date: 2020/5/15 10:59
     * @param:
     * @return:
     */
    private void doPath(File file){
        // 文件夹 遍历
        if(file.isDirectory()){
            File[] files = file.listFiles();
            for (File f1 : files) {
                doPath(f1);
            }
        }else {
            // 文件，直接添加
            if(file.getName().endsWith(".class")){
                classPaths.add(file.getPath());
            }
        }
    }

    public boolean hasStatement(String statementId) {
        return MAPPED_STATEMENTS.containsKey(statementId);
    }
}
