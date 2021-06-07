package com.mmall.concurrency.example.atomic;

import com.mmall.concurrency.annotation.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongArray;

@Slf4j
@ThreadSafe
public class AtomicExample7 {
    private static AtomicLongArray array = new AtomicLongArray(10);
    private static AtomicInteger index = new AtomicInteger(0);

    public static void main(String[] args) throws Exception{
        ExecutorService service = Executors.newCachedThreadPool();
        final CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i=0; i<10; i++){
            service.execute(()->{
                array.addAndGet(index.get(),index.get());
                index.getAndIncrement();
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        service.shutdown();
        for (int i=0; i<10; i++){
            System.out.println(array.get(i));
        }
    }
}
