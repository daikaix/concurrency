package com.mmall.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class CyclicBarrierExample3 {

    public static CyclicBarrier barrier = new CyclicBarrier(5,() -> {
        log.info("call back is running");
    });

    public static void main(String[] args) throws Exception{
        ExecutorService service = Executors.newCachedThreadPool();

        for (int i=0; i<10; i++){
            final int threadNum = i;
            Thread.sleep(1000);
            service.execute(()->{
                try{
                    race(threadNum);
                } catch (Exception e){
                    log.error("{}",e);
                }
            });
        }
        service.shutdown();
    }

    public static void race(int i) throws Exception{
        Thread.sleep(1000);
        log.info("{} is ready",i);
        barrier.await();

        log.info("continue");
    }
}
