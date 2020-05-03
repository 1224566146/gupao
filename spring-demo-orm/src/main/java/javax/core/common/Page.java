package javax.core.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 分页对象，包含当前页数据及分页信息如总记录数
 * 能够支持JQuery EasyUI直接对接，能够支持和BootStrap Table直接对接
 * @Author: 樊高风
 * @Date: 19:26 2020/5/2
 */
public class Page<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final int DEFAULT_PAGE_SIZE = 20;

    // 每页的记录数
    private int pageSize = DEFAULT_PAGE_SIZE;

    // 当前页第一条数据在List的位置，从0开始
    private Long start;

    // 当前页中存放的记录，类型一般为List
    private List<T> rows;

    // 总记录数
    private Long total;


    /**
     * 功能描述：构造方法，只构造空页
     *
     * @authorer: 樊高风
     * @date: 2020/5/3 9:40
     * @param:
     * @return:
     */
    public Page() {
        this(0, 0, DEFAULT_PAGE_SIZE, new ArrayList<T>());
    }

    /**
     * 功能描述：默认构造方法
     *
     * @param start    本页数据在数据库中的起始位置
     * @param total    数据库中总记录条数
     * @param pageSize 本页容量
     * @param rows     本页包含的数据
     * @authorer: 樊高风
     * @date: 2020/5/3 9:41
     * @return:
     */
    public Page(long start, long total, int pageSize, List<T> rows) {
        this.pageSize = pageSize;
        this.start = start;
        this.rows = rows;
        this.total = total;
    }

    /**
     * 功能描述：取总记录数
     *
     * @authorer: 樊高风
     * @date: 2020/5/3 9:42
     * @param:
     * @return:
     */
    public Long getTotal() {
        return this.total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    /**
     * 功能描述：取总页数
     *
     * @authorer: 樊高风
     * @date: 2020/5/3 9:45
     * @param:
     * @return:
     */
    public long getTotalPageCount() {
        if (total % pageSize == 0) {
            return total / pageSize;
        } else {
            return total / pageSize + 1;
        }
    }

    /**
     * 功能描述：取每页数据容量
     *
     * @authorer: 樊高风
     * @date: 2020/5/3 9:46
     * @param:
     * @return:
     */
    public int getPageSize() {
        return this.pageSize;
    }

    /**
     * 功能描述：取当前页中的记录
     *
     * @authorer: 樊高风
     * @date: 2020/5/3 9:47
     * @param:
     * @return:
     */
    public List<T> getRows() {
        return this.rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    /**
     * 功能描述：取该页当前页码，页码从1开始
     *
     * @authorer: 樊高风
     * @date: 2020/5/3 9:48
     * @param:
     * @return:
     */
    public long getPageNo() {
        return start / pageSize + 1;
    }

    /**
     * 功能描述：该页是否有下一页
     *
     * @authorer: 樊高风
     * @date: 2020/5/3 9:50
     * @param:
     * @return:
     */
    public boolean hasNextPage() {
        return this.getPageNo() < this.getTotalPageCount() - 1;
    }

    /**
     * 功能描述：该页是否有上一页
     *
     * @authorer: 樊高风
     * @date: 2020/5/3 9:50
     * @param:
     * @return:
     */
    public boolean hasPreviousPage() {
        return this.getPageNo() > 1;
    }

    /**
     * 功能描述：获取任一页第一条数据在数据集的位置，每页条数使用默认值
     *
     * @param pageNo 从1开始的页号
     * @authorer: 樊高风
     * @date: 2020/5/3 9:52
     * @return: 该页第一条数据
     */
    protected static int getStartOfPage(int pageNo) {
        return getStartOfPage(pageNo, DEFAULT_PAGE_SIZE);
    }

    /**
     * 功能描述：获取任一页第一条数据在数据集的位置
     *
     * @param pageNo   从1开始的页号
     * @param pageSize 每页记录条数
     * @authorer: 樊高风
     * @date: 2020/5/3 9:53
     * @return: 该页第一条数据
     */
    public static int getStartOfPage(int pageNo, int pageSize) {
        return (pageNo - 1) * pageSize;
    }
}
