package com.mmall.concurrency.example.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class SynchronizedExample1 {
    //修饰一个代码块, 修饰对象为{}内部的数据
    //两次调用，模拟同时调用该方法
    public void test1(){
        synchronized (this){
            for (int i=0; i<10; i++){
                log.info("test1 - {}",i);
            }
        }
    }

    synchronized static void test2(){
        for (int i=0; i<10; i++){
            log.info("test1 - {}",i);
        }
    }

    public static void main(String[] args) {
        SynchronizedExample1 example1 = new SynchronizedExample1();
        SynchronizedExample1 example2 = new SynchronizedExample1();
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(()->{
            example1.test2();
        });
        service.execute(()->{
            //example1.test1();
            example2.test2();
        });
    }
}
