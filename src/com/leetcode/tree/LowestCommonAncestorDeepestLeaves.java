package com.leetcode.tree;

public class LowestCommonAncestorDeepestLeaves {

    /**
     *
     * 给定一个根为 root 的二叉树，每个节点的深度是 该节点到根的最短距离 。
     *
     * 如果一个节点在 整个树 的任意节点之间具有最大的深度，则该节点是 最深的 。
     *
     * 一个节点的 子树 是该节点加上它的所有后代的集合。
     *
     * 返回能满足 以该节点为根的子树中包含所有最深的节点 这一条件的具有最大深度的节点。
     *
     *
     * 示例 1：
     * 输入：root = [3,5,1,6,2,0,8,null,null,7,4]
     * 输出：[2,7,4]
     * 解释：
     * 我们返回值为 2 的节点，在图中用黄色标记。
     * 在图中用蓝色标记的是树的最深的节点。
     * 注意，节点 5、3 和 2 包含树中最深的节点，但节点 2 的子树最小，因此我们返回它。
     *
     *
     * 示例 2：
     * 输入：root = [1]
     * 输出：[1]
     * 解释：根节点是树中最深的节点。
     * 示例 3：
     *
     * 输入：root = [0,1,3,null,2]
     * 输出：[2]
     * 解释：树中最深的节点为 2 ，有效子树为节点 2、1 和 0 的子树，但节点 2 的子树最小。
     *
     * 提示：
     * 树中节点的数量介于1 和500 之间。
     * 0 <= Node.val <= 500
     * 每个节点的值都是独一无二的。
     *
     * 链接：https://leetcode-cn.com/problems/smallest-subtree-with-all-the-deepest-nodes
     * 自底向上
     * @param root
     * @return
     */
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return dfs(root).node;
    }
    public Result dfs(TreeNode node){

        if(node==null){
            return new Result(null, 0);
        }
        Result leftResult = dfs(node.left);
        Result rightResult = dfs(node.right);
        //如果左节点的深度大于右边节点的深度,则说明结果在左节点
        if(leftResult.depth< rightResult.depth){
            return new Result(rightResult.node, rightResult.depth + 1);
        }else if(leftResult.depth> rightResult.depth){
            return new Result(leftResult.node, leftResult.depth+1);
        }
        return new Result(node, leftResult.depth+1);
    }


    class Result {

        TreeNode node;
        int depth;
        Result(TreeNode node,int depth){
            this.node = node;
            this.depth = depth;
        }

    }

}
