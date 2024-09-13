package com.leetcode.thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

class ZeroEvenOdd {
    private int n;

    private Lock lock = new ReentrantLock();

    private Condition zero=lock.newCondition();

    private Condition even=lock.newCondition();

    private Condition odd=lock.newCondition();

    private volatile AtomicInteger seqs = new AtomicInteger(0);

    private volatile  int status=0;

    public ZeroEvenOdd(int n) {
        this.n=n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        while (status!=0)
            zero.await();
        printNumber.accept(0);
        int val = seqs.incrementAndGet();
        if((val&1)==1) {
            even.signal();
            status=1;
        }else {
            odd.signal();
            status=2;
        }
        lock.unlock();
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        while (status!=1)
               even.await();
        printNumber.accept(seqs.get());
        zero.signal();
        status=0;
        lock.unlock();
    }
    public void odd(IntConsumer printNumber) throws InterruptedException {
         lock.lock();
         while (status!=2)
                odd.await();
         printNumber.accept(seqs.get());
         zero.signal();
         status=0;
         lock.unlock();
    }
    public static void main(String[] args) {
            // Integer n =Integer.parseInt(args[0]);
            Integer n =4;
            ZeroEvenOdd zeo = new ZeroEvenOdd(n);
            IntConsumer consumer = new IntConsumer() {
                @Override
                public void accept(int value) {
                    System.out.print(value);
                }
            };
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 1; i <= n; i++) {
                        try {
                            zeo.zero(consumer);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int loops = ((n & 1) == 1) ? n / 2 + 1 : n / 2;
                    for (int i = 1; i <= loops; i++) {
                        try {
                            zeo.even(consumer);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int loops = n / 2;
                    for (int i = 1; i <= loops; i++) {
                        try {
                            zeo.odd(consumer);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
    }
}
