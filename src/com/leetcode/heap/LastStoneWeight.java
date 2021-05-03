package com.leetcode.heap;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class LastStoneWeight {

    /**
     * 有一堆石头，每块石头的重量都是正整数。
     *
     * 每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为x 和y，
     * 且x <= y。那么粉碎的可能结果如下：
     *
     * 如果x == y，那么两块石头都会被完全粉碎；
     * 如果x != y，那么重量为x的石头将会完全粉碎，而重量为y的石头新重量为y-x。
     * 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
     *
     * 
     *
     * 示例：
     *
     * 输入：[2,7,4,1,8,1]
     * 输出：1
     * 解释：
     * 先选出 7 和 8，得到 1，所以数组转换为 [2,4,1,1,1]，
     * 再选出 2 和 4，得到 2，所以数组转换为 [2,1,1,1]，
     * 接着是 2 和 1，得到 1，所以数组转换为 [1,1,1]，
     * 最后选出 1 和 1，得到 0，最终数组转换为 [1]，这就是最后剩下那块石头的重量。
     *
     * 链接：https://leetcode-cn.com/problems/last-stone-weight
     */
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((p,q)->{return q-p;});
        for (int stone : stones) {
            pq.add(stone);
        }
        while (pq.size()>1){
            int p = pq.poll();
            int q = pq.poll();
            if(p>q){
                pq.add(p-q);
            }

        }
        return pq.isEmpty()?0:pq.peek();
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer p, Integer q) {
                return q-p;
            }
        });
        pq.add(10);
        pq.add(23);
        pq.add(25);

        Iterator<Integer> iterator = pq.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
