package com.mmall.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
@Slf4j
public class CountDownLatchExample1 {

    private static final int threadCount = 200;

    public static void main(String[] args) throws Exception {
        ExecutorService service = Executors.newCachedThreadPool();

        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);

        for (int i=0; i<threadCount; i++){
            final int threadNum = i;
            service.execute(()->{
                try{
                    test(threadNum);
                } catch (Exception e){
                    log.error("exception",e);
                } finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        log.info("finish");
        service.shutdown();
    }

    public static void test(int i) throws Exception{
        Thread.sleep(100);
        log.info("{}",i);
        Thread.sleep(100);
    }
}