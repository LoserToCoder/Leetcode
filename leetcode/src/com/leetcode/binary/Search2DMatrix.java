package com.leetcode.binary;

public class Search2DMatrix{

    /**
     * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。
     * 该矩阵具有如下特性：
     * 每行中的整数从左到右按升序排列。
     * 每行的第一个整数大于前一行的最后一个整数。
     * 示例 1:
     * 输入:
     * matrix = [
     *   [1,   3,  5,  7],
     *   [10, 11, 16, 20],
     *   [23, 30, 34, 50]
     * ]
     * target = 3
     * 输出: true
     * 示例 2:
     * 输入:
     * matrix = [
     *   [1,   3,  5,  7],
     *   [10, 11, 16, 20],
     *   [23, 30, 34, 50]
     * ]
     * target = 13
     * 输出: false
     * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix
     * 解题思路:
     *   将二维空间数组拉长成一维数组,
     *   通过middle/columns来定位是那一行
     *   通过middle%columns来定位是那一列
     * @param matrix
     * @param target
     * @return
     */

    public boolean searchMatrix(int[][] matrix, int target) {

        if(matrix==null||matrix.length==0||matrix[0].length==0) return false;
        int m=matrix.length,n=matrix[0].length;
        int left=0;
        int right=m*n-1;
        int middle=0;
        while(left<right){ 
           middle=left+((right-left)>>1);
           if(matrix[middle/n][middle%n]==target){
              return true;
           }else if(matrix[middle/n][middle%n]<target){
              left=middle+1;
           }else{
              right=middle-1;
           }

        }
        return false;
    }

   

    public static void main(String[] args) {
        int[][]matrix={{-9,-8,-8},{-5,-3,-2},{0,2,2},{4,6,8}};
        System.out.println(new Search2DMatrix().searchMatrix(matrix,15));
    }
}