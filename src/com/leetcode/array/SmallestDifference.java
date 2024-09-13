package com.leetcode.array;

import java.util.Arrays;

public class SmallestDifference {

    /**
     * 给定两个整数数组a和b，计算具有最小差绝对值的一对数值（每个数组中取一个值），并返回该对数值的差
     * 示例：
     *
     * 输入：{1, 3, 15, 11, 2}, {23, 127, 235, 19, 8}
     * 输出：3，即数值对(11, 8)
     *
     *
     * 提示：
     *
     * 1 <= a.length, b.length <= 100000
     * -2147483648 <= a[i], b[i] <= 2147483647
     * 正确结果在区间 [0, 2147483647] 内
     */

    /**
     * 构造递增的序列
     * 使用双指针 来不断减少缩小范围
     * @param a
     * @param b
     * @return
     */

    public  int smallestDifference(int[] a, int[] b) {

        Arrays.sort(a);
        Arrays.sort(b);

        int i = a.length-1, j = b.length-1;
        long minDiff = Integer.MAX_VALUE;
        while(i>=0 && j>=0) {

            long m = a[i];
            long n = b[j];
            minDiff = Math.min(minDiff,Math.abs(m-n));
            if(a[i]>b[j]) {
                i--;
            } else if(a[i]<b[j]) {
                j--;
            } else {
                return 0;
            }
        }
        return (int) minDiff;
    }
}
