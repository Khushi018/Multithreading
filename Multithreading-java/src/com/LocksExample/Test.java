package com.LocksExample;

public class Test {

    public static void main(String[] args) {
    //  BankAccount bankAccount = new BankAccount();
        BankAccountLock bankAccount = new BankAccountLock();

        Runnable task = new Runnable() {
            @Override
            public void run() {
                try {
                    bankAccount.withRaw(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread t1 = new Thread(task, " Thread 1");
        Thread t2 = new Thread(task, " Thread 2");
        t1.start();
        t2.start();


    }
}
