package com.leetcode.graph;

import java.util.HashSet;
import java.util.Set;

public class NumberOfDistinctIslands {

    /**
     * 不同岛屿的数量
     * 给定一个非空 01 二维数组表示的网格，一个岛屿由四连通（上、下、左、右四个方向）的 1 组成，
     * 你可以认为网格的四周被海水包围。
     *
     * 请你计算这个网格中共有多少个形状不同的岛屿。两个岛屿被认为是相同的，当且仅当一个岛屿可以
     * 通过平移变换（不可以旋转、翻转）和另一个岛屿重合。
     *
     *
     *
     * 示例 1：
     * 11000
     * 11000
     * 00011
     * 00011
     * 给定上图，返回结果 1 。
     *
     * 示例 2：
     * 11011
     * 10000
     * 00001
     * 11011
     * 给定上图，返回结果 3 。
     *
     * 注意：
     *
     * 11
     * 1
     * 和
     *
     *  1
     * 11
     * 是不同的岛屿，因为我们不考虑旋转、翻转操作。
     *
     *
     *
     * 提示：二维数组每维的大小都不会超过 50
     * @param grid
     * @return
     */
    public int numDistinctIslands(int[][] grid) {
        if(grid==null||grid.length<1){
            return 0;
        }
        int r = grid.length,c = grid[0].length;

        //记录不同的路径,经过平移变换,相对路径依然是一样的
        Set<String> landsMap = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]==1){
                    dfs(grid,i,j,r,c,sb);
                    landsMap.add(sb.toString());
                    sb.delete(0, sb.length());
                }
            }
        }
        return landsMap.size();
    }

    private void dfs(int[][]grid,int i,int j,int r,int c,StringBuilder sb){

        if(i<0||i>=r||j<0||j>=c||grid[i][j]!=1){
            return;
        }
        grid[i][j]=0;
        dfs(grid,i+1,j,r,c,sb.append('d'));
        dfs(grid,i,j+1,r,c,sb.append('r'));
        dfs(grid,i-1,j,r,c,sb.append('u'));
        dfs(grid,i,j-1,r,c,sb.append('l'));
    }


}
