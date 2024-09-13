package com.leetcode.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class RoundPrinter {

    private static volatile long number = 0;

    private static volatile int flag = 1;

    private static ReentrantLock reentrantLock = new ReentrantLock();
    private static Condition conditionOne = reentrantLock.newCondition();
    private static Condition conditionTwo = reentrantLock.newCondition();
    private static Condition conditionThird = reentrantLock.newCondition();



    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {

                while (true) {

                    try {
                        reentrantLock.lock();
                        while (flag != 1) {
                            conditionOne.await();
                        }
                        number++;
                        System.out.println(Thread.currentThread().getName() + ":" + number);

                        flag = 2;
                        conditionTwo.signal();

                    } catch (Exception e) {

                    } finally {
                        reentrantLock.unlock();
                    }
                }


            }
        }, "thread-1").start();
        new Thread(new Runnable() {
            @Override
            public void run() {

                while (true) {

                    try {
                        reentrantLock.lock();
                        while (flag != 2) {
                            conditionTwo.await();
                        }
                        number++;
                        System.out.println(Thread.currentThread().getName() + ":" + number);
                        Thread.sleep(500);
                        flag = 3;
                        conditionThird.signal();

                    } catch (Exception e) {

                    } finally {
                        reentrantLock.unlock();
                    }
                }

            }
        }, "thread-2").start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                while (true) {

                    try {
                        reentrantLock.lock();
                        while (flag != 3) {
                            conditionThird.await();
                        }
                        number++;
                        System.out.println(Thread.currentThread().getName() + ":" + number);
                        flag = 1;
                        conditionOne.signal();
                    } catch (Exception e) {

                    } finally {
                        reentrantLock.unlock();
                    }
                }

            }
        }, "thread-3").start();
    }
}
