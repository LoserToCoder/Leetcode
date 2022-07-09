package com.leetcode.linklist;

public class AddInList {



    /**
     * 描述
     * 假设链表中每一个节点的值都在 0 - 9 之间，那么链表整体就可以代表一个整数。
     * 给定两个这种链表，请生成代表两个整数相加值的结果链表。
     * 数据范围：0<=n,,m≤1000000，链表任意值 0≤val≤9
     * 要求：空间复杂度 O(n)，时间复杂度 O(n)
     *
     * 例如：链表 1 为 9->3->7，链表 2 为 6->3，最后生成新的结果链表为 1->0->0->0。
     *
     * 示例1
     * 输入：
     * [9,3,7],[6,3]
     * 返回值：
     * {1,0,0,0}
     * 示例2
     * 输入：
     * [0],[6,3]
     * 返回值：
     * {6,3}
     * @param head1
     * @param head2
     * @return
     * 算法: 把链表翻转,求和，然后再把结果链表翻转即可
     */
    public ListNode addInList (ListNode head1, ListNode head2) {
        // write code here
        ListNode firstNode =  reverse(head1);
        ListNode secondNode = reverse(head2);

        ListNode dummyNode = new ListNode(0);
        ListNode p =dummyNode;
        while(firstNode!=null || secondNode!=null){

            int val = p.val;
            if(firstNode!=null){
                val+=firstNode.val;
                firstNode = firstNode.next;
            }
            if(secondNode!=null){
                val+=secondNode.val;
                secondNode = secondNode.next;
            }
            p.val =val%10;
            if(firstNode!=null||secondNode!=null||val>=10){
                p.next = new ListNode(val/10);
                p = p.next;
            }

        }
        return reverse(dummyNode);
    }
    public ListNode reverse(ListNode head) {

        ListNode prev = null;
        ListNode cur = head;
        while(cur!=null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
