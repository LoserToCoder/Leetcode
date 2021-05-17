package com.leetcode.tree;

public class CousinsInBinaryTree {


    /**
     *在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
     *
     * 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。
     *
     * 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。
     *
     * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。
     *
     * 
     *
     * 示例 1：
     *
     *
     * 输入：root = [1,2,3,4], x = 4, y = 3
     * 输出：false
     * 示例 2：
     *
     *
     * 输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
     * 输出：true
     * 示例 3：
     *
     *
     *
     * 输入：root = [1,2,3,null,4], x = 2, y = 3
     * 输出：false
     * 
     *
     * 提示：
     *
     * 二叉树的节点数介于2 到100之间。
     * 每个节点的值都是唯一的、范围为1 到100的整数。
     *
     * 链接：https://leetcode-cn.com/problems/cousins-in-binary-tree
     * @param root
     * @param x
     * @param y
     * @return
     */
    public boolean isCousins(TreeNode root, int x, int y) {
        Result xNodeResult = getCurTreeNode(root, x,0);
        Result yNodeResult = getCurTreeNode(root, y, 0);
        if(xNodeResult==null||yNodeResult==null){
            return false;
        }
        return xNodeResult.depth== yNodeResult.depth&&xNodeResult.parent!= yNodeResult.parent;
    }

    private Result getCurTreeNode(TreeNode root,int x,int depth){

        if(root==null){
            return null;
        }
        if(root.left != null && root.left.val==x){
            return new Result(root, depth + 1);
        }
        if(root.right!=null && root.right.val==x){
            return new Result(root, depth + 1);
        }
        Result leftResult=getCurTreeNode(root.left,x,depth+1);
        if(leftResult!=null){
            return leftResult;
        }
        return getCurTreeNode(root.right, x, depth + 1);
    }


    class Result{
        TreeNode parent;
        int depth;
        public Result(TreeNode parent,int depth){
            this.parent = parent;
            this.depth =depth;
        }
    }






}
