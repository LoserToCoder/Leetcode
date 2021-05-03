package com.leetcode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindContinuousSequence {


    /**
     * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
     * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
     * 示例 1：
     * <p>
     * 输入：target = 9
     * 输出：[[2,3,4],[4,5]]
     * 示例 2：
     * <p>
     * 输入：target = 15
     * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
     *
     * 限制：
     * 1 <= target <= 10^5
     * 链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
     *
     * @param target
     * @return
     */



    public int[][] findContinuousSequence(int target) {

        List<int[]> results = new ArrayList<>();
        int m=(target&1)==1?target/2+1:target/2;
        int l=1,r=2;
        while (l<r&&r<=m){
            int sum=(l+r)*(r-l+1)/2;
            if(sum==target){
                int[] array = new int[r - l + 1];
                for(int i=l;i<=r;i++){
                    array[i-l]=i;
                }
                results.add(array);
                l++;
                r++;
            }else if(sum<target){
                r++;
            }else {
                l++;
            }
        }
        int n=results.size();
        int[][] ans = new int[n][];
        return results.toArray(ans);
    }




    public static void main(String[] args) {

        FindContinuousSequence sequence = new FindContinuousSequence();

        int[][] results = sequence.findContinuousSequence(100000);
        for(int i=0;i<results.length;i++){
            System.out.println(Arrays.toString(results[i]));
        }

    }


}
