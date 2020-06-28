package com.fan.gupao.decorator.logger;

import org.slf4j.Logger;

import java.io.*;

/**
 * @author 樊高风
 * @date 2020/6/28
 */
public class Test {

    private static final Logger LOGGER = JsonLoggerFactory.getLogger(Test.class);


    public static void main(String[] args) {
        LOGGER.error("系统错误");


        try {
            InputStream in = new FileInputStream("");

            BufferedInputStream bis = new BufferedInputStream(in);

            bis.read();
            bis.close();

            BufferedReader br = new BufferedReader(new FileReader(""));
            br.readLine();

            BufferedReader bs = new BufferedReader(new StringReader(""));
            bs.readLine();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
