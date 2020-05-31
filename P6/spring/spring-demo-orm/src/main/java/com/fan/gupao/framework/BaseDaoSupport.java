package com.fan.gupao.framework;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.core.common.jdbc.BaseDao;
import javax.core.common.utils.GenericsUtils;
import javax.sql.DataSource;
import java.io.Serializable;

/**
 * @Description: BaseDao 扩展类，主要功能是支持自动拼装sql语句，必须继承方可使用
 * 需要重写和实现以下三个方法
 *  设定主键列
 * private String getPKColumn() { return "id"}
 * 重写对象反转为Map的方法
 * protected Map<String, Object> parse(Object entity) {return utils.parse((Entity)entity);}
 * 重写结果反转为对象的方法
 * protected Entity mapRow(ResultSet rs, int rowNum) throws SQLException {return utils.parse(rs);}
 * @Author: 樊高风
 * @Date: 14:48 2020/5/9
 */
public abstract class BaseDaoSupport<T extends Serializable, PK extends Serializable> implements BaseDao<T, PK> {
    private Logger logger = Logger.getLogger(BaseDaoSupport.class);

    private String tableName = "";

    private JdbcTemplate jdbcTemplateWrite;
    private JdbcTemplate jdbcTemplateReadOnly;

    private DataSource dataSourceReadOnly;
    private DataSource dataSourceWrite;

    private EntityOperation<T> op;

    @SuppressWarnings("unchecked")
    protected BaseDaoSupport(){
        try {
//            Class<T> entityClass = (Class<T>)((ParameterizedType)getClass().getGenericSuperclass())
//                    .getActualTypeArguments()[0];
            Class<T> entityClass = GenericsUtils.getSuperClassGenricType(getClass(), 0);
            op = new EntityOperation<T>(entityClass, getPKColumn());
            setTableName(op.get);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    

    


    public DataSource getDataSourceReadOnly() {
        return dataSourceReadOnly;
    }

    public DataSource getDataSourceWrite() {
        return dataSourceWrite;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}
