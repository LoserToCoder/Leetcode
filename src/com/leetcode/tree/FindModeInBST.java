package com.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class FindModeInBST {



    /**
     * 给你一个含重复值的二叉搜索树（BST）的根节点 root ，
     * 找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。
     *
     * 如果树中有不止一个众数，可以按 任意顺序 返回。
     * 假定 BST 满足如下定义：
     *  结点左子树中所含节点的值 小于等于 当前节点的值
     *  结点右子树中所含节点的值 大于等于 当前节点的值
     *  左子树和右子树都是二叉搜索树
     *
     * 示例 1：
     * 输入：root = [1,null,2,2]
     * 输出：[2]
     *
     * 示例 2：
     * 输入：root = [0]
     * 输出：[0]
     *
     * 提示：
     * 树中节点的数目在范围 [1, 104] 内
     * -10^5 <= Node.val <= 10^5
     * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
     * 链接：https://leetcode.cn/problems/find-mode-in-binary-search-tree
     * @param root
     * @return
     */
    private List<Integer> ans= new ArrayList<Integer>();
    private int base, count, maxCount;
    public int[] findMode(TreeNode root) {
        dfs(root);
        int[] mode = new int[ans.size()];
        for (int i = 0; i < ans.size(); ++i) {
            mode[i] = ans.get(i);
        }
        return mode;
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        update(node.val);
        dfs(node.right);
    }

    public void update(int curVal) {
        if (curVal == base) {
            ++count;
        } else {
            count = 1;
            base = curVal;
        }
        if (count == maxCount) {
            ans.add(base);
        }
        if (count > maxCount) {
            maxCount = count;
            ans.clear();
            ans.add(base);
        }
    }
}
