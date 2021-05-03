package com.leetcode.graph;

import com.leetcode.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;

/**
 *  algorithm:topological-sort
 *  implement:dfs
 */
public class CourseScheduleOptimized {
    //有向图 邻接链表
    private List<List<Integer>> edges = null;
    // 0-未访问过,1-代表搜索中,2-搜索结束
    private int [] visited;
    private boolean isCycle = false;
    //存放结果,模拟栈
    private int [] results;
    //栈指针
    private int idx;
    /**
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        if(numCourses<=0){
            return new int[0];
        }

        visited = new int[numCourses];
        results = new int[numCourses];
        idx = numCourses-1;
        edges = new ArrayList<>(numCourses);

        //initial edges
        for(int edge=0;edge<numCourses;edge++){
            edges.add(null);
        }

        //builder adj matrix
        for(int i=0;i<prerequisites.length;i++){
            int v = prerequisites[i][0];
            int u = prerequisites[i][1];
            List<Integer> vertexs= edges.get(u);
            if(vertexs==null){
                vertexs = new ArrayList<>();
                edges.set(u, vertexs);
            }
            vertexs.add(v);
        }
        for(int i=0;i<numCourses;i++){
            if(visited[i]==0)//未访问
                dfs(i);
        }
        if(isCycle){
            return new int[0];
        }

        return results;
    }

    public void dfs(int u){
        visited[u] = 1;//搜索中
        if(edges.get(u)!=null){

            for(int v:edges.get(u)){
                if(visited[v]==0){
                    dfs(v);
                }else if(visited[v]==1){
                    isCycle = true;
                }
                if(isCycle){
                    return;
                }
            }
        }
        visited[u] = 2;//搜索结束
        results[idx--] = u;

    }

    public static void main(String[] args) {
        int n=4;
        int [][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
        CourseScheduleOptimized courseScheduleOptimized = new CourseScheduleOptimized();
        int[] order = courseScheduleOptimized.findOrder(n, prerequisites);

        System.out.println(StringUtils.arrayToString(order));


    }


}
