package com.leetcode.map;

import java.util.*;

public class TopKFrequent {

    /**
     *
     *
     * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
     * 示例 1:
     * 输入: nums = [1,1,1,2,2,3], k = 2
     * 输出: [1,2]
     * 示例 2:
     * 输入: nums = [1], k = 1
     * 输出: [1]
     * 说明：
     * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
     * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
     * 链接：https://leetcode-cn.com/problems/top-k-frequent-elements
     * @param nums
     * @param k
     * 解题思路: HashMap当做key-value,统计每个元素出现的频率
     * 然后将构建大小为k的堆数据结构, 比较器采用value即出现的频率作为比较依据
     * 当填充到元素个数为k时,删除根节点，继续添加,以此循环直至所有元素都在堆上扫描一遍
     *
     * 复杂度分析
     *
     * 时间复杂度：O(Nlog(k))。Counter 方法的复杂度是 O(N)O(N)，
     * 建堆和输出的复杂度是 O(Nlog(k))。因此总复杂度为
     * O(N + Nlog(k))=O(Nlog(k))。
     * 空间复杂度：O(N)，存储哈希表的开销。
     * 注释
     *
     * 根据复杂度分析，方法对于小 k 的情况是很优的。但是如果 k 值很大，
     * 我们可以将算法改成删除频率最低的若干个元素。

     * 求最大的topK问题使用小根堆
     * 求最小的topK问题使用大根堆
     */

    public static List<Integer> topKFrequent(int[]nums, int k){
        Map<Integer, Integer> map = new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer key1, Integer key2) {
                return map.get(key1)-map.get(key2);
            }
        });

        // keep k top frequent elements in the heap
        for(Integer key:map.keySet()){
            heap.add(key);
            if(heap.size()>k){
                heap.poll();
            }
        }
        List<Integer> topK = new ArrayList<>(k+1);
        while (!heap.isEmpty()){
            topK.add(heap.poll());
        }
        Collections.reverse(topK);
        return topK;
    }

    /**
     * 关键在于堆上元素的比较问题:
     * @param words
     * @param k
     * @return
     */
    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(String key:words){
            map.put(key,map.getOrDefault(key,0)+1);
        }
        PriorityQueue<String> pq=new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String key1, String key2) {
                int diff=map.get(key1)-map.get(key2);
                if(diff==0){
                    return key2.compareTo(key1);
                }
                return diff;
            }
        });

        for(String key:map.keySet()){

            pq.add(key);
            if(pq.size()>k){
                pq.poll();
            }


        }
        List<String> topK = new ArrayList<>();
        while(!pq.isEmpty()){
            topK.add(pq.poll());
        }
        Collections.reverse(topK);
        return topK;
    }
    public static void main(String[] args) {
       /*  int []nums={1,1,1,2,2,3};
         int k=2;
        List<Integer> list = topKFrequent(nums, k);
        for(Integer val:list){
            System.out.println(val);
        }*/
       /* String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        int k=1;
        System.out.println(topKFrequent(words,k));*/
        System.out.println("leetcode".compareTo("coding"));


    }

}
