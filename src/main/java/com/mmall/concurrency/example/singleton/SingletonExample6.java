package com.mmall.concurrency.example.singleton;

import com.mmall.concurrency.annotation.ThreadSafe;

/**
 * 饿汉模式
 * 静态域一定要注意书写顺序
 */
@ThreadSafe
public class SingletonExample6 {
    //私有构造函数
    private SingletonExample6(){

    }
    //单例对象
    private static SingletonExample6 instance = null;

    static {
        instance = new SingletonExample6();
    }

    //静态的工厂方法
    public static SingletonExample6 getInstance(){
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(getInstance().hashCode());
        System.out.println(getInstance());
    }
}
