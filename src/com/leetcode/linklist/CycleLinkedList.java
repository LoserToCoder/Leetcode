package com.leetcode.linklist;

/**
 * 快慢指针
 */
public class CycleLinkedList {



      class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
      }

    public boolean hasCycleDiy(ListNode head) {

          ListNode first = head;
          ListNode second = head;
          while (second!=null){

              first =first.next;

              if(second.next!=null){
                  second = second.next.next;
              }else{
                  break;
              }
              if(second!=null&&second==first){
                  return true;
              }

          }
          return false;
    }
    public boolean hasCycle(ListNode head){
          if(head==null||head.next==null){
              return false;
          }
          ListNode slow = head;
          ListNode fast = head.next;
          while (slow!=fast){

              if(slow==null||fast.next==null){
                  return false;
              }
              slow = slow.next;
              fast = fast.next.next;
          }
          return true;
    }


}
