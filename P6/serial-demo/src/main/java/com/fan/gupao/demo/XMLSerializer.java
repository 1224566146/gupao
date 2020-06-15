package com.fan.gupao.demo;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * @author 樊高风
 * @date 2020/6/15 15:44
 */
public class XMLSerializer implements ISerializer {

    XStream stream = new XStream(new DomDriver());

    @Override
    public <T> byte[] serialize(T obj) {
        return stream.toXML(obj).getBytes();
    }

    @Override
    public <T> T deserialize(byte[] data) {
        return (T) stream.fromXML(new String(data));
    }
}
