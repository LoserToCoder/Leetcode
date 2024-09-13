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

    /**
     *
     * 非环形路长度 为 a, 快慢指针相遇时 慢指针在环形路走了 b,  一圈剩下的部分 c
     *
     * 慢指针走了 a+b 长度
     * 快指针和慢指针相遇时,走了n圈了
     *  a+n(b+c)+b
     *
     *  慢指针走一步,快指针走两步
     *  a+n(b+c)+b = 2*(a+b)
     *  => n(b+c) = a+b
     *  => a = (n-c)(b+c)+c
     *  从相遇点到入环点的距离加上 n−1 圈的环长,恰好等于从链表头部到入环点的距离。
     *
     *
     *
     * @param head
     * @return
     */


    public ListNode findCycleLinkedHead(ListNode head) {

        ListNode fast = head, slow  = head;

        while (fast != null && fast.next == null) {

            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                break;
            }
        }

        // 如果不存在环形的话 fast 最后肯定是指向null的
        if(fast==null || fast.next==null) {
            return null;
        }

        // 从头指针开始遍历 和 (快慢指针相遇后慢指针继续走)
        ListNode ptr = head;
        while (ptr != slow) {
            ptr = ptr.next;
            slow = slow.next;
        }
        return ptr;
    }



}
