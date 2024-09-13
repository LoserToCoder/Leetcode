package com.leetcode.async;
import java.util.concurrent.*;

public class ThreadSummary {


    public static class Worker implements Runnable {


        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("" + i);
            }
        }
    }

    public static void main(String[] args) throws Exception {


        Thread thread = new Thread(new Worker());


        thread.start();
        thread.interrupt();


        System.out.println("isInterrupted:" + thread.isInterrupted());
        System.out.println("isInterrupted:" + thread.interrupted());
        System.out.println("isInterrupted:"+thread.isInterrupted());



        ThreadPoolExecutor threadPoolExecutor;
        while (thread.isAlive()) {
            System.out.println("thread is alive");

        }
        thread.start();
        System.out.println("thread is dead");

       /* ExecutorService service = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 5; i++) {
            String str = i + "";
            service.execute(() -> {
                System.out.println(str);
            });
        }
        service.shutdown();
        // 调用shutdown()方法后继续添加任务
        //service.execute(() -> System.out.println("ok"));
        service.awaitTermination(1, TimeUnit.SECONDS);
        System.out.println("线程池已关闭");*/

      /*  ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 20; i++) {
            String str = i + "";
            service.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(str);
                }
                // 为了后面展示未执行的任务，这里重写toString()方法
                @Override
                public String toString() {
                    return "这是第" + str + "个任务";
                }
            });
        }
        // 没有来得及执行的任务会以列表的形式返回
        List<Runnable> runnables = service.shutdownNow();
        System.out.println("线程池已关闭");
        for (Runnable runnable : runnables) {
            // 打印一下未执行的任务
            System.out.println(runnable);
        }*/
    }


}
