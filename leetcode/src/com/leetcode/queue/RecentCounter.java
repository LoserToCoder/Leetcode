package com.leetcode.queue;

import java.util.LinkedList;
import java.util.Queue;


/**
 * 写一个RecentCounter类来计算最近的请求。
 * 它只有一个方法：ping(int t)，其中t代表以毫秒为单位的某个时间。
 * 返回从 3000 毫秒前到现在的ping数。
 * 任何处于[t - 3000, t]时间范围之内的 ping都将会被计算在内，
 * 包括当前（指 t时刻）的 ping。
 * 保证每次对 ping 的调用都使用比之前更大的 t 值。
 * 示例：
 * 输入：inputs = ["RecentCounter","ping","ping","ping","ping"], inputs = [[],[1],[100],[3001],[3002]]
 * 输出：[null,1,2,3,3]
 * 每个测试用例最多调用10000次ping。
 * 每个测试用例会使用严格递增的 t 值来调用ping。
 * 每次调用 ping都有1 <= t <= 10^9。
 * 链接：https://leetcode-cn.com/problems/number-of-recent-calls
 */

public class RecentCounter {


    private Queue<Integer> queue;

    public RecentCounter() {
        queue=new LinkedList<>();
    }

    public int ping(int t) {
        while (!queue.isEmpty()){

            int h=queue.peek();
            if(t-h<=3000){
                break;
            }
            queue.poll();
        }
        queue.add(t);
        return queue.size();
    }

    public static void main(String[] args) {

        RecentCounter counter = new RecentCounter();

        System.out.println(counter.ping(1));
        System.out.println(counter.ping(100));
        System.out.println(counter.ping(3001));
        System.out.println(counter.ping(3002));

    }
}
