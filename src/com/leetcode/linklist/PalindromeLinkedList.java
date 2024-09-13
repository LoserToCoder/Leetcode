package com.leetcode.linklist;

import java.util.ArrayDeque;

public class PalindromeLinkedList {

  public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
    /**
     * 编写一个函数，检查输入的链表是否是回文的。
     *
     * 示例 1：
     * 输入： 1->2
     * 输出： false
     *
     * 示例 2：
     * 输入： 1->2->2->1
     * 输出： true
     *
     * 进阶：
     * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
     **/
    public boolean isPalindrome(ListNode head) {

        ListNode midNode = findMid(head);
        ListNode  reverse = reverse(midNode);
        return isEqual(head,reverse);
    }

    public boolean isEqual(ListNode p,ListNode q) {

        while(q!=null && p!=null) {
            if(q.val != p.val) {
                return false;
            }
            q = q.next;
            p = p.next;
        }
        return q==null && q==null;
    }


    public ListNode reverse(ListNode head) {

        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {

            ListNode next = cur.next;
            // 连接反转的链表
            cur.next = prev;
            // prev指向反向链表的头节点
            prev = cur;
            cur = next;

        }
        return prev;

    }

    public ListNode findMid(ListNode head) {

        ListNode fast = head, slow = head;

        while(fast!=null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.add(1);
        deque.add(2);
        deque.add(3);
        deque.add(4);

        while (!deque.isEmpty()){
            System.out.println(deque.poll());
        }
    }
}
