package com.LocksExample;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccountLock {

    private final Lock lock = new ReentrantLock();
    // lock.lock();
    // lock.trylock();
    // lock.unlock();
//    lock()	Waits forever to acquire the lock
//    tryLock()	Immediately returns true/false
//    tryLock(timeout, unit)	Waits a little, then gives up

    private int balance = 1000;

    public void withRaw(int amount) throws InterruptedException {        
        System.out.println(Thread.currentThread().getName() +" Attempting task withrow.");
        try {
            lock.lock();
            if(amount <= balance) {
                System.out.println(Thread.currentThread().getName() +" proceeding withrow task : "+ amount);
                Thread.sleep(3000);
                balance -= amount;
                System.out.println("   Withraw ended. Balance : "+ balance);
                System.out.println("===============================================================");
            }
        } catch(Exception e) {
            Thread.currentThread().interrupt();
        }
        finally {
            lock.unlock();
        }
    }

}
