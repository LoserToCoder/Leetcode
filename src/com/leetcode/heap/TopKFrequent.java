package com.leetcode.heap;

import java.util.*;

public class TopKFrequent {

    public List<String> topKFrequent(String[] words, int k) {

        Map<String,Integer> map = new HashMap<>();
        for(String word:words){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> priorityQueue = new PriorityQueue<String>(k,(p,q)->{

            Integer frequentP = map.getOrDefault(p, 0);
            Integer frequentQ = map.getOrDefault(q, 0);
            if(frequentP==frequentQ){
                return p.compareTo(q);
            }
            return frequentQ-frequentP;
        });
        for(Map.Entry<String,Integer> entry:map.entrySet()){
             priorityQueue.offer(entry.getKey());
        }
        List<String> topK = new ArrayList<>();
        while (!priorityQueue.isEmpty()&&topK.size()<k){
            topK.add(priorityQueue.poll());
        }
        return topK;
    }

}
