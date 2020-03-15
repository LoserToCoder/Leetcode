package com.leetcode.linklist;

public class SwapPairs {


    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode swapPairs(ListNode head) {
        if(head==null||(head!=null&&head.next==null)){
            return head;
        }
        ListNode first=head;
        ListNode second=null;
        ListNode tmp=null;
        ListNode iter =new ListNode(-1);
        ListNode pairs=iter;
        while (first!=null&&(second=first.next)!=null){
            tmp=second.next;
            first.next=null;
            second.next=null;
            iter.next=second;
            iter=iter.next;
            iter.next=first;
            iter=iter.next;
            first=tmp;
        }
        if(first!=null) iter.next=first;
        return pairs.next;
    }

    public static void main(String[] args) {

        ListNode node1=new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        swapPairs(node1);

    }
}
