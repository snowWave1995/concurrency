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
                    }

        });

        executorService.submit(()-> {
                    try {
                        Thread.sleep(10);
                        System.out.println("child threadTwo over");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        countDownLatch.countDown();
                    }

        });

        Thread.sleep(1000);
        System.out.println("wait all child thread over");

        try {
            countDownLatch.await(2, TimeUnit.SECONDS);
            System.out.println("all child thread over");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }
}
