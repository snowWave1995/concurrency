package com.snowwave.concurrency.threadlocal;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by zhangfuqiang on 2018/11/21.
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        final CyclicBarrier  c = new CyclicBarrier(3,()->{
            System.out.println("all thread return");
        });

        new Thread(() -> {
            try {
                System.out.println("子线程" + Thread.currentThread().getName() + "正在执行");
//                Thread.sleep(3000);
                System.out.println("子线程" + Thread.currentThread().getName() + c.isBroken());
                System.out.println("子线程" + Thread.currentThread().getName() + c.getNumberWaiting());
                System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕");
                c.await(); //await()中同样可以传入等待时间
                System.out.println("子线程" + Thread.currentThread().getName() + "被阻塞后继续执行么");
            }catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                System.out.println("子线程" + Thread.currentThread().getName() + "正在执行");
//                Thread.sleep(3000);
                System.out.println("子线程" + Thread.currentThread().getName() + c.isBroken());
                System.out.println("子线程" + Thread.currentThread().getName() + c.getNumberWaiting());
                System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕");
                c.await();
                System.out.println("子线程" + Thread.currentThread().getName() + "被阻塞后继续执行么");
            }catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        try {
            System.out.println("子线程3 " + Thread.currentThread().getName() + "正在执行");
            System.out.println("子线程" + Thread.currentThread().getName() + c.isBroken());
            System.out.println("子线程" + Thread.currentThread().getName() + c.getNumberWaiting());
            System.out.println("子线程3 " + Thread.currentThread().getName() + "执行完毕");
            c.await();
        } catch (Exception e) {

        }
        System.out.println("结束");


    }
}
