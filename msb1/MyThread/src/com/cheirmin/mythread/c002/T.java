package com.cheirmin.mythread.c002;

/**
 * synchronized 关键字
 * 对某个对象加锁
 * @author Cheirmin
 */
public class T {
    private static int count = 10;

    public synchronized void m() {
        count--;
        System.out.println(Thread.currentThread().getName() + " count= " +count);
    }

    public static void mm() {
        synchronized(T.class){
            count--;
        }
    }

}
