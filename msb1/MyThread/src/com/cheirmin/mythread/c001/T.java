package com.cheirmin.mythread.c001;

/**
 * synchronized 关键字
 * 对某个对象加锁
 */
public class T implements Runnable{
    private static int count = 10;
    private  Object o = new Object();

//    public void m(){
//        synchronized (o){
//            //锁的是O ,每次操作的时候，要去看这把锁是不是ok的
//            count--;
//            System.out.println(Thread.currentThread().getName() + " count= " +count);
//        }
//    }
//
//    public void m1(){
//        synchronized (this){
//            //锁的是O ,每次操作的时候，要去看这把锁是不是ok的
//            count--;
//            System.out.println(Thread.currentThread().getName() + " count= " +count);
//        }
//    }
//
//    public  static void m2(){
//         //锁的是O ,每次操作的时候，要去看这把锁是不是ok的
//            count--;
//            System.out.println(Thread.currentThread().getName() + " count= " +count);
//    }

    public static void main(String[] args) {
        T t = new T();

        for (int i = 0; i < 5; i++) {
            new Thread(t,"Thread"+i).start();
        }
    }

    @Override
    public /* synchronized */ void run() {
        count--;
        System.out.println(Thread.currentThread().getName() + " count= " +count);
    }
}
