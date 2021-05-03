package com.leetcode.test;

public class DiagonalTraverse {


    /**
     * 给定一个含有 M x N 个元素的矩阵（M 行，N 列），
     * 请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。
     *
     * 示例:
     *
     * 输入:
     * [
     *  [ 1, 2, 3 ],
     *  [ 4, 5, 6 ],
     *  [ 7, 8, 9 ]
     * ]
     *
     * 输出:  [1,2,4,7,5,3,6,8,9]
     *
     * 链接：https://leetcode-cn.com/problems/diagonal-traverse
     * @param matrix
     * @return
     *
     * 算法思路是: 当遍历对角线的行数为奇数时,是往上走(rows--,col++)
     *             当行数为偶数时候:是往下走(rows++,col--)
     *             遍历的总行数是 n=矩阵的行(matrix.length)+矩阵的列(matrix[0].length)-1;
     *             当遍历对角线行数为奇数时{r=(i<m)?i:m-1}
     *                     即当行数超过矩阵的行数时,当前遍历矩阵元素的行就是m-1,
     *                     c=i-r;
     *             当遍历对角线行数为偶数时{c=(i<n)?i:n-1}
     *                     即当行数超过矩阵的列数时,当前遍历矩阵元素的列就是n-1,
     *                     r=i-c;
     */
    public int[] findDiagonalOrder(int[][] matrix) {

        if(matrix==null||matrix.length<1) return new int[0];
        int m=matrix.length,n=matrix[0].length;
        int[] orders = new int[m * n];
        int j=0;
        for(int i=0;i<m+n-1;i++){

            int r,c;
            boolean flag=((i+1)&1)==1;
            if(flag){
                r=(i<m)?i:m-1;
                c=i-r;
            }else {
                c=(i<n)?i:n-1;
                r=i-c;
            }
            while (r<m&&r>=0&&c>=0&&c<n){
                orders[j++] = matrix[r][c];
                if(flag){
                    r--;
                    c++;
                }else {
                    r++;
                    c--;
                }
            }

        }
        return orders;

    }

    public static void main(String[] args) {


        DiagonalTraverse traverse = new DiagonalTraverse();

    }
}