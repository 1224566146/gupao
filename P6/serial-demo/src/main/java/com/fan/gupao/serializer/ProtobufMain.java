package com.fan.gupao.serializer;

import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;

/**
 * @author 樊高风
 * @date 2020/6/15 15:55
 */
public class ProtobufMain {

    public static void main(String[] args) throws InvalidProtocolBufferException {

        UserProto.User user = UserProto.User.newBuilder().setName("Mic")
                .setAge(18).setStatus(-300).build();
        ByteString bytes = user.toByteString();
        System.out.println(bytes.size());

        //-300 ->zigzag(可逆的算法) 599  -> varint  (-41 4)

        for (Byte aByte : bytes) {
            System.out.print(aByte+" ");
            //  Mic / 18
            //
            //10 3 77 105 99 16 18
            //10 3 77 105 99 16 -84 2

            //10 3 77 105 99 16 -84 2 24 -41 4
        }

        System.out.println();
        UserProto.User userRever = UserProto.User.parseFrom(bytes);
        System.out.println(userRever);
    }
}
