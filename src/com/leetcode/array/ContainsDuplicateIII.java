package com.leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateIII {

    /*

    给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在 两个不同下标 i 和 j，
    使得 abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k 。

    如果存在则返回 true，不存在返回 false。



    示例 1：

    输入：nums = [1,2,3,1], k = 3, t = 0
    输出：true
    示例 2：

    输入：nums = [1,0,1,1], k = 1, t = 2
    输出：true
    示例 3：

    输入：nums = [1,5,9,1,5,9], k = 2, t = 3
    输出：false


    提示：

    0 <= nums.length <= 2 * 104
    -231 <= nums[i] <= 231 - 1
    0 <= k <= 104
    0 <= t <= 231 - 1

    我们也可以使用利用桶排序的思想解决本题。我们按照元素的大小进行分桶，维护一个滑动窗口内的元素对应的元素。

    对于元素 array.yml，其影响的区间为 [x - t, x + t][x−t,x+t]。于是我们可以设定桶的大小为 t + 1t+1。如果两个

    元素同属一个桶，那么这两个元素必然符合条件。如果两个元素属于相邻桶，那么我们需要校验这两个元素是否差值

    不超过 tt。如果两个元素既不属于同一个桶，也不属于相邻桶，那么这两个元素必然不符合条件。

    具体地，我们遍历该序列，假设当前遍历到元素 array.yml，那么我们首先检查 array.yml 所属于的桶是否已经存在元素，如果存在，
    那么我们就找到了一对符合条件的元素，否则我们继续检查两个相邻的桶内是否存在符合条件的元素。
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        Map<Long, Long> map = new HashMap<Long, Long>();
        long w = (long) t + 1;
        for (int i = 0; i < n; i++) {
            long id = getID(nums[i], w);
            if (map.containsKey(id)) {
                return true;
            }
            if (map.containsKey(id - 1) && Math.abs(nums[i] - map.get(id - 1)) < w) {
                return true;
            }
            if (map.containsKey(id + 1) && Math.abs(nums[i] - map.get(id + 1)) < w) {
                return true;
            }
            map.put(id, (long) nums[i]);
            if (i >= k) {
                map.remove(getID(nums[i - k], w));
            }
        }
        return false;
    }

    //分桶
    public long getID(long x, long w) {
        if (x >= 0) {
            return x / w;
        }
        return (x + 1) / w - 1;
    }
}
