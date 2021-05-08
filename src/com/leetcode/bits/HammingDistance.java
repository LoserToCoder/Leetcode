package com.leetcode.bits;

public class HammingDistance {

    /**
     * 两个整数的汉明距离 指的是这两个数字的二进制数对应位不同的数量。
     *
     * 计算一个数组中，任意两个数之间汉明距离的总和。
     *
     * 示例:
     *
     * 输入: 4, 14, 2
     *
     * 输出: 6
     *
     * 解释: 在二进制表示中，4表示为0100，14表示为1110，2表示为0010。（这样表示是为了体现后四位之间关系）
     * 所以答案为：
     * HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
     * 注意:
     *
     * 数组中元素的范围为从0到10^9。
     * 数组的长度不超过10^4。
     *
     * 方式：
     * 要计算数组中任意两个数的汉明距离的总和，可以先算出数组中任意两个数二进制第 i 位的汉明距离的总和，
     * 在将所有的 k 位之和相加。也就是说，二进制中的每一位都是可以独立计算的。
     *
     * 因此，我们考虑数组中每个数二进制的第 i 位，假设一共有 t 个 0 和 n - t 个 1，那么显然在第 i 位的
     * 汉明距离的总和为 t * (n - t)。
     *
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/total-hamming-distance/solution/yi-ming-ju-chi-zong-he-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * 链接：https://leetcode-cn.com/problems/total-hamming-distance
     * @param nums
     * @return
     */
    public int totalHammingDistance(int[] nums) {

        if (nums==null||nums.length<1) return 0;

        int ans = 0, n = nums.length;
        int [] bits =new int[32];
        for (int num : nums) {
            int i = 0;
            while (num > 0) {
                bits[i] += (num & 0x1);
                num=num>>1;
                i++;
            }
        }

        for (int k : bits) {
            ans += k * (n - k);
        }

        return ans;
    }
}
