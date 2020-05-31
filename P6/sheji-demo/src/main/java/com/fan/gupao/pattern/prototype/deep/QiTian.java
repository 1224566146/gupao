package com.fan.gupao.pattern.prototype.deep;

import java.io.*;
import java.util.Date;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 10:38 2020/2/19
 */
public class QiTian extends Monkey implements Cloneable, Serializable {

    public JinGuBang jinGuBang;

    public  QiTian(){
        //只是初始化
        this.birthday = new Date();
        this.jinGuBang = new JinGuBang();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return deepClone();
    }

    /**
     * 功能描述:深克隆
     * @authorer: 樊高风
     * @date: 2020/2/19 11:11
     * @param:
     * @return:
     */
    public Object deepClone(){
        try {

            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);
            oos.flush();
            oos.close();

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream  ois = new ObjectInputStream(bis);

            QiTian qiTian = (QiTian)ois.readObject();
            qiTian.birthday = new Date();
            return qiTian;

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 功能描述:浅克隆
     * @authorer: 樊高风
     * @date: 2020/2/19 11:15
     * @param:
     * @return:
     */
    public Monkey shallowClone(QiTian target){
        QiTian qiTian = new QiTian();
        qiTian.height = target.height;
        qiTian.weight = target.weight;

        qiTian.jinGuBang = target.jinGuBang;
        qiTian.birthday = new Date();
        return qiTian;
    }

}
