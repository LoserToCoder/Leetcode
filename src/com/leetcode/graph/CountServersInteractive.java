package com.leetcode.graph;

public class CountServersInteractive {


    /**
     * 这里有一幅服务器分布图，服务器的位置标识在m * n的整数矩阵网格grid中，
     * 1 表示单元格上有服务器，0 表示没有。
     *
     * 如果两台服务器位于同一行或者同一列，我们就认为它们之间可以进行通信。
     * 请你统计并返回能够与至少一台其他服务器进行通信的服务器的数量。

     * 链接：https://leetcode-cn.com/problems/count-servers-that-communicate
     * @param grid
     * @return
     * 统计每行每列的服务器数量rows,cols
     * 统计所有的服务器数量 sum
     * 然后当碰到单独服务器 sum--;
     *
     */
    public int countServers(int [][]grid){



        int sum=0;
        int m=grid.length,n=grid[0].length;
        int[] rows = new int[m], cols = new int[n];
        for(int i=0;i<m;i++){

            for(int j=0;j<n;j++){

                if (grid[i][j]==1) {
                    sum++;
                    rows[i]++;
                    cols[j]++;
                }

            }

        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1&&rows[i]==1&&cols[j]==1){
                    sum--;//此时遇到单独服务器,则总服务器数量-1;
                }
            }
        }

        return sum;
    }


    public static void main(String[] args) {

    }


}
