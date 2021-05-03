package com.leetcode.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequencySort {
    public  String frequencySort(String s){

        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            int cnt = map.getOrDefault(ch, 0);
            map.put(ch, cnt + 1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((p, q) -> map.get(q) - map.get(p));
        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            pq.add(entry.getKey());
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()){
            Character key = pq.poll();
            for(int i=0;i<map.get(key);i++){
                sb.append(key);
            }

        }
        return sb.toString();
    }

    public  String frequencySortBase(String s){
        int[] charMap = new int[128];
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            charMap[ch]++;
        }
        PriorityQueue<Character> priorityQueue = new PriorityQueue<>((p, q) -> charMap[q] - charMap[p]);
        for(int i=0;i<charMap.length;i++){
            if(charMap[i]!=0){
                priorityQueue.add((char) i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!priorityQueue.isEmpty()){
            char ch = priorityQueue.poll();
            for (int i = 0; i < charMap[ch]; i++) sb.append(ch);
        }
        return sb.toString();
    }

}
