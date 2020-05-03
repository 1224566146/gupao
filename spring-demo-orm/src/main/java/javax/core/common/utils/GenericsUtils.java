package javax.core.common.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @Description: 泛型操作类
 * @Author: 樊高风
 * @Date: 17:37 2020/5/3
 */
@SuppressWarnings("unchecked")
public class GenericsUtils {

    private static final Log logger = LogFactory.getLog(GenericsUtils.class);

    private GenericsUtils() {
    }

    /**
     * 功能描述：通过反射,获得定义Class时声明的父类的范型参数的类型. 如public BookManager extends GenricManager<Book>
     *
     * @param clazz The class to introspect
     * @authorer: 樊高风
     * @date: 2020/5/3 17:45
     * @return: the first generic declaration, or <code>Object.class</code> if
     * cannot be determined
     */
    public static Class getSuperClassGenricType(Class clazz) {
        return getSuperClassGenricType(clazz, 0);
    }

    /**
     * 功能描述：通过反射,获得定义Class时声明的父类的范型参数的类型. 如public BookManager extends GenricManager<Book>
     *
     * @param clazz The class to introspect
     * @param index the Index of the generic ddeclaration,start from 0.
     * @authorer: 樊高风
     * @date: 2020/5/3 17:45
     * @return: the first generic declaration, or <code>Object.class</code> if
     * cannot be determined
     */
    public static Class getSuperClassGenricType(Class clazz, int index) {
        Type genType = clazz.getGenericSuperclass();

        if (!(genType instanceof ParameterizedType)) {
            logger.debug(clazz.getSimpleName() + "'s superclass not ParameterizedType");
            return Object.class;
        }

        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        if (index >= params.length || index < 0) {
            logger.warn("Index: " + index + ", Size of " + clazz.getSimpleName() + "'s Parameterized Type: " + params.length);
            return Object.class;
        }
        return (Class) params[index];
    }
}
