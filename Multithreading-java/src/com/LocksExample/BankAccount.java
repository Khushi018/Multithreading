package com.LocksExample;

public class BankAccount {

    private int balance =1000;

    public synchronized void withRaw(int amount) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() +" Attempting task withrow.");
        if(amount <= balance) {
            System.out.println(Thread.currentThread().getName() +" proceeding to Withraw : "+ amount);
            Thread.sleep(3000);
            balance -= amount;
            System.out.println(Thread.currentThread().getName() +" Withraw ended. Balance : "+ balance);
            System.out.println("===============================================================");
        } else {
            System.out.println(Thread.currentThread().getName() +" insufficient amount");
        }
    }
}
