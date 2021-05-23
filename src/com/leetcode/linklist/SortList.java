package com.leetcode.linklist;

public class SortList {


    /**
     * 给你链表的头结点head，请将其按 升序 排列并返回 排序后的链表 。
     *
     * 进阶：你可以在O(nlogn) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
     *
     * 示例 1：
     *
     * 输入：head = [4,2,1,3]
     * 输出：[1,2,3,4]
     *
     * 示例 2：
     *
     * 输入：head = [-1,5,3,4,0]
     * 输出：[-1,0,3,4,5]
     *
     * 示例 3：
     *
     * 输入：head = []
     * 输出：[]
     *
     * 链接：https://leetcode-cn.com/problems/sort-list
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {

        if(head==null||head.next==null){
            return head;
        }
        ListNode midNode = findMidNode(head);
        ListNode right = sortList(midNode.next);
        midNode.next = null;
        ListNode left = sortList(head);
        return mergeSortList(left, right);
    }
    private ListNode findMidNode(ListNode head){

        ListNode slow = head,fast = head.next;
        while (fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode mergeSortList(ListNode listNode1,ListNode listNode2){

        ListNode head = new ListNode(-1);
        ListNode dump = head;
        while (listNode1 != null && listNode2 != null) {

            if(listNode1.val<= listNode2.val){
                dump.next= listNode1;
                listNode1 = listNode1.next;
            }else{
                dump.next =listNode2;
                listNode2 = listNode2.next;
            }
            dump = dump.next;
        }

        if(listNode1!=null){
            dump.next = listNode1;
        }else{
            dump.next = listNode2;
        }
        return head.next;
    }

}
