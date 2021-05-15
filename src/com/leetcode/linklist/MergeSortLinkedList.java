package com.leetcode.linklist;

import java.util.PriorityQueue;

public class MergeSortLinkedList {

    /**
     *
     * 1. 小根堆
     * 2. 分治思想
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> pq = new PriorityQueue<>((p,q)->p.val-q.val);
        for(ListNode listNode:lists){
            if (listNode != null) {
                pq.offer(listNode);
            }

        }
        ListNode head = new ListNode(0);
        ListNode listNode = head;
        ListNode node = null;
        while (!pq.isEmpty()){

            node = pq.poll();
            listNode.next = node;
            if(node.next!=null){
                pq.offer(node.next);
            }
        }
        return head.next;
    }

}
