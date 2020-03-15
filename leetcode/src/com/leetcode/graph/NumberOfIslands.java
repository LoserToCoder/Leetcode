package com.leetcode.graph;



public class NumberOfIslands{


    /**
     * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。
     * 一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。
     * 你可以假设网格的四个边均被水包围。
     * 示例 1:
     * 输入:
     * 11110
     * 11010
     * 11000
     * 00000
     * 输出: 1
     * 示例 2:
     * 输入:
     * 11000
     * 11000
     * 00100
     * 00011
     *
     * 输出: 3
     * 链接：https://leetcode-cn.com/problems/number-of-islands
     * @param grid
     * @return
     */

    public int numIslands(char[][] grid) {
        if(grid==null||grid.length<1) return 0;
        int ans = 0;
        for(int i=0;i<grid.length;i++){


           for(int j=0;j<grid[0].length;j++){

               if(grid[i][j]=='1'){
                   ans++;
                   dfs(i,j,grid);
               }
           }

        }
        return ans;
    }

    private void dfs(int r,int c,char[][]grid){

         if(r<0||c<0||r>=grid.length||c>=grid[0].length||grid[r][c]=='0') return;

         grid[r][c] = '0';

         dfs(r-1,c,grid);
         dfs(r,c-1,grid);
         dfs(r+1,c,grid);
         dfs(r,c+1,grid);


    }


    public static void main(String[] args) {

       // char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        char[][] grid = {{'1'}, {'1'}};
        //NumberOfIslands islands = new NumberOfIslands();

        //System.out.println(islands.numIslands(grid));

        System.out.println(null==null);
    }

}