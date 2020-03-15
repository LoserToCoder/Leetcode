package com.leetcode.graph;

public class FriendCircle {


    public int findCircleNum(int[][]M){


        int ans=0;
        boolean[] visited = new boolean[M.length];
        for(int i=0;i<M.length;i++){

            if(!visited[i]){
                ans++;
                dfs(M,visited,i);
            }

        }

        return ans;


    }


    private void dfs(int[][]M,boolean[]visited,int i){

        if(visited[i]) return;
        visited[i]=true;
        for(int j=0;j<M.length;j++){

            if (!visited[j] && M[i][j] == 1) {
                dfs(M,visited,j);
            }

        }
    }


}
