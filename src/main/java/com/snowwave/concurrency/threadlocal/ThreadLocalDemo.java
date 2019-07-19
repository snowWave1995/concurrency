package com.snowwave.concurrency.threadlocal;

import java.text.SimpleDateFormat;
import java.util.logging.SimpleFormatter;

/**
 * Created by zhangfuqiang on 2019/5/14.
 */
public class ThreadLocalDemo implements Runnable{

    private static final ThreadLocal<SimpleDateFormat> formatter = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyyMMdd HHmm"));

    @Override
    public void run() {
        System.out.println("Thread Name= "+Thread.currentThread().getName()+" default Formatter = "+formatter.get().toPattern());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        formatter.set(new SimpleDateFormat()); //set的是ThreadLocalMap的value key是一个ThreadLocal引用
        System.out.println("Thread Name= "+Thread.currentThread().getName()+" formatter = "+formatter.get().toPattern());
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadLocalDemo obj = new ThreadLocalDemo();
        for (int i = 0 ; i < 10 ;i++){
            Thread t = new Thread(obj,"线程"+i);
            Thread.sleep(1000);
            t.start();
        }
    }
}
