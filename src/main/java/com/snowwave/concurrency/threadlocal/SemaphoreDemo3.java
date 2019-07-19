package com.snowwave.concurrency.threadlocal;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collectors;

/**
 * Created by zhangfuqiang on 2018/11/25.
 * 同时只能有10个线程保存数据
 */
public class SemaphoreDemo3 {
    private static final int THREAD_COUNT = 30;
    private static ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_COUNT);
    private static Semaphore s = new Semaphore(10);

    public static void main(String[] args) {

        for (int i = 0; i < THREAD_COUNT; i++) {

            threadPool.execute(() -> {
                    try {
                        s.acquire();
                        System.out.println("save data");
                        s.release();
                    } catch (InterruptedException e) {

                    }
            });
        }
        threadPool.shutdown();

    }
}
