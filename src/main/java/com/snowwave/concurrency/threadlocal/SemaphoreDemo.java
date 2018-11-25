package com.snowwave.concurrency.threadlocal;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by zhangfuqiang on 2018/11/25.
 * 每一秒只能有3个线程执行
 */
@Slf4j
public class SemaphoreDemo {

    private final static int threadCount = 20;
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        final Semaphore semaphore = new Semaphore(3);//并发数为3

        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i ;
            executorService.execute(() -> {
                try {
                    semaphore.acquire(); //获取一个许可
                    test(threadNum);     //需要做并发控制的代码
                    semaphore.release(); //释放一个许可
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
