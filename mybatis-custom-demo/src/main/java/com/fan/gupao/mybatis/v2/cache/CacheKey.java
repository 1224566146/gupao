package com.fan.gupao.mybatis.v2.cache;

/**
 * @Description: 缓存key
 * @Author: 樊高风
 * @Date: 13:08 2020/5/15
 */
public class CacheKey {
    private static final int DEFAULT_HASHCODE = 17; // 默认哈希值
    private static final int DEFAULT_MULTIPLIER = 37; // 倍数

    private int hashCode;
    private int count;
    private int multiplier;

   public CacheKey(){
        this.hashCode = DEFAULT_HASHCODE;
        this.count = 0;
        this.multiplier = DEFAULT_MULTIPLIER;
    }

    public int getCode(){
       return hashCode;
    }

    /**
     * 功能描述：计算CacheKey中的HashCode
     * @authorer: 樊高风
     * @date: 2020/5/15 13:11
     * @param:
     * @return:
     */
    public void update(Object object){
       int baseHashCode = object == null ? 1: object.hashCode();
       count++;
       baseHashCode *= count;
       hashCode = multiplier * hashCode + baseHashCode;
    }
}
