package com.leetcode.disjoint;

public class FriendCircles {


    class UnionFind {

        /*存储一颗树*/
        private int[] parent;

        /*记录树的重量*/
        private int[] rank;

        /*连通分量的个数*/
        private int count;

        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;//自己指向自己
                rank[i] = 1;
            }
        }

        /**
         * 返回节点u的根节点
         *
         * @param u
         * @return
         */
        public int find(int u) {


            while (u != parent[u]) {
                /*压缩路径*/
                parent[u] = parent[parent[u]];
                u = parent[u];
            }
            return u;
        }

        /**
         * 合并u所属的树和v所属的树
         *
         * @param u
         * @param v
         */
        public void union(int u, int v) {

            u = find(u);
            v = find(v);
            if (u == v) return;

            if (rank[u] > rank[v]) {
                parent[v] = u;
                rank[u] += rank[v];
            } else {
                parent[u] = v;
                rank[v] += rank[u];
            }
            count--;

        }

        public int getCount() {
            return count;
        }
    }

    public int findCircleNum(int[][] M) {

        UnionFind uf = new UnionFind(M.length);

        for(int i=0;i<M.length;i++){

            for(int j=0;j<M.length;j++){
                if(M[i][j]==1){
                    uf.union(i,j);
                }

            }

        }
        return uf.getCount();


    }

    public static void main(String[] args) {

    }

}
