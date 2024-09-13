package com.leetcode.linklist;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ListOfDepth {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    /**
    给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。
    示例：


    输入：[1,2,3,4,5,null,7,8]

                  1
                /  \
              2     3
             / \     \
            4   5     7
            /
           8
    输出：[[1],[2,3],[4,5,7],[8]]

    **/

    /**
     *  层次遍历 遍历完一层的控制, 通过每一层的size 来控制,
     *  有了第一层的size,剩下只需要通过出队列的size个数来结束控制就行
     * @param tree
     * @return
     */
    public ListNode[] listOfDepth(TreeNode tree) {

        if(tree == null) return null;
        List<ListNode> list = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(tree);
        while(!queue.isEmpty()) {

            int curLevelSize = queue.size();
            ListNode head = null;
            ListNode next = null;

            while(curLevelSize>0) {

                TreeNode node = queue.poll();
                ListNode newNode = new ListNode(node.val);
                if(head==null) {
                    head = newNode;
                    next = newNode;
                } else {
                    next.next = newNode;
                    next = next.next;
                }
                if(node.left!=null) {
                    queue.add(node.left);
                }
                if(node.right!=null) {
                    queue.add(node.right);
                }
                curLevelSize--;
            }
            list.add(head);
        }

        return list.toArray(new ListNode[]{});

    }
}
