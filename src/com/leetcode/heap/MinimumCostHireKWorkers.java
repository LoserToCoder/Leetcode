package com.leetcode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumCostHireKWorkers {


    /**
     * 有 N名工人。第i名工人的工作质量为quality[i]，其最低期望工资为wage[i]。
     * 现在我们想雇佣K名工人组成一个工资组。在雇佣一组 K 名工人时，我们必须按照下
     * 述规则向他们支付工资：
     * 对工资组中的每名工人，应当按其工作质量与同组其他工人的工作质量的比例来支付工资。
     * 工资组中的每名工人至少应当得到他们的最低期望工资。
     * 返回组成一个满足上述条件的工资组至少需要多少钱。
     * 示例 1：
     * 输入： quality = [10,20,5], wage = [70,50,30], K = 2
     * 输出： 105.00000
     * 解释： 我们向 0 号工人支付 70，向 2 号工人支付 35。
     * 示例 2：
     * 输入： quality = [3,1,10,10,1], wage = [4,8,2,2,7], K = 3
     * 输出： 30.66667
     * 解释： 我们向 0 号工人支付 4，向 2 号和 3 号分别支付 13.33333。
     * 提示：
     * 1 <= K <= N <= 10000，其中N = quality.length = wage.length
     * 1 <= quality[i] <= 10000
     * 1 <= wage[i] <= 10000
     * 与正确答案误差在10^-5之内的答案将被视为正确的。
     * 链接：https://leetcode-cn.com/problems/minimum-cost-to-hire-k-workers
     * @param quality
     * @param wage
     * @param K
     * @return
     */
    class Wage{
        public int quality;
        public int wage;
        public Wage(int quality,int wage){
            this.quality=quality;
            this.wage=wage;
        }

        @Override
        public String toString() {
            return "["+quality+","+wage+"]";
        }
    }
    private void init(int []quality,int []wage,Wage[]wages){
        for(int i=0;i<quality.length;i++){
            wages[i] = new Wage(quality[i], wage[i]);
        }
    }
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        Wage[] wages = new Wage[quality.length];
        init(quality,wage,wages);

        return .0;
    }

    public static void main(String[] args) {

    }
}
