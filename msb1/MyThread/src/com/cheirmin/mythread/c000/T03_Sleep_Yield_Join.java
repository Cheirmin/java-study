package com.cheirmin.mythread.c000;

/**
 * @author Cheirmin
 */
public class T03_Sleep_Yield_Join {
    public static void main(String[] args) {
//        testSleep();
//        testYield();
        testJoin();
    }

    /**
     * 睡眠,过一段时间后继续执行
     */
    static void testSleep(){
        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                System.out.println("A" + i);

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    /**
     * 执行中退出，重新进入等待队列（返回到就绪状态）
     */
    static void testYield(){
        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                System.out.println("A"+i);
                if (i%10==0) {
                    Thread.yield();
                }
            }
        }).start();
    }

    /**
     * 把一个线程加入到另一个线程
     */
    static void testJoin(){
        Thread t1 = new Thread(()->{
            System.out.println("A is start");
            for (int i = 0; i < 100; i++) {
                System.out.println("A"+i);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("A is end");
        });

        Thread t2 = new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("B is start");
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("B is end");
        });
        t1.start();
        t2.start();
    }
}
