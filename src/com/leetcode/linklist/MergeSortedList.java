package com.leetcode.linklist;


import java.util.PriorityQueue;
import java.util.Queue;

class ListNode{
    int val;
    ListNode next;
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
public class MergeSortedList {
    /**
    将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
	示例
	    输入：1->2->4, 1->3->4
		输出：1->1->2->3->4->4
		链接：https://leetcode-cn.com/problems/merge-two-sorted-lists*/
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode head=new ListNode(-1);
        ListNode target=head;

        while(l1!=null&&l2!=null){
            if(l1.val<=l2.val){
            	head.next=l1;
            	l1=l1.next;
            }else{
            	head.next=l2;
            	l2=l2.next;
            }

            head=head.next;
        }
        head.next=(l1==null)?l2:l1;

        return target.next;
    }
    public static void main(String[] args) {

        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(4);
        node1.next=node2;
        node2.next=node3;

        ListNode node=new ListNode(1);
        ListNode node4=new ListNode(3);
        ListNode node5=new ListNode(4);
        node.next=node4;
        node4.next=node5;
        System.out.println(new MergeSortedList().mergeTwoLists(node1,node));

        Queue<ListNode> pq = new PriorityQueue<>((p, q) -> p.val - q.val);
        pq.offer(node);
        pq.offer(node5);
        pq.offer(node2);
        pq.offer(node4);
        while (!pq.isEmpty()){

            ListNode poll = pq.poll();
            System.out.println(poll.val);
        }
    }



}
