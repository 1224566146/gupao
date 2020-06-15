package com.fan.gupao.demo;

/**
 * @author 樊高风
 * @date 2020/6/15 15:41
 */
public class SerializerMain {


    public static void main(String[] args) {

        ISerializer iSerializer = new HessianSerializer();

        User user = new User();
        user.setName("樊高风");
        user.setAge(18);

        byte[] bytes = iSerializer.serialize(user);
        System.out.println(new String(bytes));
        System.out.println(bytes.length);
        for (byte aByte : bytes) {
            System.out.print(aByte+" ");
        }
        System.out.println();
        User user1 = iSerializer.deserialize(bytes);
        System.out.println(user1);


    }

}
