package com.cheirmin.mythread.c002;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *  无锁优化--CAS 自旋锁
 */
public class T01_AtomicInteger {
    AtomicInteger cout = new AtomicInteger(0);

    void m(){
        for (int i = 0; i < 10000; i++) {
            //cout ++
            cout.incrementAndGet();
        }
    }

    public static void main(String[] args) {
        T01_AtomicInteger t = new T01_AtomicInteger();

        List<Thread> threadList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            //
            threadList.add(new Thread(t::m,"thread"+i));
        }

        threadList.forEach(o->o.start());

        threadList.forEach(o->{
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(t.cout);
    }
}
