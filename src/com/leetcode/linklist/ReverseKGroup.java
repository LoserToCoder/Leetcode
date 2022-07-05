package com.leetcode.linklist;

public class ReverseKGroup {


   
    /***
     *  给你链表的头节点 head ，每k个节点一组进行翻转，请你返回修改后的链表。
     *  k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是k的整数倍，
     *  那么请将最后剩余的节点保持原有顺序。
     *  你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
     *
     *  来源：力扣（LeetCode）
     *  链接：https://leetcode.cn/problems/reverse-nodes-in-k-group
     **/
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //prev 代表待翻转链表的前驱
        ListNode prev = dummy;
        //end 代表待翻转链表的末尾
        ListNode end = dummy;

        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) end = end.next;
            if (end == null) break;
            // start 待翻转链表的起始节点
            ListNode start = prev.next;
            // next 记录下一个节点的指向
            ListNode next = end.next;
            //切断[start,end]这段
            end.next = null;
            //反转,连接
            prev.next = reverse(start);
            //上段下一个指向
            start.next = next;
            //pre 指向下一个段
            prev = start;
            end = prev;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
           ListNode next = cur.next;
           cur.next = prev;
           prev = cur;
           cur = next;
        }
        return prev;
    }
}
