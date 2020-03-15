package com.leetcode.stack;
public class ReversePolishNotation {

    /**
     根据逆波兰表示法，求表达式的值。
     有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
     说明：
     整数除法只保留整数部分。
     给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
     示例 1：
     输入: ["2", "1", "+", "3", "*"]
     输出: 9
     解释: ((2 + 1) * 3) = 9
     示例 2：
     输入: ["4", "13", "5", "/", "+"]
     输出: 6
     解释: (4 + (13 / 5)) = 6
     示例 3：
     输入: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
     输出: 22
     解释:
     ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
     = ((10 * (6 / (12 * -11))) + 17) + 5
     = ((10 * (6 / -132)) + 17) + 5
     = ((10 * 0) + 17) + 5
     = (0 + 17) + 5
     = 17 + 5
     = 22

     链接：https://leetcode-cn.com/problems/evaluate-reverse-polish-notation
     对于数据结构底层而言:尽量使用最简单的数组去构造常用的数据结构
     在某些简单操作时,使用最简单的数组去构造常用的数据结构能节省很多的时间开销
     */

    public static int evalRPN(String[] tokens) {
        int[] stack = new int[tokens.length];
        int top=-1;
        for (String token : tokens) {

            switch (token) {
                case "+":
                    stack[top-1]=stack[top]+stack[top-1];
                    top--;
                    break;
                case "-":
                    stack[top - 1] = stack[top - 1] - stack[top];
                    top--;break;
                case "*":
                    stack[top - 1] = stack[top - 1] * stack[top];
                    top--;
                    break;
                case "/":
                    stack[top - 1] = stack[top - 1] / stack[top];
                    top--;
                    break;
                default:
                    stack[++top] = Integer.parseInt(token);

            }
        }
        return stack[top];
    }

    public static void main(String[] args) {

        System.out.println(evalRPN(new String[]{"4", "13", "5", "/", "+"}));


    }

}
