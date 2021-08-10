package com.leetcode.math;

public class Maximum {

    /**
     * 编写一个方法，找出两个数字a和b中最大的那一个。不得使用if-else或其他比较运算符。
     *
     * 示例：
     *
     * 输入： a = 1, b = 2
     * 输出： 2
     * @param a
     * @param b
     * @return
     *
     * 首先 a - b 得到差值x
     *
     * 由于是long型，右移63位得到符号位，注意负号不变，那么正数右移63位就是0，负数右移63位就是-1
     *
     * 那么得出我们的计算公式 (1 + k) * a - b * k
     * 当 x >= 0 的时候，k = 0, 即 a > b
     * 那么我们的计算公式为 1 * a - b * 0 = a
     *
     * 当 x < 0的时候，k = -1, 即 b > a
     * 那么我们的计算公式为 0 * a - b * ( -1 ) = b
     */
    public int maximum(int a, int b) {
        long x = (long) a - (long) b;
        int k = (int) (x >> 63);

        return (1 + k) * a - b * k;
    }
}
