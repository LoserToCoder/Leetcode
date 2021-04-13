package com.leetcode.linklist;

public class IntersectionOfTwoLinked {


    /**
     *
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

}
