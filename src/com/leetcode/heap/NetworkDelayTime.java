package com.leetcode.heap;

import java.util.*;

public class NetworkDelayTime {


    /***
     *
     * @param times 表示信号经过有向边的传递时间
     *              times[i] = (u, v, w)
     * @param N 网络节点
     * @param K 当前节点
     * @return
     */
    private Map<Integer, Integer> dist = new HashMap<>();
    public int networkDelayTime(int[][] times, int N, int K) {

        Map<Integer, List<int[]>> graph = new HashMap<>();

        for (int[] edge:times){

            if (!graph.containsKey(edge[0])) {
                graph.put(edge[0], new ArrayList<>());
            }
            graph.get(edge[0]).add(new int[]{edge[2], edge[1]});
        }

        for(int node:graph.keySet()){
            Collections.sort(graph.get(node),(a,b)->a[0]-b[0]);
        }


        for(int node=1;node<=N;node++){
            dist.put(node, Integer.MAX_VALUE);
        }

        dfs(graph,K,0);
        int ans=0;
        for(int cand:dist.values()){

            if(cand==Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, cand);
        }
        return ans;
    }

    public void dfs(Map<Integer, List<int[]>> graph, int node, int elapsed) {

        if (elapsed >= dist.get(node)) return;

        dist.put(node, elapsed);
        if(graph.containsKey(node)){

            for (int[] nodes : graph.get(node)) {
                dfs(graph,nodes[1],elapsed+nodes[0]);
            }
        }


    }



    public static void main(String[] args) {


    }
}
