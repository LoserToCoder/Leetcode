package com.leetcode.linklist;

public class RemoveDuplicatesSortedList {

    /***
     * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，
     * 只保留原始链表中没有重复出现的数字。
     *
     * 返回同样按升序排列的结果链表。
     *
     * 示例 1：
     *
     *
     * 输入：head = [1,2,3,3,4,4,5]
     * 输出：[1,2,5]
     * 示例 2：
     *
     *
     * 输入：head = [1,1,1,2,3]
     * 输出：[2,3]
     *
     * 提示：
     * 链表中节点数目在范围 [0, 300] 内
     * -100 <= Node.val <= 100
     * 题目数据保证链表已经按升序排列
     *
     * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {


        ListNode newNode = new ListNode(0, head);

        ListNode cur = newNode;

        while (cur.next!=null&&cur.next.next!=null){

            if(cur.next.val == cur.next.next.val){

                int x = cur.next.val;
                while (cur.next!=null&&cur.next.val ==x){
                    cur.next = cur.next.next;
                }
            }else{
                cur = cur.next;
            }
        }

        return newNode.next;
    }
}
