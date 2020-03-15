package com.leetcode.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CriticalConnectionsInANetwork {


    /**
     * 力扣数据中心有 n 台服务器，分别按从 0 到 n-1 的方式进行了编号。
     * 它们之间以「服务器到服务器」点对点的形式相互连接组成了一个内部集群，
     * 其中连接 connections 是无向的。从形式上讲，connections[i] = [a, b] 
     * 表示服务器 a 和 b 之间形成连接。任何服务器都可以直接或者间接地通过网络
     * 到达任何其他服务器。「关键连接」是在该集群中的重要连接，也就是说，假如
     * 我们将它移除，便会导致某些服务器无法访问其他服务器。
     * 请你以任意顺序返回该集群内的所有 「关键连接」。
     *
     * 示例 1：
     * 输入：n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
     * 输出：[[1,3]]
     * 解释：[[3,1]] 也是正确的。
     * 提示：
     * 1 <= n <= 10^5
     * n-1 <= connections.length <= 10^5
     * connections[i][0] != connections[i][1]
     * 不存在重复的连接
     * 链接：https://leetcode-cn.com/problems/critical-connections-in-a-network
     * @param n
     * @param connections
     * @return
     * 算法:tarjan 算法
     */

    /* 代表dfs时搜索到u节点时的次序编号(时间戳),可知在同一个dfs树的子树中,
        dfn[u]越小，则其越浅*/
    private int []dfn;


    /*low[u]: 代表在dfs树中,low[u]为u或者u的子树能够追溯到的最早的栈中节点
              (代表在dfs树中,此点以及其后代指出去的边,能返回到的最浅的节点的时间戳)*/
    private int []low;


    //图的邻接表
    private List<Integer>[] adj;


    private int timestamp=0;


    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        dfn = new int[n];
        low = new int[n];
        Arrays.fill(dfn,-1);
        adj = new List[n];
        for(int i=0;i<n;i++){
            adj[i] = new ArrayList<>(2);
        }
        //构建图
        for(List<Integer> edges:connections){
            adj[edges.get(0)].add(edges.get(1));
            adj[edges.get(1)].add(edges.get(0));
        }
        List<List<Integer>> ans = new ArrayList<>();
        dfs(0,ans, -1);
        return ans;
    }

    public void dfs(int u,List<List<Integer>> ans,int parent){

        if(dfn[u]!=-1) return;

        timestamp++;
        low[u]=timestamp;
        dfn[u]=timestamp;
        for (int v : adj[u]) {

            if(v==parent){
                continue;
            }
            if (dfn[v]==-1){
                dfs(v,ans,u);
                //回溯过程中,及时更新当前节点其子树指出去的边能没有指向更浅层的节点
                low[u] = Math.min(low[v],low[u]);
                if(low[v]>dfn[u]){//子节点low[v]大于父节点的dfn[u]
                    ans.add(Arrays.asList(u, v));
                }
            }else {

                low[u] = Math.min(low[u], dfn[v]);
            }
        }
    }


    public static void main(String[] args) {



        CriticalConnectionsInANetwork network = new CriticalConnectionsInANetwork();



    }

}
