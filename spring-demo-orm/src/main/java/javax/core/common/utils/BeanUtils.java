package javax.core.common.utils;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 扩展Apache Commons BeanUtils，提供一些反射方面缺失功能的封装
 * @Author: 樊高风
 * @Date: 10:38 2020/5/3
 */
@SuppressWarnings("unchecked")
public class BeanUtils extends org.apache.commons.beanutils.BeanUtils {

    protected static final Log Logger = LogFactory.getLog(BeanUtils.class);

    private BeanUtils() {
    }

    /**
     * 功能描述：通过反射，获得定义Class时声明的父类的泛型参数类型。如public BookManager extends GenricManager<Book>
     *
     * @param clazz The class to introspect
     * @authorer: 樊高风
     * @date: 2020/5/3 10:46
     * @return: the first genric declaration, or <code>Object.class</code> if cannot be determined
     */
    public static Class getSuperClassGenricType(Class clazz) {
        return getSuperClassGenricType(clazz, 0);
    }

    /**
     * 功能描述：通过反射，获得定义Class时声明的父类的泛型参数类型。如public BookManager extends GenricManager<Book>
     *
     * @param clazz The class to introspect
     * @param index the Index of the generic ddeclaration,start from 0.
     * @authorer: 樊高风
     * @date: 2020/5/3 10:48
     * @return: the first genric declaration, or <code>Object.class</code> if cannot be determined
     */
    public static Class getSuperClassGenricType(Class clazz, int index) {

        Type genType = clazz.getGenericSuperclass();

        if (!(genType instanceof ParameterizedType)) {
            return Object.class;
        }

        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();

        if (index >= params.length || index < 0) {
            return Object.class;
        }
        if (!(params[index] instanceof Class)) {
            return Object.class;
        }
        return (Class) params[index];
    }

    /**
     * 功能描述：循环向上转型，获取对象的DeclaredField
     *
     * @param object       对象类
     * @param propertyName 字段名
     * @throws NoSuchFieldException 如果没有该Field时抛出
     * @authorer: 樊高风
     * @date: 2020/5/3 10:55
     * @return:
     */
    public static Field getDeclaredField(Object object, String propertyName) throws NoSuchFieldException {
        return getDeclaredField(object.getClass(), propertyName);
    }

    /**
     * 功能描述：循环向上转型，获取对象的DeclaredField
     *
     * @param clazz        实体
     * @param propertyName 字段名
     * @throws NoSuchFieldException 如果没有该Field时抛出
     * @authorer: 樊高风
     * @date: 2020/5/3 10:56
     * @return:
     */
    public static Field getDeclaredField(Class clazz, String propertyName) throws NoSuchFieldException {
        for (Class superClass = clazz; superClass != Object.class; superClass = superClass.getSuperclass()) {
            try {
                return superClass.getDeclaredField(propertyName);
            } catch (NoSuchFieldException e) {
                // Field不在当前类定义，继续向上转型
            }
        }
        throw new NoSuchFieldException("No such field: " + clazz.getName() + "." + propertyName);
    }

    /**
     * 功能描述：暴力获取对象变量值，忽略private，protected修饰符的限制.
     *
     * @param object       对象
     * @param propertyName 字段名
     * @throws NoSuchFieldException 如果没有该Field时抛出
     * @authorer: 樊高风
     * @date: 2020/5/3 11:01
     * @return:
     */
    public static Object forceGetProperty(Object object, String propertyName) throws NoSuchFieldException {
        Field field = getDeclaredField(object, propertyName);

        boolean accessible = field.isAccessible();
        field.setAccessible(true);

        Object result = null;
        try {
            result = field.get(object);
        } catch (IllegalAccessException e) {
            Logger.info("error wont' happen");
        }
        field.setAccessible(accessible);
        return result;
    }

