package com.leetcode.disjoint;

public class NumberOfIsland {


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
     * <p>
     * 输出: 1
     * 示例 2:
     * <p>
     * 输入:
     * 11000
     * 11000
     * 00100
     * 00011
     * 输出: 3
     * 链接：https://leetcode-cn.com/problems/number-of-islands
     *
     * @param grid
     * @return
     */

    private int[] parent;

    private int[] rank;

    private int count;

    private int find(int u){

        while (u != parent[u]) {
            parent[u] = parent[parent[u]];
            u = parent[u];
        }
        return u;

    }

    private void union(int u,int v){

        u = find(u);
        v = find(v);
        if(u==v) return;

        if (rank[u] > rank[v]) {
            parent[v] = u;
            rank[u] += rank[v];
        }else{
            parent[u] = v;
            rank[v] += rank[u];
        }
        count--;
    }

    public int numIslands(char[][] grid) {

        if(grid==null||grid.length<1) return 0;

        int m = grid.length;
        int n = grid[0].length;
        parent = new int[m * n];
        rank = new int[m * n];
        for(int i=0;i<m;i++){

            for(int j=0;j<n;j++){

                if(grid[i][j]=='1'){
                    count++;
                    parent[i*n+j]=i*n+j;
                }
            }

        }
        for(int i=0;i<m;i++){

            for(int j=0;j<n;j++){

                if(grid[i][j]=='1'){
                    grid[i][j] = '0';

                    if(i-1>=0&&grid[i-1][j]=='1'){
                        union(i*n+j,(i-1)*n+j);
                    }
                    if(j-1>=0&&grid[i][j-1]=='1'){
                        union(i*n+j,i*n+j-1);
                    }

                    if(i+1<m&&grid[i+1][j]=='1'){
                        union(i*n+j,(i+1)*n+j);
                    }

                    if(j+1<n&&grid[i][j+1]=='1'){
                        union(i*n+j,i*n+j+1);
                    }

                }


            }

        }

        return count;

    }

    public static void main(String[] args) {

    }
}
