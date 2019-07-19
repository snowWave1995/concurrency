package com.snowwave.concurrency.threadlocal;

/**
 * Created by zhangfuqiang on 2019/5/14.
 */
public class DeadLockDemo {
    private static  Object resource1 = new Object();
    private static Object resource2 = new Object();

    public static void main(String[] args) throws InterruptedException {
        new Thread(() ->{
            synchronized (resource1){
                System.out.println(Thread.currentThread() + "get r1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting get r2");
                synchronized (resource2){
                    System.out.println(Thread.currentThread() + "already get r2");
                }
                System.out.println(Thread.currentThread() + "继续主修");
            }
        },"线程1").start();

        new Thread(() ->{
            synchronized (resource2){
                System.out.println(Thread.currentThread() + "get r2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting get r1");
                synchronized (resource1){
                    System.out.println(Thread.currentThread() + "already get r1");
                }
                System.out.println(Thread.currentThread() + "继续主修");
            }
        },"线程2").start();
        System.out.println("主线程继续执行");

        new Thread(){
            @Override
            public void run() {
                resource1 = null;
            }
        }.start();
        Thread.sleep(1000);
        System.out.println(resource1);
    }
}
