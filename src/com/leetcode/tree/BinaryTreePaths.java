package com.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    private List<String> ans =new ArrayList<>();
    private List<Integer> list = new ArrayList<>();

    /***
     * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
     * 叶子节点 是指没有子节点的节点
     *
     * 示例 1：
     * 输入：root = [1,2,3,null,5]
     * 输出：["1->2->5","1->3"]
     *
     * 示例 2：
     * 输入：root = [1]
     * 输出：["1"]
     *
     * 提示：
     * 树中节点的数目在范围 [1, 100] 内
     * -100 <= Node.val <= 100
     *
     * 链接：https://leetcode.cn/problems/binary-tree-paths
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode node){
        if(node==null){
            return;
        }
        list.add(node.val);
        if(node.left==null && node.right==null){
            ans.add(getPath(list));
        }else{
            dfs(node.left);
            dfs(node.right);
        }
        //回溯
        list.remove(list.size()-1);
    }
    private String getPath(List<Integer> list){
        StringBuilder sb = new StringBuilder();
        int n= list.size();
        sb.append(list.get(0));
        for(int i=1;i<n;i++){
            sb.append("->");
            sb.append(list.get(i));
        }
        return sb.toString();
    }
}
