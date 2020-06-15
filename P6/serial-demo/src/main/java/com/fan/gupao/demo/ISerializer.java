package com.fan.gupao.demo;

/**
 * @author 樊高风
 * @date 2020/6/15 15:27
 */
public interface ISerializer {

    <T> byte[] serialize(T obj);

    <T> T deserialize(byte[] data);
}
