package com.LocksExample;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TryLock {

    private final Lock lock = new ReentrantLock(true);  // true = fairness enabled

    public void func() {
        boolean b = false;
        System.out.println(Thread.currentThread().getName() +" Attempting lock.....");
        try {
            b = lock.tryLock(2, TimeUnit.SECONDS);
            if(b) {
                System.out.println("Lock acquired " + Thread.currentThread().getName());
                Thread.sleep(2000);
            } else {
                System.out.println("Lock not acquired "+ Thread.currentThread().getName());
            }
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        } finally {
            if(b){
                lock.unlock();
            }
        }
    }
    public static void main(String[] args) {
        TryLock tryLock = new TryLock();
        Thread t1 = new Thread(tryLock::func, "Thread 1");
        Thread t2 = new Thread( tryLock::func, "Thread 2");
        Thread t3 = new Thread(tryLock::func, "Thread 3");
        Thread t4 = new Thread(tryLock::func, "Thread 4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }
}
