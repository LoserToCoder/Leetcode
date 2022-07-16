package com.leetcode.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;

public class PathSumIII {



    /**
     * 给定一个二叉树的根节点 root，和一个整数 targetSum ，求该二叉树里节点值之和
     * 等于 targetSum 的 路径 的数目。路径 不需要从根节点开始，也不需要在叶子节点结束，
     * 但是路径方向必须是向下的（只能从父节点到子节点）。
     *
     * 示例 1：
     * 输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
     * 输出：3
     * 解释：和等于 8 的路径有 3 条，如图所示。
     *
     * 示例 2：
     * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
     * 输出：3
     *
     * 提示:
     * 二叉树的节点个数的范围是 [0,1000]
     * -10^9<= Node.val <= 10^9
     * -1000<= targetSum<= 1000
     *
     * 链接：https://leetcode.cn/problems/path-sum-iii
     * @param root
     * @param targetSum
     * @return
     */

    private Map<Long, Integer> prefixMap = new HashMap<>();
    public int pathSum(TreeNode root, int targetSum) {
        prefixMap.put(0L, 1);
        return dfs(root,0, targetSum);
    }

    public int dfs(TreeNode root,long curr, int targetSum) {
        if (root == null) {
            return 0;
        }
        int ret = 0;
        curr += root.val;
        ret = prefixMap.getOrDefault(curr - targetSum, 0);
        prefixMap.put(curr, prefixMap.getOrDefault(curr, 0) + 1);
        ret += dfs(root.left, curr, targetSum);
        ret += dfs(root.right, curr, targetSum);
        prefixMap.put(curr, prefixMap.getOrDefault(curr, 0) - 1);
        return ret;

    }
}

