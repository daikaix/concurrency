package com.mmall.concurrency.example.sync;

import com.mmall.concurrency.annotation.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@Slf4j
@NotThreadSafe
public class SynchronizedExample5 {
    volatile boolean inited = false;

    public String loadContext() throws Exception{
        Thread.sleep(2);
        return "inited";
    }

    public void doSomething(){

    }

    public static void main(String[] args) throws Exception{
        SynchronizedExample5 example5 = new SynchronizedExample5();
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(()->{
            try {
                example5.loadContext();
                example5.inited = true;
            } catch (Exception e){
                log.error("{}",e);
            }

        });
        service.execute(()->{
            while (!example5.inited){
                try {
                    Thread.sleep(5);
                } catch (Exception e){
                    log.error("{}",e);
                }
            }
            example5.doSomething();
        });

    }

}
