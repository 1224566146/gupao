package javax.core.common.jdbc;

import javax.core.common.Page;
import java.util.List;
import java.util.Map;

/**
 * @Description: 底层Dao接口
 * @Author: 樊高风
 * @Date: 19:07 2020/5/2
 */
public interface BaseDao<T, PK> {

    /**
     * 功能描述：获取列表
     *
     * @param queryRule 查询条件
     * @authorer: 樊高风
     * @date: 2020/5/2 19:12
     * @return:
     */
//    List<T> select(QueryRule queryRule) throws Exception;


    /**
     * 功能描述：获取分页结果
     *
     * @param queryRule 查询条件
     * @param pageNo    页码
     * @param pageSize  每页条数
     * @authorer: 樊高风
     * @date: 2020/5/2 19:13
     * @return:
     */
//    Page<?> select(QueryRule queryRule, int pageNo, int pageSize) throws Exception;

    /**
     * 功能描述：根据SQL获取列表
     *
     * @param sql  SQL语句
     * @param args 参数
     * @authorer: 樊高风
     * @date: 2020/5/2 19:15
     * @return:
     */
    List<Map<String, Object>> selectBySql(String sql, Object... args) throws Exception;

    /**
     * 功能描述：根据SQL获取分页
     *
     * @param sql      SQL语句
     * @param param    参数
     * @param pageNo   页码
     * @param pageSize 每页条数
     * @authorer: 樊高风
     * @date: 2020/5/2 19:17
     * @return:
     */
    Page<Map<String, Object>> selectBySqlToPage(String sql, Object[] param, int pageNo, int pageSize) throws Exception;


    /**
     * 功能描述：删除一条记录
     *
     * @param entity entity中的ID不能为空，如果ID为空，其他条件不能为空，都为空不予执行
     * @authorer: 樊高风
     * @date: 2020/5/2 19:18
     * @return:
     */
    boolean delete(T entity) throws Exception;

    /**
     * 功能描述：批量删除
     *
     * @param list
     * @throws Exception
     * @authorer: 樊高风
     * @date: 2020/5/2 19:19
     * @return: 返回受影响的行数
     */
    int deleteAll(List<T> list) throws Exception;

    /**
     * 功能描述：插入一条记录并返回插入后的ID
     *
     * @param entity 只要entity不等于null，就执行插入
     * @authorer: 樊高风
     * @date: 2020/5/2 19:21
     * @return:
     */
    PK insertAndReturnId(T entity) throws Exception;

    /**
     * 功能描述：插入一条记录自增ID
     *
     * @authorer: 樊高风
     * @date: 2020/5/2 19:23
     * @param:
     * @return:
     */
    boolean insert(T entity) throws Exception;

    /**
     * 功能描述：批量插入
     *
     * @param list
     * @authorer: 樊高风
     * @date: 2020/5/2 19:23
     * @return: 返回受影响的行数
     */
    int insertAll(List<T> list) throws Exception;

    /**
     * 功能描述：修改一条记录
     *
     * @param entity entity中的ID不能为空，如果ID为空，其他条件不能为空，都为空不予执行
     * @authorer: 樊高风
     * @date: 2020/5/2 19:24
     * @return:
     */
    boolean update(T entity) throws Exception;

}
