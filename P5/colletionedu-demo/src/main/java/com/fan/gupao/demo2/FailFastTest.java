package com.fan.gupao.demo2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 17:10 2020/5/27
 */
public class FailFastTest {


    private static final List<String> list = new ArrayList<>();

    public static void main(String[] args) {

        new ThreadAdd(list).start();
        new ThreadIterate(list).start();

    }
}
