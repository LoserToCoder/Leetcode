package com.leetcode.queue;


import java.util.ArrayDeque;
import java.util.Deque;


/**
 * 改进方案就是自定义个链表
 */
public class MaxQueue {



    private Deque<Integer> queue;

    private Deque<Integer> maxQueue;

    public MaxQueue() {
        queue = new ArrayDeque<>();
        maxQueue = new ArrayDeque<>();
    }

    public int max_value() {
        if(queue.isEmpty()) return -1;
        return maxQueue.peekLast();
    }

    public void push_back(int value) {

        /*if(!maxQueue.isEmpty()){
            *//*耗时操作**//*
            int i = 0;
            int size=maxQueue.size();
            while (i<size&&value<=maxQueue.get(i)){
               i++;
            }

            for(;i<size;i++){
               maxQueue.remove(i);
            }
        }*/
        while (!maxQueue.isEmpty()&&maxQueue.peek()<value){
            maxQueue.pop();
        }
        maxQueue.push(value);
        queue.add(value);
    }

    public int pop_front() {

        if(queue.isEmpty()) return -1;
        Integer head = queue.pollFirst();
        if(!maxQueue.isEmpty()&&head.equals(maxQueue.peekLast())){
            maxQueue.pollLast();
        }
        return head;
    }

    public static void main(String[] args) {

        Deque<Integer> s = new ArrayDeque<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);

    }

}
