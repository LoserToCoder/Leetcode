package com.leetcode.tree;

import java.util.*;

public class LevelOrderBottom {


    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        if(root==null){
            return Collections.EMPTY_LIST;
        }
        LinkedList<List<Integer>> levelLists = new LinkedList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){

            int n = queue.size();
            List<Integer> sub = new ArrayList<>();
            for(int i=0;i<n;i++){

                TreeNode treeNode = queue.poll();
                sub.add(treeNode.val);

                if(treeNode.left!=null){
                    queue.add(treeNode.left);
                }
                if(treeNode.right!=null){
                    queue.add(treeNode.right);
                }
            }
            levelLists.addFirst(sub);
        }

        return levelLists;
    }
}
