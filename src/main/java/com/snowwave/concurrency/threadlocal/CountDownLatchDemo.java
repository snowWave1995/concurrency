package com.snowwave.concurrency.threadlocal;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhangfuqiang on 2018/11/20.
 */
public class CountDownLatchDemo {
//    private static  final CountDownLatch latch = new CountDownLatch(2);
//    public static void main(String[] args) {
//
//
//        new Thread(() -> {
//            try {
//                System.out.println("子线程" + Thread.currentThread().getName() + "正在执行");
//                Thread.sleep(10);
//                System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕");
//                latch.countDown();
//            }catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();
//
//        new Thread(() -> {
//            try {
//                System.out.println("子线程" + Thread.currentThread().getName() + "正在执行");
//                Thread.sleep(10);
//                System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕");
//                latch.countDown();
//            }catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();
//
//        try {
//            System.out.println("等待2个子线程执行完毕...");
//            latch.await();
//            System.out.println("继续执行主线程");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//    }

   // private static
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(()->{
                    try {
                        Thread.sleep(10);
                        System.out.println("child threadOne over");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        countDownLatch.countDown();
                        System.out.println("子线1继续执行");
                    }

        });

        executorService.submit(()-> {
                    try {
                        Thread.sleep(10);
                        System.out.println("child threadTwo over");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        countDownLatch.countDown();//原子操作，同时只能有一个线程操作计数器
                        System.out.println("子线2继续执行");
                    }

        });

        Thread.sleep(1000);
        System.out.println("wait all child thread over");

        try {
            countDownLatch.await(2, TimeUnit.SECONDS);//调用await()会一直阻塞，直到countDown计数器为0 （大门一直关闭，直到计数器为0打开），并发继续执行
            System.out.println("all child thread over");      //调用await(2, TimeUnit.SECONDS) ,超过这个时间，（大门打开）线程不阻塞，并发继续执行
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }
}
