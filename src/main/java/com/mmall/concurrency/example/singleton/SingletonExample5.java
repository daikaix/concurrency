package com.mmall.concurrency.example.singleton;

import com.mmall.concurrency.annotation.NotRecommend;
import com.mmall.concurrency.annotation.NotThreadSafe;

/**
 * 双重同步锁单例模式,通过volatile限制指令重排
 */
@NotThreadSafe
@NotRecommend
public class SingletonExample5 {
    //私有构造函数
    private SingletonExample5(){

    }
    //单例对象 通过volatile限制指令重排
    private volatile static SingletonExample5 instance = null;

    //静态的工厂方法
    public static SingletonExample5 getInstance(){
        if(instance == null){ //B 直接输出instance，而此时A还未初始化完成
            synchronized (SingletonExample5.class){
                if(instance == null){
                    instance = new SingletonExample5(); // A - 3 (1,3,2)
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
