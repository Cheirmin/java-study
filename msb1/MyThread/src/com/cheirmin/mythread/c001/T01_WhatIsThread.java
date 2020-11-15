package com.cheirmin.mythread.c001;

import java.util.concurrent.TimeUnit;

/**
 * @author Cheirmin
 */
public class T01_WhatIsThread {
    private static class T1 extends Thread{
        @Override
        public void run(){
            for (int i = 0; i < 10; i++) {
                try {
                    TimeUnit.MICROSECONDS.sleep(1);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("T1");
            }
        }
    }

    public static void main(String[] args) {
        //方法调用--并没启动线程
//        new T1().run();
        //启动线程
        new T1().start();

        for (int i = 0; i < 10; i++) {
            try {
                TimeUnit.MICROSECONDS.sleep(1);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("Main");
        }
    }
}
