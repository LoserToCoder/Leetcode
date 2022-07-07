package com.leetcode.linklist;

public class RemoveNthFromEnd {

    /**
     * 给定一个链表，删除链表的倒数第n个节点，并且返回链表的头结点。
     *      示例：
     *      给定一个链表: 1->2->3->4->5, 和 n = 2.
     *      当删除了倒数第二个节点后，链表变为 1->2->3->5.
     *      说明：
     *      给定的 n保证是有效的。
     *      链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
     *  算法: 双指针,快慢指针
     *  先让快指针走n步,然后慢指针和快指针再以同样的步伐保持n步距离,直至遍历结束
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode fast = head;
        ListNode slow = dummyNode;
        for (int i = 0; i < n; ++i) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummyNode.next;
    }
}
