package com.fan.gupao.mybatis.v2.executor;

import com.fan.gupao.mybatis.v2.cache.CacheKey;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 带缓存的执行器，用于装饰基本执行器
 * @Author: 樊高风
 * @Date: 13:02 2020/5/15
 */
public class CachingExecutor implements Executor {

    private Executor delegate;

    private static final Map<Integer,Object> cache = new HashMap<>();

    public CachingExecutor(Executor delegate) {
        this.delegate = delegate;
    }

    @Override
    public <T> T query(String statement, Object[] paramter, Class pojo) {
        // 计算CacheKey
        CacheKey cacheKey = new CacheKey();
        cacheKey.update(statement);
        cacheKey.update(joinStr(paramter));
        // 是否拿到缓存
        if(cache.containsKey(cacheKey.getCode())){
            // 命中缓存
            System.out.println("【命中缓存】");
            return (T) cache.get(cacheKey.getCode());
        }else{
            // 没有的话调用被装饰的SimpleExecutor从数据库查询
            Object obj = delegate.query(statement, paramter, pojo);
            cache.put(cacheKey.getCode(), obj);
            return (T)obj;
        }
    }

    /**
     * 功能描述：为了命中缓存，把Object[]转换成逗号拼接的字符串，因为对象的HashCode都不一样
     * @authorer: 樊高风
     * @date: 2020/5/15 13:06
     * @param:
     * @return:
     */
    public String joinStr(Object[] objs){
        StringBuffer sb = new StringBuffer();
        if(objs !=null && objs.length > 0){
            for (Object obj : objs) {
                sb.append(obj.toString()+",");
            }
        }
        int len = sb.length();
        if(len > 0){
            sb.deleteCharAt(len-1);
        }
        return sb.toString();
    }
}
