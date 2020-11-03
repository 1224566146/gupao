package com.fan.simple;

/**
 *
 */
public class HashCalculate {

    public static void main(String[] args) {

        // 要放在第17个分区存储
        System.out.println(Math.abs("gp-assign-group-1".hashCode() % 50));

    }
}
