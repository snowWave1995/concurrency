package com.snowwave.concurrency.threadlocal;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhangfuqiang on 2018/11/25.
 */
@Slf4j
public class SemaphoreDemo2 {

    private final static int threadCount = 20;
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        final Semaphore semaphore = new Semaphore(3);//并发数为3

        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i ;
            executorService.execute(() -> {
                try {
                    if (semaphore.tryAcquire(5000, TimeUnit.MILLISECONDS)) { //尝试5秒获取许可，五秒之内都执行，其他的抛弃
                        test(threadNum);
                        semaphore.release();
                    }

                }catch (Exception e) {
                    log.info("exception",e);
                }
            });
        }
        executorService.shutdown();
    }

    private static void test(int threadNum) throws Exception {

        log.info("{}",threadNum);
        Thread.sleep(1000);
    }
}
