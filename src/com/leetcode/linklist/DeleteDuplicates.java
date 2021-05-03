package com.leetcode.linklist;

public class DeleteDuplicates {


    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return null;
        ListNode prev=head;
        ListNode cur=head.next;
        while (cur!=null){
            if(prev.val==cur.val){
                prev.next=cur.next;
            }else{
                prev=cur;
            }
            cur=cur.next;
        }
        return head;
    }
}