    /**
     * 功能描述：暴力设置对象变量值，忽略private，protected修饰符的限制
     *
     * @param object       对象
     * @param propertyName 字段名
     * @param newValue     新值
     * @throws NoSuchFieldException 如果没有该Field时抛出
     * @authorer: 樊高风
     * @date: 2020/5/3 11:05
     * @return:
     */
    public static void forSetProperty(Object object, String propertyName, Object newValue) throws NoSuchFieldException {
        Field field = getDeclaredField(object, propertyName);
        boolean accessible = field.isAccessible();
        field.setAccessible(true);
        try {
            field.set(object, newValue);
        } catch (IllegalAccessException e) {
            Logger.info("error wont' happen");
        }
        field.setAccessible(accessible);
    }

    /**
     * 功能描述：暴力调用对象函数，忽略private,protected修饰符的限制
     *
     * @param object     对象
     * @param methodName 方法名
     * @param params     参数
     * @throws NoSuchMethodException 如果没有该Method时抛出
     * @authorer: 樊高风
     * @date: 2020/5/3 11:14
     * @return:
     */
    @SuppressWarnings("unchecked")
    public static Object invokePrivateMethod(Object object, String methodName, Object... params) throws NoSuchMethodException {
        Class[] types = new Class[params.length];
        for (int i = 0; i < params.length; i++) {
            types[i] = params[i].getClass();
        }

        Class clazz = object.getClass();
        Method method = null;
        for (Class superClass = clazz; superClass != Object.class; superClass = superClass.getSuperclass()) {
            try {
                method = superClass.getDeclaredMethod(methodName, types);
                break;
            } catch (NoSuchMethodException e) {
                // 方法不在当前类定义，继续向上转型
            }
        }

        if (method == null) {
            throw new NoSuchMethodException("No such Method: " + clazz.getSimpleName() + methodName);
        }
        boolean accessible = method.isAccessible();
        method.setAccessible(true);
        Object result = null;
        try {
            result = method.invoke(object, params);
        } catch (Exception e) {
            e.printStackTrace();
        }
        method.setAccessible(accessible);
        return result;
    }

