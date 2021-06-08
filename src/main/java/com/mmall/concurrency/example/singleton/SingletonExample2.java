package com.mmall.concurrency.example.singleton;

import com.mmall.concurrency.annotation.NotThreadSafe;
import com.mmall.concurrency.annotation.ThreadSafe;

/**
 * 饿汉模式
 * 类装载时创建,可能会导致性能问题
 * 需要：肯定需要使用，构造没有过多操作
 */
@ThreadSafe
public class SingletonExample2 {
    //私有构造函数
    private SingletonExample2(){

    }
    //单例对象
    private static SingletonExample2 instance = new SingletonExample2();

    //静态的工厂方法
    public static SingletonExample2 getInstance(){
        return instance;
    }
}
