package javax.core.common.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Description: 对象工具类
 * @Author: 樊高风
 * @Date: 17:46 2020/5/3
 */
public class ObjectUtils {

    private ObjectUtils() {
    }

    /**
     * 功能描述：是否为空对象，是则返回参数2
     *
     * @param obj  判断为空的对象
     * @param obj1 为空返回的对象
     * @authorer: 樊高风
     * @date: 2020/5/3 17:48
     * @return:
     */
    public static Object notNull(Object obj, Object obj1) {
        return (obj == null || "".equals(obj)) ? obj1 : obj;
    }

    /**
     * 功能描述：是否空指针
     *
     * @param obj 判断的对象
     * @authorer: 樊高风
     * @date: 2020/5/3 17:49
     * @return:
     */
    public static boolean isNull(Object obj) {
        return obj == null ? true : false;
    }

    /**
     * 功能描述：是否整型数值
     *
     * @authorer: 樊高风
     * @date: 2020/5/3 18:01
     * @param:
     * @return:
     */
    public static boolean isInt(Object s) {
        try {
            Integer.valueOf(s.toString());
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * 功能描述：是否Float数值
     *
     * @authorer: 樊高风
     * @date: 2020/5/3 18:01
     * @param:
     * @return:
     */
    public static boolean isFloat(Object s) {
        try {
            Float.valueOf(s.toString());
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * 功能描述：是否Long数值
     *
     * @authorer: 樊高风
     * @date: 2020/5/3 18:01
     * @param:
     * @return:
     */
    public static boolean isLong(Object s) {
        try {
            Long.valueOf(s.toString());
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * 功能描述：是否Boolean值
     *
     * @authorer: 樊高风
     * @date: 2020/5/3 18:02
     * @param:
     * @return:
     */
    public static boolean isBoolean(Object s) {
        try {
            Boolean.valueOf(s.toString());
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * 功能描述：对象合并
     * 将后者值合并到前者, 最好只用在基础数据类型属性对象
     *
     * @param merge_object 合并后的值
     * @param object       要合并的对象
     * @authorer: 樊高风
     * @date: 2020/5/3 17:57
     * @return:
     */
    public static void merge(Object merge_object, Object object) throws Exception {
        Class<?> classType = object.getClass();
        Field[] fields = classType.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            String fieldName = field.getName();
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getMethodName = "get" + firstLetter + fieldName.substring(1);
            String setMethodName = "set" + firstLetter + fieldName.substring(1);
            Method getMethod = classType.getMethod(getMethodName, new Class[]{});
            Method setMethod = classType.getMethod(setMethodName, new Class[]{field.getType()});
            Object value = getMethod.invoke(object, new Object[]{});
            if (value != null && value.toString().length() > 0) {
                setMethod.invoke(merge_object, new Object[]{value});
            }
        }
    }

    /**
     * 功能描述：反射对象
     *
     * @param path 类名全路径
     * @authorer: 樊高风
     * @date: 2020/5/3 17:58
     * @return:
     */
    public static Class<?> getObject(String path) throws ClassNotFoundException {
        return Class.forName(path);
    }

}
