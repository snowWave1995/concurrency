package com.snowwave.concurrency.threadlocal.future;

import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by zhangfuqiang on 2019/5/12.
 */
@Slf4j
public class FutureTaskExample {

    static class Task implements Callable<String> {

        @Override
        public String call() throws Exception {
            log.info("do task in callable");
            Thread.sleep(5000); //模拟任务执行了5秒
            return "Done";
        }
    }

    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newCachedThreadPool();

        FutureTask<String> futureTask = new FutureTask<>(() ->{return "OK";});

        executorService.submit(futureTask);
        while (!futureTask.isDone())
            log.info("task is doing");
        String res = futureTask.get();
        log.info("res:{}",res);
        BlockingQueue blockingQueue;
    }
}
