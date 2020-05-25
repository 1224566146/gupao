package com.example.demo;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 13:48 2020/5/25
 */
public class TransferAccount implements Runnable {

    private Account fromAccount; // 转出账户
    private Account toAccount; // 转入账户
    private int amount;
    private Allocator allocator;

    public TransferAccount(Account fromAccount, Account toAccount, int amount,Allocator allocator) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
        this.allocator = allocator;
    }

    @Override
    public void run() {
        while (true) {
            if(allocator.apply(fromAccount, toAccount)) {

                try {
                    synchronized (fromAccount) {
                        synchronized (toAccount) {
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
                } finally {
                    allocator.free(fromAccount, toAccount);
                }
            }
        }

    }

    public static void main(String[] args) {

        Account fromAccount = new Account("樊高风", 100000);
        Account toAccount = new Account("张子琼", 300000);
        Allocator allocator = new Allocator();

        Thread t1 = new Thread(new TransferAccount(fromAccount, toAccount, 10,allocator));
        Thread t2 = new Thread(new TransferAccount(toAccount, fromAccount, 30,allocator));

        t1.start();
        t2.start();


    }
}
