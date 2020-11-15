package com.cheirmin.mythread.c002;

import java.util.concurrent.TimeUnit;

/**
 * volatile 关键字
 * 堆内存：所有线程共享内存
 * 线程自己的内存：所有线程都会有自己的一区区域，
 * 线程会把堆内存的变量copy一份过去
 * 所有线程都有自己的一个内存区域，啥时候running写回堆内存，不好控制
 */
public class T {
    /* volatile */ int running = 1;

    void m(){
        System.out.println("m start");

        while (running==1){
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("m end");
    }

    public static void main(String[] args) {
        T t  = new T();
        new Thread(t::m,"t1").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t.running = 0;
    }
}
