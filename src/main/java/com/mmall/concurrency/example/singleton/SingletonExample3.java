package com.mmall.concurrency.example.singleton;

import com.mmall.concurrency.annotation.NotRecommend;
import com.mmall.concurrency.annotation.NotThreadSafe;
import com.mmall.concurrency.annotation.ThreadSafe;

/**
 * 懒汉模式
 */
@ThreadSafe
@NotRecommend
public class SingletonExample3 {
    //私有构造函数
    private SingletonExample3(){

    }
    //单例对象
    private static SingletonExample3 instance = null;

    //静态的工厂方法
    public synchronized static SingletonExample3 getInstance(){
        if(instance == null){
            instance = new SingletonExample3();
        }
        return instance;
    }
}
