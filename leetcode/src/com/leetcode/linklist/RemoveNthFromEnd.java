package com.leetcode.linklist;

public class RemoveNthFromEnd {
    /**
     给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     示例：
     给定一个链表: 1->2->3->4->5, 和 n = 2.
     当删除了倒数第二个节点后，链表变为 1->2->3->5.
     说明：
     给定的 n 保证是有效的。
     链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list

     两个指针,一个指针遍历,并记录遍历的元素个数
              另一个指针保持则保持距离,这个距离差就是n
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if(head==null) return null;
        ListNode prev=head;
        ListNode cur=head.next;
        int pos=1;
        int size=1;
        while (cur!=null){
            if(n+pos==size){
                pos++;
                prev=prev.next;
            }
            size++;
            cur=cur.next;
        }
        if(n==size) return head.next;//极端情况,删除第一个元素
        prev.next=prev.next.next;
        return head;
    }
}
