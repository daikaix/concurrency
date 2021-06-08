package com.mmall.concurrency.example.singleton;

import com.mmall.concurrency.annotation.Recommend;
import com.mmall.concurrency.annotation.ThreadSafe;

/**
 * 枚举模式，最安全的
 */
@ThreadSafe
@Recommend
public class SingletonExample7 {
    private SingletonExample7(){}

    public static SingletonExample7 getInstance(){
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton{
        INSTANCE;

        private SingletonExample7 singleton;

        //JVM保证该方法只被实例化一次
        Singleton(){
            singleton = new SingletonExample7();
        }

        public SingletonExample7 getInstance() {
            return singleton;
        }
    }
}
