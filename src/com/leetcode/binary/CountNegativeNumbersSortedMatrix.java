package com.leetcode.binary;

import java.util.Arrays;

public class CountNegativeNumbersSortedMatrix {


    /**
     * 给你一个m* n的矩阵grid，矩阵中的元素无论是按行还是按列，都以非递增顺序排列。
     *
     * 请你统计并返回grid中 负数 的数目。
     * 示例 1：
     * 输入：grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
     * 输出：8
     * 解释：矩阵中共有 8 个负数。
     * 示例 2：
     * 输入：grid = [[3,2],[1,0]]
     * 输出：0
     * 示例 3：
     * 输入：grid = [[1,-1],[-1,-1]]
     * 输出：3
     * 示例 4：
     * 输入：grid = [[-1]]
     * 输出：1
     * 提示：
     * m == grid.length
     * n == grid[i].length
     * 1 <= m, n <= 100
     * -100 <= grid[i][j] <= 100
     * 链接：https://leetcode-cn.com/problems/count-negative-numbers-in-a-sorted-matrix
     * @param grid
     * @return
     */






    public int countNegatives(int[][] grid) {

        if(grid==null||grid.length<1) return 0;

        int rows=grid.length,cols=grid[0].length;

        if(grid[rows-1][cols-1]>=0) return 0;
        if(grid[0][0]<0) return rows*cols;
        int sum=0;
        for(int i=0;i<rows;i++){

            int idx = binarySearch(grid[i], 0);
            sum+=cols-idx;
        }
        return sum;


    }

    private int binarySearch(int[]nums,int target){


        int low=0,high=nums.length-1;


        while (low<high){

            int middle=(high-low)/2+low;

            if(nums[middle]>=target){
                low=middle+1;
            }else{
                high=middle;
            }
        }
        return nums[low]>=target?low+1:low;

    }
    public static void main(String[] args) {
        int[][]grid={{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
        CountNegativeNumbersSortedMatrix sortedMatrix = new CountNegativeNumbersSortedMatrix();
        System.out.println(sortedMatrix.countNegatives(grid));
        // Arrays.asList()
    }
}
