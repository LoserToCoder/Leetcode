package com.leetcode.linklist;

public class MergeInBetweenLinkedList {

    /**
     * 给你两个链表list1 和list2，它们包含的元素分别为n 个和m 个。
     *
     * 请你将list1中第a个节点到第b个节点删除，并将list2接在被删除节点的位置。
     *
     * 下图中蓝色边和节点展示了操作后的结果：

     * 请你返回结果链表的头指针。
     *
     * 示例 1：
     *
     * 输入：list1 = [0,1,2,3,4,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
     * 输出：[0,1,2,1000000,1000001,1000002,5]
     * 解释：我们删除 list1 中第三和第四个节点，并将 list2 接在该位置。上图中蓝色的边和节点为答案链表。
     * 示例 2：
     *
     *
     * 输入：list1 = [0,1,2,3,4,5,6], a = 2, b = 5, list2 = [1000000,1000001,1000002,1000003,1000004]
     * 输出：[0,1,1000000,1000001,1000002,1000003,1000004,6]
     * 解释：上图中蓝色的边和节点为答案链表。
     *
     * 链接：https://leetcode-cn.com/problems/merge-in-between-linked-lists
     * @param list1
     * @param m
     * @param n
     * @param list2
     * @return
     */
    public ListNode mergeInBetween(ListNode list1, int m, int n, ListNode list2) {

        int k=0;
        ListNode head = list1;
        ListNode joinHead = null;
        ListNode joinTail = null;
        while (head!=null){


            if(k<m){
                joinHead = head;
                head = head.next;
            }else if(k<=n+1){
                joinTail = head;
                head = head.next;
            }else {
                break;
            }
            k++;

        }

        joinHead.next = list2;
        while (list2.next!=null){
            list2 = list2.next;
        }
        list2.next = joinTail;
        return list1;
    }
}
