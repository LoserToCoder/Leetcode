package com.leetcode.doublespoints;

public class FindDuplicate {

    /**
     * 给定一个包含n + 1 个整数的数组nums，其数字都在 1 到 n之间（
     * 包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，
     * 找出这个重复的数。
     *
     * 示例 1:
     *
     * 输入: [1,3,4,2,2]
     * 输出: 2
     * 示例 2:
     *
     * 输入: [3,1,3,4,2]
     * 输出: 3
     * 说明：
     *
     * 不能更改原数组（假设数组是只读的）。
     * 只能使用额外的 O(1) 的空间。
     * 时间复杂度小于 O(n2) 。
     * 数组中只有一个重复的数字，但它可能不止重复出现一次。
     * 链接：https://leetcode-cn.com/problems/find-the-duplicate-number
     * @param nums
     * @return
     *
     * 算法:
     * 弗洛伊德的乌龟和兔子（循环检测）
     * 如果我们对 nums 进行这样的解释，即对于每对索引i和值Vi
     *   而言，“下一个”Vj位于索引Vi处，我们可以将此问题减少到循环检测。
     * 算法：
     * 首先，我们可以很容易地证明问题的约束意味着必须存在一个循环。
     * 因为 nums 中的每个数字都在 1和n之间，所以它必须指向存在的索引。
     * 此外，由于0不能作为 nums 中的值出现，nums[0] 不能作为循环的一部分。
     */
    public int findDuplicate(int[] nums) {
        int tortoise = nums[0];
        int rabbit = nums[0];
        do {
            tortoise = nums[tortoise];
            rabbit = nums[nums[rabbit]];
        } while (tortoise != rabbit);

        int p1 = nums[0];
        int p2 = tortoise;
        while (p1 != p2) {
            p1 = nums[p1];
            p2 = nums[p2];
        }

        return p1;
    }

}
