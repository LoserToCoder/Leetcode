package com.leetcode.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.*;

public class FutureThread {


    /***
     *  打车的时候要获取价格 ---->  {100ms}A--->B{100ms}--->C{100ms}  500ms+50ms  550ms   200ms  150ms
     *
     *
     *  10w  --->
     */


    private static ExecutorService executorService = Executors.newFixedThreadPool(256);

    public static void main(String[] args)throws Exception {

        List<Future<Integer>> futureList = new ArrayList<>();
        int [] nums ={10,20,30,40,50};
        Future<Integer> future = null;
        long t1 = System.currentTimeMillis();
        for(int val:nums){
            future = getCalculate(val);
            futureList.add(future);
        }
        for(Future<Integer> async:futureList){
            System.out.println(async.get());
        }
        System.out.println("耗时:"+(System.currentTimeMillis()-t1)+"ms");
        futureList.clear();
        nums =new int[]{60,70,80,90,100,200,300,400,500,600,700,800,900,1000,1100};
        t1 = System.currentTimeMillis();
        for(int val:nums){
            future = getCalculate(val);
            futureList.add(future);
        }
        for(Future<Integer> async:futureList){
            System.out.println(async.get());
        }
        System.out.println("耗时:"+(System.currentTimeMillis()-t1)+"ms");
        executorService.shutdownNow();



    }

    public static Future<Integer> getCalculate(int num){
        return executorService.submit(()->{
            Thread.sleep(100);
            return num*num;
        });
    }


}
