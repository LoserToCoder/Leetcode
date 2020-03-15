package com.leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PathWithObstacles {


    /**
     * 设想有个机器人坐在一个网格的左上角，网格 r 行 c 列。机器人只能向下或向右移动，
     * 但不能走到一些被禁止的网格（有障碍物）。设计一种算法，寻找机器人从左上角移动到右下角的路径。
     * 网格中的障碍物和空位置分别用 1 和 0 来表示。
     * 返回一条可行的路径，路径由经过的网格的行号和列号组成。左上角为 0 行 0 列。
     * 示例 1:
     * 输入:
     * [
     *   [0,0,0],
     *   [0,1,0],
     *   [0,0,0]
     * ]
     * 输出: [[0,0],[0,1],[0,2],[1,2],[2,2]]
     * 解释:
     * 输入中标粗的位置即为输出表示的路径，即
     * 0行0列（左上角） -> 0行1列 -> 0行2列 -> 1行2列 -> 2行2列（右下角）
     * 说明：r 和 c 的值均不超过 100。
     * 链接：https://leetcode-cn.com/problems/robot-in-a-grid-lcci
     * @param obstacleGrid
     * @return
     */
    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        List<List<Integer>> paths=new ArrayList<>();
        if(obstacleGrid==null||obstacleGrid.length<1||obstacleGrid[0][0]==1) return paths;
        int r=obstacleGrid.length,c=obstacleGrid[0].length;
        /**
         *  visited数组 描述位置的三种状态
         *  0-未访问过,
         *  1-已访问过,但是不可通过,
         *  2-访问过并且可以通过
         */
        byte[][]visited = new byte[r][c];
        path(r-1, c-1, visited,obstacleGrid,paths);
        return paths;
    }

    /**
     * 判断当前位置是否可以通过
     * @param x
     * @param y
     * @param obstacles
     * @return
     */
    private boolean isPass(int x,int y,int[][]obstacles){

        if(x<0||x>=obstacles.length||y<0||y>=obstacles[0].length) return false;
        return obstacles[x][y]!=1;
    }

    public boolean path(int r,int c,byte[][]visited,int[][]obstacles,List<List<Integer>> paths){

        if(!isPass(r,c,obstacles)) return false;
        if(visited[r][c]!=0){
            return visited[r][c]!=1;
        }
        boolean success=false;
        if(r==0&&c==0) success=true;
        if(!success&&r>=1&&isPass(r-1,c,obstacles)){
            success = path(r - 1, c, visited, obstacles,paths);
        }
        if(!success&&c>=1&&isPass(r,c-1,obstacles)){
            success = path(r, c - 1, visited, obstacles,paths);
        }
        if(success){
            paths.add(Arrays.asList(r, c));
            visited[r][c]=2;
        }else{
            visited[r][c]=1;
        }
        return success;
    }

    public static void main(String[] args){

        int[][]grids={{0,0,0},{0,1,0}, {0,0,0}};

        PathWithObstacles path = new PathWithObstacles();
        System.out.println(path.pathWithObstacles(grids));

    }


}

