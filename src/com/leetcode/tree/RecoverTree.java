package com.leetcode.tree;

import java.util.Stack;

public class RecoverTree {

    //前驱-predecessor,后继-successor

    /**
     * 给你二叉搜索树的根节点 root ，该树中的 恰好 两个节点的值被错误地交换。请在不改变其结构的情况下，恢复这棵树。
     *
     * 示例 1：
     * 输入：root = [1,3,null,null,2]
     * 输出：[3,1,null,null,2]
     * 解释：3 不能是 1 的左孩子，因为 3 > 1 。交换 1 和 3 使二叉搜索树有效。
     *
     * 示例 2：
     * 输入：root = [3,1,4,null,null,2]
     * 输出：[2,1,4,null,null,3]
     * 解释：2 不能在 3 的右子树中，因为 2 < 3 。交换 2 和 3 使二叉搜索树有效。
     *
     * 提示：
     * 树上节点的数目在范围 [2, 1000] 内
     * -2^31 <= Node.val <= 2^31 - 1
     *
     * 进阶：使用 O(n) 空间复杂度的解法很容易实现。你能想出一个只使用O(1) 空间的解决方案吗？
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/recover-binary-search-tree
     * @param root
     */
    public void recoverTree(TreeNode root) {

        if(root==null) return;

        Stack<TreeNode> s = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;
        TreeNode x = null,y = null;
        while(cur!=null || !s.isEmpty()){

            if(cur!=null){
                s.push(cur);
                cur = cur.left;
            }else{
                cur = s.pop();
                if(pre==null){
                    pre=cur;
                }
                if(x==null && pre.val>cur.val) x = pre;
                if(x!=null && pre.val>cur.val) y = cur;
                pre = cur;
                cur = cur.right;
            }
        }
        int temp = x.val;
        x.val = y.val;
        y.val = temp;

    }


    TreeNode x = null;
    TreeNode y = null;
    TreeNode pre= new TreeNode(Integer.MIN_VALUE);
    public void recoverTree1(TreeNode root) {
        inOrder(root);
        if(x!=null&&y!=null){
            int temp = x.val;
            x.val =y.val;
            y.val = temp;
        }
    }

    private void inOrder(TreeNode root) {
        if(root==null) return;
        inOrder(root.left);
        if(x==null && pre.val>root.val) x = pre;
        if(x!=null && pre.val>root.val) y = root;
        pre = root;
        inOrder(root.right);
    }
}
