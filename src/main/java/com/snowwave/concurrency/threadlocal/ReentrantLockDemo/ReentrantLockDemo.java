package com.snowwave.concurrency.threadlocal.ReentrantLockDemo;

import jdk.nashorn.internal.runtime.ECMAErrors;

import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhangfuqiang on 2019/5/16.
 */
public class ReentrantLockDemo implements Runnable {
    private static ReentrantLock lock = new ReentrantLock(true);
    @Override
    public void run() {
        while (true){
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName());
            }catch (Exception e){

            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ReentrantLockDemo lockDemo = new ReentrantLockDemo();
        Thread t1 = new Thread(lockDemo);
        Thread t2 = new Thread(lockDemo);
        t1.start();
        t2.start();


    }

}
