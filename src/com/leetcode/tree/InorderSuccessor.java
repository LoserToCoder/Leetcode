package com.leetcode.tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class InorderSuccessor {

    /**
     * 给定一棵二叉搜索树和其中的一个节点 p ，找到该节点在树中的中序后继。如果节点没有中序后继，请返回 null。
     * 节点 p 的后继是值比 p.val 大的节点中键值最小的节点，即按中序遍历的顺序节点 p 的下一个节点。
     * 示例 1：
     *
     * 输入：root = [2,1,3], p = 1
     * 输出：2
     * 解释：这里 1 的中序后继是 2。请注意 p 和返回值都应是 TreeNode 类型。
     *
     * 示例 2：
     *
     * 输入：root = [5,3,6,2,4,null,null,1], p = 6
     * 输出：null
     * 解释：因为给出的节点没有中序后继，所以答案就返回 null 了。
     *
     *
     * 提示：
     * 树中节点的数目在范围 [1, 104] 内。
     * -105 <= Node.val <= 105
     * 树中各节点的值均保证唯一。
     *
     */
    /**
     * 二叉搜索树
     * @param root
     * @param p
     * @return
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

        TreeNode successor = null;
        TreeNode cur = root;
        while(cur!=null){
            if(cur.val> p.val) {
                successor = cur;
                cur = cur.left;
            } else {
                // cur.val == p.val;
                cur = cur.right;
            }
        }
        return successor;
    }

    public TreeNode inorderSuccessorNonSort(TreeNode root, TreeNode p){
        TreeNode prev = null;
        TreeNode cur = root;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (cur != null) {

            if(cur.left!=null){
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                if(prev==p) {
                    return cur;
                }
                prev = cur;
                cur = cur.right;
            }
        }
        return cur;
    }
}
