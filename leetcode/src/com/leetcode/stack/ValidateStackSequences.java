package com.leetcode.stack;

public class ValidateStackSequences {


    /**
     给定 pushed 和 popped 两个序列，每个序列中的 值都不重复，
     只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作
     序列的结果时，返回 true；否则，返回 false 。
     示例 1：
         输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
         输出：true
         解释：我们可以按以下顺序执行：
         push(1), push(2), push(3), push(4), pop() -> 4,
         push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
     示例 2：
         输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
         输出：false
         解释：1 不能在 2 之前弹出。
     链接：https://leetcode-cn.com/problems/validate-stack-sequences
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {

        int in=0,out=0,top=0;
        int[] stack = new int[pushed.length];
        while (in<pushed.length){
            //如果栈顶有元素且栈顶元素刚好等于popped[out],则弹出栈顶元素,
            if(top>0&&stack[top-1]==popped[out]){
                top--;
                out++;
                continue;
            }
            if(pushed[in]==popped[out]){
                out++;
                in++;
            }else {
                stack[top++] = pushed[in++];
            }
        }
        if(top==0) return true;
        while (out<popped.length){
            if(stack[top-1]!=popped[out]){
                return false;
            }
            top--;
            out++;
        }
        return true;
    }
    public static void main(String[] args) {

        //int[] pushed = {1, 2, 3, 4, 5}, poped = {4,3,5,1,2};
        //int[] pushed = {0,2,1}, poped = {0,1,2};
        int[] pushed = {2,1,0}, poped = {1,2,0};
        ValidateStackSequences stackSequences = new ValidateStackSequences();
        System.out.println(stackSequences.validateStackSequences(pushed,poped));


    }
}
