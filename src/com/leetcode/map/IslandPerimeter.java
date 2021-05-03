package com.leetcode.map;

public class IslandPerimeter {


    /**
     给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地0 表示水域。
     网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，
     但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
     岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为
     1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
     示例 :
     输入:
     [[0,1,0,0],
     [1,1,1,0],
     [0,1,0,0],
     [1,1,0,0]]
     输出: 16
     解释: 它的周长是下面图片中的 16 个黄色的边：
     链接：https://leetcode-cn.com/problems/island-perimeter
     */
    /**
     * 思路1: 组成岛屿的小方格都是四个边,计算有多少个这样的方格
     *        方格和方格之间重叠的部分会隐藏两条边,计算黄色方格
     *        的右边以及下边是否有黄色小方格
     *        land*4-overlap*2
     *        (land代表岛屿小方格数量,overlap代表岛屿与岛屿之间的重叠的个数)
     * @param grid
     * @return
     */
    public int islandPerimeter(int[][] grid) {
        int land=0;
        int overlap=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1){
                    land++;
                    if(j<grid[i].length-1&&grid[i][j+1]==1){
                        overlap++;
                    }
                    if(i<grid.length-1&&grid[i+1][j]==1){
                        overlap++;
                    }
                }

            }
        }
        return land*4-2*overlap;
    }

    /**
     * 思路二: 边界问题
     * 实时考虑遇到一个黄色方格时,左右前后四个方向是否也有黄色小方格或者已经触及边界
     * @param grid
     * @return
     */
    public  int IslandPerimeter(int[][] grid) {
        int land=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1){

                    if(i-1<0||grid[i-1][j]==0){
                        land++;
                    }
                    if(j-1<0||grid[i][j-1]==0){
                        land++;
                    }
                    if(i==grid.length-1||grid[i+1][j]==0){
                        land++;
                    }
                    if(j==grid[i].length-1||grid[i][j+1]==0){
                        land++;
                    }

                }

            }
        }
        return land;
    }
    public static void main(String[] args) {

    }
}
