package com.leetcode.vote;
/**
 * 摩尔投票算法（Boyer-Moore Majority Vote Algorithm）是一种用于查找数组中出现次数超过一半的主要元素的高效算法。
 *  它的核心思想是通过消除不同的元素对来找到主要元素，这个算法的时间复杂度为 O(n)，其中 n 是数组的长度。下面是该算法的基本原理：
 * 1. 初始化两个变量 candidate 和 count，其中 candidate 用于保存候选主要元素，count 用于记录候选主要元素出现的次数。
 *    初始时，candidate 可以是任何数组中的元素，而 count 初始化为0。
 * 2. 遍历数组中的每个元素：
 *    a. 如果 count 等于0，将当前元素设置为候选主要元素 candidate，并将 count 设置为1。
 *    b. 如果 count 不等于0，检查当前元素是否等于 candidate：
 *    ⅰ. 如果相等，将 count 递增1，表示找到了一个与候选主要元素相同的元素。
 *    ⅱ. 如果不相等，将 count 递减1，表示找到了一个与候选主要元素不同的元素。
 * 3. 在遍历完成后，candidate 变量中存储的元素就是数组中的主要元素。
 *
 * 这个算法的核心思想在于消除不同元素对，最终剩下的元素就是主要元素，因为主要元素的出现次数超过一半。算法的优点是只需要进行一次遍历，具有较低的时间复杂度和空间复杂度。
 * 摩尔投票算法适用于大多数寻找主要元素的问题，例如，查找出现次数超过一半的元素，查找众数等。它是一个高效的算法，通常用于解决此类问题。
 */
public class MooreMajorityVoteAlgorithm {

    public int majorityElement(int[] nums) {

        int candidate = -1;
        int votes = 0;
        for (int i = 0; i < nums.length; i++) {

            if(votes ==0 ) {
                candidate = nums[i];
            }

            if(candidate == nums[i]) {
                votes++;
            } else {
                votes--;
            }
        }
        votes = 0 ;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == candidate) {
                votes++;
            }
        }
        return votes * 2 > nums.length ? candidate : -1;
    }




}
