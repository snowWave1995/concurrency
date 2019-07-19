package com.snowwave.concurrency.threadlocal.Synchronized;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by zhangfuqiang on 2019/5/15.
 */
public class SyncThread implements Runnable{
    private static AtomicInteger count = new AtomicInteger();

    public SyncThread() {
        this.count = count;
    }

    public  void method() {

            for (int i = 0; i < 5; i ++) {
                try {
                    System.out.println(Thread.currentThread().getName() + ":" + count.addAndGet(1));
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

    }

    public  void run() {
        method();
    }

    public static void main(String[] args) {
        SyncThread syncThread1 = new SyncThread();
        SyncThread syncThread2 = new SyncThread();
        Thread thread1 = new Thread(syncThread1, "SyncThread1");
        Thread thread2 = new Thread(syncThread2, "SyncThread2");
        thread1.start();
        thread2.start();
    }

}
