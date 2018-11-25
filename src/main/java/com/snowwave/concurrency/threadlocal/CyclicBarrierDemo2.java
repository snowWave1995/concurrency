package com.snowwave.concurrency.threadlocal;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhangfuqiang on 2018/11/25.
 * 假设一个任务分三步，每一步让两个线程并发执行，下一步执行的条件是上一步必须执行完。
 */
public class CyclicBarrierDemo2 {
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.execute(() -> {
            try {
                System.out.println(Thread.currentThread() + "step1");
                cyclicBarrier.await();

                System.out.println(Thread.currentThread() + "step2");
                cyclicBarrier.await();

                System.out.println(Thread.currentThread() + "step3");
            }catch (Exception e) {

            }
        });

        executorService.execute(() -> {
            try {
                System.out.println(Thread.currentThread() + "step1");
                cyclicBarrier.await();

                System.out.println(Thread.currentThread() + "step2");
                cyclicBarrier.await();

                System.out.println(Thread.currentThread() + "step3");
            }catch (Exception e) {

            }
        });

        executorService.shutdown();
    }
}
