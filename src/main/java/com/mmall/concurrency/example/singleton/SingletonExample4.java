package com.mmall.concurrency.example.singleton;

import com.mmall.concurrency.annotation.NotRecommend;
import com.mmall.concurrency.annotation.NotThreadSafe;
import com.mmall.concurrency.annotation.ThreadSafe;

/**
 * 双重同步锁单例模式,线程不安全的
 */
@NotThreadSafe
@NotRecommend
public class SingletonExample4 {
    //私有构造函数
    private SingletonExample4(){

    }
    //单例对象
    private static SingletonExample4 instance = null;

    //静态的工厂方法
    public static SingletonExample4 getInstance(){
        if(instance == null){ //B 直接输出instance，而此时A还未初始化完成
            synchronized (SingletonExample4.class){
                if(instance == null){
                    instance = new SingletonExample4(); // A - 3 (1,3,2)
                }
            }
        }
        return instance;
    }

    /**
     * 1. memory = allocate() 分配对象空间
     * 2. ctorInstance() 初始化对象
     * 3. instance = memory instance指向内存
     *
     * JVM和cpu优化，导致指令重排
     * 1，3，2
     */
}
