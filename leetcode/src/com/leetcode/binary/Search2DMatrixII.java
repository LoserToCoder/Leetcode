package com.leetcode.binary;
public class Search2DMatrixII{
    /***
     * 编写一个高效的算法来搜索mxn矩阵 matrix 中的一个
     * 目标值 target。该矩阵具有以下特性：
     * 每行的元素从左到右升序排列。
     * 每列的元素从上到下升序排列。
     * 现有矩阵 matrix 如下：
     * [
     *   [1,   4,  7, 11, 15],
     *   [2,   5,  8, 12, 19],
     *   [3,   6,  9, 16, 22],
     *   [10, 13, 14, 17, 24],
     *   [18, 21, 23, 26, 30]
     * ]
     * 给定 target=5，返回true。
     * 给定target=20，返回false。
     * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix-ii
     * @param matrix
     * @param target
     * @return
     */
     
     public boolean isExist(int[]matrix,int target){
      
        int left=0;
        int right=matrix.length-1;
        int middle=0;
        while(left<=right){

            middle=left+((right-left)>>1);

            if(matrix[middle]==target) return true;
            else if(matrix[middle]<target){
            	left=middle+1;
            }else{
            	right=middle-1;
            }
        }
        return false;

     }

    /**
     * 二分法查找时间复杂度是 O(mlogn)
     * @param matrix
     * @param target
     * @return
     */
     public boolean searchMatrix(int[][] matrix, int target) {
         if(matrix==null||matrix.length==0||matrix[0].length==0||target<matrix[0][0]) return false;
          
          for(int i=0;i<matrix.length;i++){
          	 if(isExist(matrix[i],target)) return true;
          }
          return false;
     }


    /**
     * 时间复杂度O(m+n);
     * 解题思路:从右上角出发(从左下角出发),
       如果出现目标元素小于当前的位置就要往左移动
     * 如果出现目标对象比当前位置的元素大就向下走一行
     * 只要是往下走就不会先往上走的情况,因为每一行都是递增的,
       再往下走走之前的位置肯定大于这一行之前的元素

       左上角和右下角:
          这两个方位是都是有点不太好着手处理
          左上角:如果当前位置的元素小于目标元素,是该往右进还是往下进(两边都是递增的)
          右下角同上

       为什么是右上角或者左下角出发就是(可以有进有退)
          右上角: 如果当前位置的元素小于目标元素,往下走(进),否则,往左走(退)
                  往左是递减,往下是递增
          左下角同上
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrixII(int[][]matrix,int target){
          if(matrix==null||matrix.length==0||matrix[0].length==0||target<matrix[0][0]) return false;
          int cols=matrix[0].length-1;
          int rows=0;
          while(cols>=0&&rows<matrix.length){
      
                if(matrix[rows][cols]==target) {
                    return true;
                }else if(matrix[rows][cols]<target){
                	rows++;
                }else{
                	cols--;
                }
          }
         return false;

    }
    public static void main(String[] args) {
        int[][]matrix={{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        for(int i=0;i<matrix.length;i++){

            for(int j=0;j<matrix[i].length;j++){
                searchMatrixII(matrix, matrix[i][j]);
            }
        }
    }

}