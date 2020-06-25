package com.fan.gupao.demo;

import com.fan.gupao.spi.DataBaseDriver;

import java.util.ServiceLoader;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ServiceLoader<DataBaseDriver> serviceLoader = ServiceLoader.load(DataBaseDriver.class);
        for (DataBaseDriver dataBaseDriver : serviceLoader) {
            System.out.println(dataBaseDriver.buildConnect("Test"));
        }
        System.out.println( "Hello World!" );
    }
}
