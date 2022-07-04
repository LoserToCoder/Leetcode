package com.leetcode.linklist;

public class ReverseList {

    /***
     反转一个单链表。
     示例:
         输入: 1->2->3->4->5->NULL
         输出: 5->4->3->2->1->NULL
     进阶:
     你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
     链接：https://leetcode-cn.com/problems/reverse-linked-list
     * @param head
     * @return
     * 解题思路:
     *  一边迭代遍历,一边改变指针的指向
     */
    public ListNode reverseList(ListNode head) {

        //头插法
        ListNode prev=null;
        ListNode cur=head;
        while(cur!=null){
            //将当前节点下一个节点引用存储
            ListNode curTmp=cur.next;
            //当前节点的下一个节点应该是上一个节点的引用指向
            cur.next=prev;
            // 让后再将当前节点指向prev
            prev=cur;
            // 当前节点指向curTmp
            cur=curTmp;
        }
        return prev;
    }
    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            this.val=x;
        }

    }

}
