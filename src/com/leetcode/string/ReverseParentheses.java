package com.leetcode.string;

import java.util.*;

public class ReverseParentheses {


    /**
     *
     给出一个字符串 s（仅含有小写英文字母和括号）。

     请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。

     注意，您的结果中 不应 包含任何括号。



     示例 1：

     输入：s = "(abcd)"
     输出："dcba"
     示例 2：

     输入：s = "(u(love)i)"
     输出："iloveu"
     示例 3：

     输入：s = "(ed(et(oc))el)"
     输出："leetcode"
     示例 4：

     输入：s = "a(bcdefghijkl(mno)p)q"
     输出："apmnolkjihgfedcbq"


     提示：

     0 <= s.length <= 2000
     s 中只有小写英文字母和括号
     我们确保所有括号都是成对出现的
     * @param s
     * @return
     */
    public String reverseParentheses(String s) {
        int n = s.length();
        Map<Integer, Integer> pairMap = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>(n);
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                int j = stack.pop();
                pairMap.put(i, j);
                pairMap.put(j, i);
            }
        }

        StringBuilder sb = new StringBuilder();
        int index = 0, step = 1;
        while (index < n) {
            if (s.charAt(index) == '(' || s.charAt(index) == ')') {
                index =pairMap.get(index);
                step = -step;
            } else {
                sb.append(s.charAt(index));
            }
            index += step;
        }
        return sb.toString();
    }


    public static void main(String[] args) {

        String s = "a(bcdefghijkl(mno)p)q";
        new ReverseParentheses().reverseParentheses(s);
    }
}
