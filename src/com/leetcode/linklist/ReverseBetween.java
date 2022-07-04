package com.leetcode.linklist;

public class ReverseBetween {

    /**
     *描述
     * 将一个节点数为 size 链表 m 位置到 n 位置之间的区间反转，要求时间复杂度 O(n)，空间复杂度 O(1)。
     * 例如：
     * 给出的链表为    1→2→3→4→5→NULL, m=2,n=4
     * 返回 1→4→3→2→5→NULL.
     *
     * 数据范围： 链表长度 0 < size \le 10000<size≤1000，，链表中每个节点的值满足 |val|≤1000
     * 要求：时间复杂度 O(n) ，空间复杂度 O(n)
     * @param head ListNode类
     * @param m int整型
     * @param n int整型
     * @return ListNode类
     */
    public ListNode reverseBetween (ListNode head, int m, int n) {

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        //考虑边界问题
        ListNode pre = dummyNode;
        for (int i = 0; i < m-1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next;
        for (int i = 0; i < n - m ; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;//此处必须使用pre.next,头插法
            pre.next = next;
        }
        return dummyNode.next;
    }
}
