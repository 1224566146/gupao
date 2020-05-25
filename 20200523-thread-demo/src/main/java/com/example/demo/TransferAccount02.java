package com.example.demo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 13:48 2020/5/25
 */
public class TransferAccount02 implements Runnable {

    private Account fromAccount; // 转出账户
    private Account toAccount; // 转入账户
    private int amount;
    Lock fromLock = new ReentrantLock();
    Lock toLock = new ReentrantLock();

    public TransferAccount02(Account fromAccount, Account toAccount, int amount) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
    }

    @Override
    public void run() {
        while (true) {
            if (fromLock.tryLock()) { // 返回true / false
                if (toLock.tryLock()) { // 返回true / false
                    if (fromAccount.getBalance() >= amount) {
                        fromAccount.debit(amount);
                        toAccount.credit(amount);
                    }
                }
            }
            // 转出账户的余额
            System.out.println(fromAccount.getAccountName() + "->" + fromAccount.getBalance());
            // 转入账户的余额
            System.out.println(toAccount.getAccountName() + "->" + toAccount.getBalance());

        }
    }


    public static void main(String[] args) {

        Account fromAccount = new Account("樊高风", 100000);
        Account toAccount = new Account("张子琼", 300000);

        Thread t1 = new Thread(new TransferAccount02(fromAccount, toAccount, 10));
        Thread t2 = new Thread(new TransferAccount02(toAccount, fromAccount, 30));

        t1.start();
        t2.start();


    }
}
