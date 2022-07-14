package com.leetcode.linklist;

public class ListNode{
    public int val;
    public ListNode next;
    ListNode(int x){this.val=x;}

    ListNode(int x,ListNode next){
        this.val = x;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        ListNode p=this.next;
        sb.append("["+val);
        sb.append(",");
        while(p!=null){
            sb.append(p.val);
            p=p.next;
            if(p!=null){
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}