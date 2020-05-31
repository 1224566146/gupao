package com.example.demo;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 13:44 2020/5/25
 */
public class Account {

    private String accountName;
    private int balance;

    public Account(String accountName, int balance) {
        this.accountName = accountName;
        this.balance = balance;
    }


    public void debit(int amount) {
        // 更新转出方余额
        this.balance -= amount;
    }

    public void credit(int amount) {
        // 更新转入方余额
        this.balance += amount;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}