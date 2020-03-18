package com.leetcode.thread;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class ThreadRound {


    private final static Unsafe UNSAFE;

    static {

        try {
            Class<?> clazz=Class.forName("sun.misc.Unsafe");
            Field field=clazz.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            UNSAFE=(Unsafe) field.get(null);
        } catch (Exception e) {
            throw new Error();
        }
    }


    public void main(Thread thread) {
        for(int i=1;i<=50;i++){
            System.out.println("主线程："+i);
        }
        UNSAFE.unpark(thread);
        UNSAFE.park(false,0L);

    }

    public void sub(Thread thread) {
        UNSAFE.park(false,0l);
        for(int i=1;i<=10;i++){
            System.out.println("子线程："+i);
        }
        UNSAFE.unpark(thread);

    }

}