    /**
     * 功能描述：按Field的类型取得Field列表
     *
     * @param object 对象
     * @param type   字段类型
     * @authorer: 樊高风
     * @date: 2020/5/3 11:17
     * @return:
     */
    public static List<Field> getFieldsByType(Object object, Class type) {
        List<Field> list = new ArrayList<>();
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.getType().isAssignableFrom(type)) {
                list.add(field);
            }
        }
        return list;
    }

    /**
     * 功能描述：按FieldName获得Field的类型
     *
     * @param type 字段类型
     * @param name 字段名
     * @authorer: 樊高风
     * @date: 2020/5/3 11:21
     * @return:
     */
    public static Class getPropertyType(Class type, String name) throws NoSuchFieldException {
        return getDeclaredField(type, name).getType();
    }

    /**
     * 功能描述：获得Field的getter函数名称
     *
     * @param type      字段类型
     * @param fieldName 字段名
     * @authorer: 樊高风
     * @date: 2020/5/3 11:25
     * @return:
     */
    public static String getGetterName(Class type, String fieldName) {

        if (type.getName().equals("boolean")) {
            return "is" + org.apache.commons.lang.StringUtils.capitalize(fieldName);
        } else {
            return "get" + org.apache.commons.lang.StringUtils.capitalize(fieldName);
        }
    }

    /**
     * 功能描述：获得field的getter函数，如果找不到该方法，返回null
     *
     * @param type      字段类型
     * @param fieldName 字段名
     * @authorer: 樊高风
     * @date: 2020/5/3 11:29
     * @return:
     */
    @SuppressWarnings("unchecked")
    public static Method getGetterMethod(Class type, String fieldName) {
        try {
            return type.getMethod(getGetterName(type, fieldName));
        } catch (NoSuchMethodException e) {
            Logger.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * 功能描述：反射调用类的方法
     *
     * @param className  全类名
     * @param methodName 方法名
     * @param argsClass  参数列表
     * @param args       参数
     * @authorer: 樊高风
     * @date: 2020/5/3 14:42
     * @return:
     */
    @SuppressWarnings("unchecked")
    public static Object invoke(String className, String methodName,
                                Class[] argsClass, Object[] args) throws ClassNotFoundException,
            SecurityException, NoSuchMethodException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException, InstantiationException {
        Class<?> clazz = Class.forName(className);
        Method method = clazz.getMethod(methodName, argsClass);
        return method.invoke(clazz.newInstance(), args);
    }

    /**
     * 功能描述：反射调用类中的方法
     *
     * @param oldObject  对象类
     * @param methodName 方法名
     * @param argClass   参数类型
     * @param args       参数
     * @authorer: 樊高风
     * @date: 2020/5/3 14:41
     * @return:
     */
    @SuppressWarnings("unchecked")
    public static Object invoke(Object oldObject, String methodName,
                                Class[] argClass, Object[] args) throws SecurityException,
            NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        Class<?> clazz = oldObject.getClass();
        Method method = clazz.getMethod(methodName, argClass);
        return method.invoke(oldObject, args);
    }

    /**
     * 功能描述：获取类中所有字段名
     *
     * @authorer: 樊高风
     * @date: 2020/5/3 11:39
     * @param:
     * @return:
     */
    public static String[] getFieldsName(Class c1) throws Exception {
        Field[] fields = c1.getDeclaredFields();
        String[] filedNames = new String[fields.length];
        for (int i = 0; i < fields.length; i++) {
            filedNames[i] = fields[i].getName();
        }
        return filedNames;
    }

    /**
     * 功能描述：获取类中所有字段名
     *
     * @param c1 对象类
     * @authorer: 樊高风
     * @date: 2020/5/3 14:40
     * @return:
     */
    public static List<String> getAllFieldName(Class c1) throws Exception {
        List<String> list = new ArrayList<>();
        Field[] fields = c1.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            if (field.getName().equals("serialVersionUID")) {
                continue;
            }
            list.add(field.getName());
        }
        while (true) {
            c1 = c1.getSuperclass();
            if (c1 == Object.class) {
                break;
            }
            list.addAll(getAllFieldName(c1));
        }
        return list;
    }

    /**
     * 功能描述：获取类中所有字段的setter方法
     *
     * @param c1 对象类
     * @authorer: 樊高风
     * @date: 2020/5/3 14:39
     * @return:
     */
    public static List<Method> getSetter(Class c1) {
        List<Method> list = new ArrayList<>();
        Method[] methods = c1.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            Method method = methods[i];
            String methodName = method.getName();
            if (!methodName.startsWith("set")) {
                continue;
            }
            list.add(method);
        }
        while (true) {
            c1 = c1.getSuperclass();
            if (c1 == Object.class) {
                break;
            }
            list.addAll(getSetter(c1));
        }
        return list;
    }

    /**
     * 功能描述：获取类中所有字段的getter方法
     *
     * @param c1 对象类
     * @authorer: 樊高风
     * @date: 2020/5/3 14:39
     * @return:
     */
    public static List<Method> getGetter(Class c1) {
        List<Method> list = new ArrayList<>();
        Method[] methods = c1.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            Method method = methods[i];
            String methodName = method.getName();
            if (!methodName.startsWith("get") && !methodName.startsWith("is")) {
                continue;
            }
            list.add(method);
        }
        while (true) {
            c1 = c1.getSuperclass();
            if (c1 == Object.class) {
                break;
            }
            list.addAll(getGetter(c1));
        }
        return list;
    }

    /**
     * 功能描述：获取类名和包名
     *
     * @param c1 对象类
     * @authorer: 樊高风
     * @date: 2020/5/3 14:38
     * @return:
     */
    public static String getClassNameWithoutPackage(Class c1) {
        String className = c1.getName();
        int pos = className.lastIndexOf(".") + 1;
        if (pos == -1) {
            pos = 0;
        }
        String name = className.substring(pos);
        return name;
    }

    /**
     * 功能描述：把DTO对象转成字符串
     *
     * @param object DTO对象
     * @authorer: 樊高风
     * @date: 2020/5/3 14:37
     * @return: 带属性名和值的字符串
     */
    public static String beanToString(Object object) {
        return ToStringBuilder.reflectionToString(object);
    }

}
