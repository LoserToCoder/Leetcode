package com.leetcode.linklist;

public class IntersectionOfTwoLinked {


    /**
     *  要保证步伐一致
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null){
            return null;
        }
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA!=nodeB){

            if(nodeA!=null){
                nodeA = nodeA.next;
            }else {
                nodeA = headB;
            }

            if(nodeB!=null){
                nodeB = nodeB.next;
            }else {
                nodeB = headA;
            }

        }
        return nodeA;
    }

    /**
     *  1. 判断两个链表相交  （两个链表尾节点是相同的）
     *  2.  length(A) length(B)  让长的链表先走|length(A)-length(B)| 然后再同步走
     */

    public static void main(String[] args) {
       // System.out.println(Math.p);
    }

}
