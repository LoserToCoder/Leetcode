package com.leetcode.design;

import java.util.Stack;

/**
 实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
 调用 next() 将返回二叉搜索树中的下一个最小的数。
 示例:
 BSTIterator iterator = new BSTIterator(root);
 iterator.next();    // 返回 3
 iterator.next();    // 返回 7
 iterator.hasNext(); // 返回 true
 iterator.next();    // 返回 9
 iterator.hasNext(); // 返回 true
 iterator.next();    // 返回 15
 iterator.hasNext(); // 返回 true
 iterator.next();    // 返回 20
 iterator.hasNext(); // 返回 false
 提示：
 next()和hasNext()操作的时间复杂度是O(1)，并使用O(h) 内存，其中h是树的高度。
 你可以假设next()调用总是有效的，也就是说，当调用 next()时，BST 中至少存在一个
 下一个最小的数。
 链接：https://leetcode-cn.com/problems/binary-search-tree-iterator
 */
class TreeNode{
   int val;
   TreeNode left;
   TreeNode right;
   TreeNode(int x) { val = x; }
}

public class BSTIterator {

    private TreeNode cur;
    private Stack<TreeNode> stack=new Stack<>();
    public BSTIterator(TreeNode root) {
        cur=root;
    }
    /** @return the next smallest number */
    public int next() {
      while(cur!=null){
         stack.push(cur);
         cur=cur.left;
      }
      if(stack.isEmpty()) return 0;
      TreeNode node=stack.pop();
      cur=node.right;
      return node.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        //栈不为空或者现在访问的是根节点,然后切换到右分支时候,栈此时并没有元素
        return !stack.isEmpty()||cur!=null;
    }


    public static void main(String[] args) {

    }
}


