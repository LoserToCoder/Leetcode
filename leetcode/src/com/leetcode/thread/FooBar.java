package com.leetcode.thread;


import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class FooBar {

    private  static Lock lock=new ReentrantLock();

    private  static Condition foo=lock.newCondition();

    private  static  Condition bar=lock.newCondition();

    private volatile static boolean isRunningFoo=true;

    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {


            lock.lock();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            bar.signal();
            isRunningFoo=false;
            while(!isRunningFoo)
                   foo.await();
            lock.unlock();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            lock.lock();
            while (isRunningFoo)
                bar.await();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            foo.signal();
            isRunningFoo=true;
            lock.unlock();
        }
    }
    public static void main(String[] args) throws Exception{

       Integer n = Integer.parseInt(args[0]);
        FooBar fooBar = new FooBar(n);
       final   Runnable fooRun=new Runnable() {
             @Override
             public void run() {
                     System.out.print("foo");
             }
         };
         Runnable barRun=new Runnable() {
             @Override
             public void run() {
                     System.out.print("bar");
             }
         };
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fooBar.foo(fooRun);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override

            public void run() {
                try {
                    fooBar.bar(barRun);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}















