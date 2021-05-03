package com.leetcode.slidewindows;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestSuperSequence {

    /*
        假设你有两个数组，一个长一个短，短的元素均不相同。找到长数组中包含短数组所有的元素的最短子数组，其出现
        顺序无关紧要。返回最短子数组的左端点和右端点，如有多个满足条件的子数组，返回左端点最小的一个。若不存在，返回空数组。

        示例 1:

        输入:
        big = [7,5,9,0,2,1,3,5,7,9,1,1,5,8,8,9,7]
        small = [1,5,9]
        输出: [7,10]
        示例 2:

        输入:
        big = [1,2,3]
        small = [4]
        输出: []
        提示：

        big.length<= 100000
        1 <= small.length<= 100000

        链接：https://leetcode-cn.com/problems/shortest-supersequence-lcci
     * @param big
     * @param small
     * @return
     */
    public int[] shortestSeq(int[] big, int[] small) {
        int n = big.length;
        int [] res ={};
        Map<Integer,Integer> map = new HashMap<>();
        int minLen = n, diff = 0;
        for (int val : small) {
            map.putIfAbsent(val, 1);
            diff++;
        }

        int l = 0, r = 0;
        for (; r < n; ++r) {


            if (map.containsKey(big[r])) {
              int rVal = map.get(big[r]);
              if(rVal>=1){
                  diff--;
              }
              map.put(big[r], rVal - 1);
            }

            while (diff == 0) {
                if (r - l < minLen) {
                    minLen = r - l;
                    res = new int[]{l, r};
                }
                if(map.containsKey(big[l])){
                    int lVal = map.get(big[l]);
                    if(lVal>=0){
                        diff++;
                    }
                    map.put(big[l], lVal + 1);
                }
                ++l;
            }
        }

        return res;
    }
}
