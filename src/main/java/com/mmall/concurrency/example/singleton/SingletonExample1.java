package com.mmall.concurrency.example.singleton;

import com.mmall.concurrency.annotation.NotThreadSafe;

/**
 * 懒汉模式
 */
@NotThreadSafe
public class SingletonExample1 {
    //私有构造函数
    private SingletonExample1(){

    }
    //单例对象
    private static SingletonExample1 instance = null;

    //静态的工厂方法
    public static SingletonExample1 getInstance(){
        if(instance == null){
            instance = new SingletonExample1();
        }
        return instance;
    }
}
