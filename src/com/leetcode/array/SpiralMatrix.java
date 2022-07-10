package com.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    /**
     * 给你一个 m 行 n 列的矩阵matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
     *
     * 示例 1：
     * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * 输出：[1,2,3,6,9,8,7,4,5]
     *
     * 示例 2：
     * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
     * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
     *
     * 提示：
     * m == matrix.length
     * n == matrix[i].length
     * 1 <= m, n <= 10
     * -100 <= matrix[i][j] <= 100
     *
     * 链接：https://leetcode.cn/problems/spiral-matrix
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix==null || matrix[0].length==0){
            return null;
        }
        int m = matrix.length,n = matrix[0].length;
        int top = 0,bottom = m-1, left=0,right = n-1;
        List<Integer> ans = new ArrayList<>(m*n);
        while(top<=bottom && left<=right){
            //从左到右
            for(int i=left;i<=right;i++){
                ans.add(matrix[top][i]);
            }
            top++;
            //从上到下
            for(int i=top;i<=bottom;i++){
                ans.add(matrix[i][right]);
            }
            right--;
            // 单行,单列的情况下
            if(left>right||top>bottom) break;
            //从右向左
            for(int i=right;i>=left;i--){
                ans.add(matrix[bottom][i]);
            }
            bottom--;
            //从下向上
            for(int i=bottom;i>=top;i--){
                ans.add(matrix[i][left]);
            }
            left++;
        }
        return ans;
    }
}
