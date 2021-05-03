package com.leetcode.graph;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {


    /**
     * 现在你总共有 n 门课需要选，记为0到n-1。
     * 在选修某些课程之前需要一些先修课程。例如，想要学习课程 0 ，
     * 你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
     * 给定课程总量以及它们的先决条件，判断是否可能完成所有课程的学习？
     *
     * 示例 1:
     *
     * 输入: 2, [[1,0]]
     * 输出: true
     * 解释:总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
     * 示例 2:
     *
     * 输入: 2, [[1,0],[0,1]]
     * 输出: false
     * 解释:总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
     * 说明:
     * 输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。详情请参见图的表示法。
     * 你可以假定输入的先决条件中没有重复的边。
     * 链接：https://leetcode-cn.com/problems/course-schedule
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        boolean[] visited = new boolean[numCourses];

        boolean[] rec = new boolean[numCourses];

        List<Integer> [] adj=new List[numCourses];
        for(int i=0;i<numCourses;i++){
            adj[i] = new ArrayList<>();
        }

        for(int []p:prerequisites){
            adj[p[0]].add(p[1]);
        }

        for(int i=0;i<numCourses;i++){

            if(dfs(i,visited,rec,adj)){
                return false;
            }

        }

        return true;
    }

    private boolean dfs(int u,boolean[]visited,boolean[]rec,List<Integer>[]adj){


        if(rec[u]) return true;

        if(visited[u]) return false;

        visited[u]=true;

        rec[u]=true;

        for(int v:adj[u]){

            if(dfs(v,visited,rec,adj)){
                return true;
            }
        }
        rec[u]=false;
        return false;
    }




    public static void main(String[] args) {

    }

}
