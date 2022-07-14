package com.leetcode.tree;

import com.leetcode.linklist.ListNode;

public class SortedListNodeToBST {

    /**
     * 给定一个单链表的头节点head，其中的元素 按升序排序 ，将其转换为高度平衡的二叉搜索树。
     * 本题中，一个高度平衡二叉树是指一个二叉树每个节点的左右两个子树的高度差不超过 1。
     *
     * 示例 1:
     * 输入: head = [-10,-3,0,5,9]
     * 输出: [0,-3,9,-10,null,5]
     * 解释: 一个可能的答案是[0，-3,9，-10,null,5]，它表示所示的高度平衡的二叉搜索树。
     *
     * 示例 2:
     * 输入: head = []
     * 输出: []
     *
     * 提示:
     * head中的节点数在[0, 2 * 104]范围内
     * -10^5<= Node.val <= 10^5
     *
     * 链接：https://leetcode.cn/problems/convert-sorted-list-to-binary-search-tree
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {
        return builder(head,null);
    }
    public TreeNode builder(ListNode head,ListNode tail){
        if(head==tail){
            return null;
        }
        ListNode midNode = getMidNode(head,tail);
        TreeNode root = new TreeNode(midNode.val);
        root.left = builder(head,midNode);
        root.right = builder(midNode.next,tail);
        return root;
    }
    //可以借鉴快慢指针，来定位中间节点
    public ListNode getMidNode(ListNode head,ListNode tail){
        int preIndex =0;
        int curIndex = 0;
        ListNode pre = head;
        ListNode next = head;
        while(next!=null && next!=tail){
            curIndex++;
            next = next.next;
            if(preIndex<curIndex/2){
                preIndex++;
                pre = pre.next;
            }
        }
        return pre;
    }

    /**
     * 快慢指针的解法
     * @param head
     * @param tail
     * @return
     */
    public ListNode getMedian(ListNode head,ListNode tail){
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=tail&&fast.next!=tail){
            fast = fast.next;
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
