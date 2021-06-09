package com.mmall.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

@Slf4j
public class SemaphoreExample3 {

    private static final int threadCount = 200;

    public static void main(String[] args) throws Exception {
        ExecutorService service = Executors.newCachedThreadPool();

        final Semaphore semaphore = new Semaphore(20);

        for (int i=0; i<threadCount; i++){
            final int threadNum = i;
            service.execute(()->{
                try{
                    if(semaphore.tryAcquire(2,5000, TimeUnit.SECONDS)){
                        test(threadNum);
                        semaphore.release(2);
                    }

                } catch (Exception e){
                    log.error("exception",e);
                }
            });
        }
        service.shutdown();
        log.info("finish");
    }

    public static void test(int i) throws Exception{
        Thread.sleep(1000);
        log.info("{}",i);
    }
}
