package javax.core.common.jdbc.datasource;

import org.aopalliance.intercept.Joinpoint;

/**
 * @Description: 动态切换数据源
 * @Author: 樊高风
 * @Date: 18:31 2020/5/2
 */
public class DynamicDataSourceEntry {

    //默认数据源
    public final static String DEFAULT_SOURCE = null;

    private final static ThreadLocal<String> LOCAL = new ThreadLocal<>();


    /**
     * 功能描述：清空数据源
     *
     * @authorer: 樊高风
     * @date: 2020/5/2 19:02
     * @param:
     * @return:
     */
    public void clear() {
        LOCAL.remove();
    }

    /**
     * 功能描述：获取当前正在使用的数据源名字
     *
     * @authorer: 樊高风
     * @date: 2020/5/2 19:03
     * @param:
     * @return:
     */
    public String get() {
        return LOCAL.get();
    }

    /**
     * 功能描述：还原指定切面的数据源
     *
     * @authorer: 樊高风
     * @date: 2020/5/2 19:04
     * @param:
     * @return:
     */
    public void restore(Joinpoint joinpoint) {
        LOCAL.set(DEFAULT_SOURCE);
    }

    /**
     * 功能描述：还原当前切面的数据源
     *
     * @authorer: 樊高风
     * @date: 2020/5/2 19:05
     * @param:
     * @return:
     */
    public void restore() {
        LOCAL.set(DEFAULT_SOURCE);
    }

    /**
     * 功能描述：设置已知名字的数据源
     *
     * @authorer: 樊高风
     * @date: 2020/5/2 19:05
     * @param:
     * @return:
     */
    public void set(String source) {
        LOCAL.set(source);
    }

    /**
     * 功能描述：根据年份动态设置数据源
     *
     * @authorer: 樊高风
     * @date: 2020/5/2 19:06
     * @param:
     * @return:
     */
    public void set(int year) {
        LOCAL.set("DB_" + year);
    }


}
