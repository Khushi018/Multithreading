package com.LocksExample;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {

    private Lock lock = new ReentrantLock();

    public void outer(){
        lock.lock();
        try {
            System.out.println("outer");
        } finally {
            lock.unlock();
        }
    }

    public void inner(){
        lock.lock();

        try{
            System.out.println("inner");
        } finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {
        ReentrantLockExample reentrantLockExample = new ReentrantLockExample();
        reentrantLockExample.outer();
        reentrantLockExample.inner();
    }
}
