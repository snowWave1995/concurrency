package com.snowwave.concurrency.threadlocal.future;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by zhangfuqiang on 2019/5/12.
 */
@Slf4j
public class FutureExample {

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

        //用future接收一个线程的返回结果  记住 是New一个task
        Future<String> future = executorService.submit(new Task());
        log.info("do something in main");
        Thread.sleep(1000);
        String res = future.get();//get方法会阻塞调用它的线程
        log.info("res:{}",res);
    }
}
