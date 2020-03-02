package com.fan.gupao.pattern.proxy.dynamicproxy.gpproxy;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:用来生成源代码的工具类
 * @Author: 樊高风
 * @Date: 17:47 2020/3/2
 */
public class GPProxy {

    public static final String LN = "\r\n";

    public static Object newProxyInstance(GPClassLoader loader,
                                          Class<?>[] interfaces,
                                          GPInvocationHandler h)
            throws IllegalArgumentException, IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        //1、动态生成源代码.java文件
        String src = generateSrc(interfaces);

        System.out.println(src);

        //2、Java文件输出磁盘
        String filePath = GPProxy.class.getResource("").getPath();

        System.out.println(filePath);

        File f = new File(filePath + "$Proxy0.java");
        FileWriter fw = new FileWriter(f);
        fw.write(src);
        fw.flush();
        fw.close();

        //3、把生成的.java文件编译成.class文件
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager standardFileManager = compiler.getStandardFileManager(null, null, null);
        Iterable<? extends JavaFileObject> iterable = standardFileManager.getJavaFileObjects(f);
        JavaCompiler.CompilationTask task = compiler.getTask(null, standardFileManager, null, null, null, iterable);
        task.call();
        standardFileManager.close();

        //4、编译生成的.class文件加载到JVM中来
        Class<?> proxyClass = loader.findClass("$Proxy0");
        Constructor<?> c = proxyClass.getConstructor(GPInvocationHandler.class);
        f.delete();

        //5、返回字节码重组以后的新的代理对象
        return c.newInstance(h);
    }


    private static String generateSrc(Class<?>[] interfaces) {
        StringBuffer sb = new StringBuffer();
        sb.append("package com.fan.gupao.pattern.proxy.dynamicproxy.gpproxy;" + LN);
        sb.append("import java.lang.reflect.*;" + LN);
        sb.append("import com.fan.gupao.pattern.proxy.Person;" + LN);
        sb.append("public class $Proxy0 implements " + interfaces[0].getName() + " {" + LN);
        sb.append("GPInvocationHandler h;" + LN);
        sb.append("public $Proxy0(GPInvocationHandler h){" + LN);
        sb.append("this.h = h;" + LN);
        sb.append("}" + LN);


        for (Method method : interfaces[0].getMethods()) {
            Class<?>[] params = method.getParameterTypes();

            StringBuffer paramNames = new StringBuffer();
            StringBuffer paramValues = new StringBuffer();
            StringBuffer paramClasses = new StringBuffer();

            for (int i = 0; i < params.length; i++) {
                Class clazz = params[i];
                String type = clazz.getName();
                String paramName = toLowerFirstCase(clazz.getSimpleName());
                paramNames.append(type + " " + paramName);
                paramValues.append(paramName);
                paramClasses.append(clazz.getName() + ".class");
                if (i > 0 && i < params.length - 1) {
                    paramNames.append(",");
                    paramValues.append(",");
                    paramClasses.append(",");
                }
            }
            sb.append("public " + method.getReturnType().getName() + " " + method.getName() + "(" + paramNames.toString() + "){" + LN);
            sb.append("try{" + LN);
            sb.append("Method m =" + interfaces[0].getName() + ".class.getMethod(\"" + method.getName() + "\",new Class[]{" + paramClasses.toString() + "});" + LN);
            sb.append((hasReturnValue(method.getReturnType()) ? "return " : "") + getCaseCode("this.h.invoke(this,m,new Object[]{" + paramValues + "})", method.getReturnType()) + ";" + LN);
            sb.append("}catch(Error _ex){}");
            sb.append("catch(Throwable e){" + LN);
            sb.append("throw new UndeclaredThrowableException(e);" + LN);
            sb.append("}");
            sb.append(getReturnEmptyCode(method.getReturnType()));
            sb.append("}");


        }


        sb.append("}" + LN);

        return sb.toString();

    }


    private static Map<Class, Class> mappings = new HashMap<Class, Class>();

    static {
        mappings.put(int.class, Integer.class);
    }


    private static String getReturnEmptyCode(Class<?> returnClass) {
        if (mappings.containsKey(returnClass)) {
            return "return 0;";
        } else if (returnClass == void.class) {
            return "";
        } else {
            return "return null;";
        }
    }


    private static String getCaseCode(String code, Class<?> returnClass) {
        if (mappings.containsKey(returnClass)) {
            return "((" + mappings.get(returnClass).getName() + ")" + code + ")." + returnClass.getSimpleName() + "Value()";
        }
        return code;
    }


    private static boolean hasReturnValue(Class<?> clazz) {
        return clazz != void.class;
    }


    private static String toLowerFirstCase(String src) {
        char[] chars = src.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }

}
