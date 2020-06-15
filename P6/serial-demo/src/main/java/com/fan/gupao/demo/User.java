package com.fan.gupao.demo;

import java.io.*;

/**
 * @author 樊高风
 * @date 2020/6/15 15:18
 */
public class User  extends Person implements Serializable  {


    private static final long serialVersionUID = -2586454330418732234L;

    private String name;

    private int age;

    /**
     * 功能描述: 重写writeObject方法
     * @param
     * @return
     * @throws
     * @author 樊高风
     * @date 2020/6/15 15:19
     */
    private void writeObject(ObjectOutputStream out) throws IOException{
        out.defaultWriteObject();
        out.writeInt(age);
    }

    /**
     * 功能描述: 重写readObject方法
     * @param
     * @return
     * @throws
     * @author 樊高风
     * @date 2020/6/15 15:20
     */
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        age = in.readInt();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
