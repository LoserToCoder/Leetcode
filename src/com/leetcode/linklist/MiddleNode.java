package com.leetcode.linklist;

public class MiddleNode {

    /**
     * 链表的中间结点
     * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
     * 如果有两个中间结点，则返回第二个中间结点。
     * 示例 1：
     * <p>
     * 输入：[1,2,3,4,5]
     * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
     * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
     * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
     * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
     * 示例 2：
     * <p>
     * 输入：[1,2,3,4,5,6]
     * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
     * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
     * <p>
     * <p>
     * 提示：
     * 给定链表的结点数介于 1 和 100 之间。
     * 链接:https://leetcode.cn/problems/middle-of-the-linked-list/
     */

    //中间节点取最左边的解法, 取中间节点的细节注意
    public ListNode deleteMiddleNode(ListNode head) {

        if(head==null || head.next==null) return null;

        ListNode prev = null;
        ListNode mid = head, cur = head;
        int curIndex = 1,midIndex =1;
        while(cur!=null) {

            if(midIndex<  (curIndex+1)/2) {
                prev = mid;
                mid = mid.next;
                midIndex++;
            }
            cur = cur.next;
            curIndex++;
        }

        if(prev!=null) {
            prev.next = prev.next.next;
        } else {
            head =  head.next;
        }
        return  head;
    }


    // 中间节点去最右边的时候解法
    public ListNode middleNode(ListNode head) {

        //记录中间节点指向
        ListNode prev = head;
        //记录中间节点索引
        int prevIndex = 1;
        //记录当前节点的索引位置
        int curIndex = 1;
        while (head != null) {
            if (prevIndex <= curIndex / 2) {
                prev = prev.next;
                prevIndex++;
            }
            head = head.next;
            curIndex++;
        }
        return prev;
    }

    /**
     * 快慢指针
     */
    public ListNode middleNodeWithFastSlow(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
