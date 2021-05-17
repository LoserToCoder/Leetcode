package com.leetcode.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SingleThreadedCpu {




    class Task {
        int id;
        int enqueueTime;
        int processingTime;

        public Task(int id, int enqueueTime, int processingTime){
            this.id = id;
            this.enqueueTime = enqueueTime;
            this.processingTime = processingTime;
        }
    }
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        Task[] taskQueue = new Task[n];
        for(int i=0; i<n; i++){
            taskQueue[i]=new Task(i, tasks[i][0], tasks[i][1]);
        }
        //按入队时间排序
        Arrays.sort(taskQueue,(p,q)->p.enqueueTime - q.enqueueTime);
        //利用最小堆获取下个要执行的任务
        PriorityQueue<Task> minHeap = new PriorityQueue<>((t1,t2) -> {
            if(t1.processingTime!=t2.processingTime){
                return t1.processingTime-t2.processingTime;
            }
            return t1.id-t2.id;
        });
        long now = 0;
        int i = 0,j = 0;//i-表示入队任务的索引下标,j-表示任务调度下标
        int[] orders = new int[n];

        while(i<n){

            //cpu空闲,且当前now小于下一个任务入队的时间,则重置now时间
            if(minHeap.isEmpty()&&taskQueue[i].enqueueTime>now){
                now = taskQueue[i].enqueueTime;
            }
            while (i<n&&taskQueue[i].enqueueTime<=now){
                minHeap.offer(taskQueue[i]);
                i++;
            }

            Task task = minHeap.poll();
            now+=task.processingTime;
            orders[j++] = task.id;
        }

        //任务队列都已经全部进入调度
        while(!minHeap.isEmpty()){
            //按顺序取出任务执行即可
            orders[j++] = minHeap.poll().id;
        }
        return orders;
    }


    public static void main(String[] args) {

        new SingleThreadedCpu().getOrder(new int[][]{{1, 2}, {2, 4}, {3, 2}, {4, 1}});

    }


}
