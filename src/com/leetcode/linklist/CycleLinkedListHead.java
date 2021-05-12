package com.leetcode.linklist;

public class CycleLinkedListHead {


    /**
     * 需要环形链表的入口
     * @param head
     * @return
     */

    public ListNode detectCycle(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;
        while (fast!=null){

           if(fast.next==null||fast.next.next==null){
               return null;
           }
           fast = fast.next.next;
           slow = slow.next;
            if (fast == slow) {
               ListNode pr = head;
               while (slow!=pr){
                  pr = pr.next;
                  slow = slow.next;
               }
               return pr;
            }
        }
        return null;
    }

}
