package com.fan.gupao.demo;

import java.io.*;

/**
 * @author 樊高风
 * @date 2020/6/15 15:30
 */
public class JavaSerializer implements ISerializer {


    // 序列化
    @Override
    public <T> byte[] serialize(T obj) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(byteArrayOutputStream);
//            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("user"));
            outputStream.writeObject(obj);
            return byteArrayOutputStream.toByteArray();
        }catch (Exception e){
            e.printStackTrace();
        }
        return new byte[0];
    }

    // 反序列化
    @Override
    public <T> T deserialize(byte[] data) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
//            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            return (T) objectInputStream.readObject();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
