package com.leetcode.disjoint;

public class RedundantConnection{

   
    
    class DUF{
       
       private int[]parent;

       private int[]rank;

       public DUF(int n){

       	  parent=new int[n];

       	  rank=new int[n];

       	  for(int i=0;i<n;i++){
       	  	 parent[i]=i;
       	  	 rank[i]=1;
       	  }

       }

       public int find(int u){
          
         while(u!=parent[u]){

         	parent[u]=parent[parent[u]];
         	u=parent[u];
         }
         return u;
       }

       public boolean isUnion(int u,int v){
           
           u=find(u);
           v=find(v);

           if(u==v) return false;

           if(rank[u]>rank[v]){
           	  parent[v]=u;
           	  rank[u]+=rank[v];
           }else{
           	  parent[u]=v;
           	  rank[v]+=rank[u];
           }
           return true;

       }


    }



    public int[] findRedundantConnection(int[][] edges) {

          DUF uf=new DUF(edges.length+1);

          for(int[]e:edges){

             if(!uf.isUnion(e[0],e[1])) return e;

          }
          return new int[0];
    }



}