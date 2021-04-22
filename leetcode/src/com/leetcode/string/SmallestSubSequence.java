package com.leetcode.string;


import java.util.ArrayDeque;
import java.util.Deque;

public class SmallestSubSequence {


    /**
     * 返回字符串 text中按字典序排列最小的子序列，
     * 该子序列包含text中所有不同字符一次。
     * 示例 1：
     * 输入："cdadabcc"
     * 输出："adbc"
     * 示例 2：
     * 输入："abcd"
     * 输出："abcd"
     * 示例 3：
     * 输入："ecbacba"
     * 输出："eacb"
     * 示例 4：
     * 输入："leetcode"
     * 输出："letcod"
     * 提示：
     * 1 <= text.length <= 1000
     * text由小写英文字母组成
     * 链接：https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters
     * @param text
     * @return
     *
     *
     * 那如果那些字典序靠前的字符出现得比较晚该怎么办呢？此时就要看，
     * 已经出现过的字符将来还有没有可能出现，如果将来有可能出现，
     * 就把前面的字符依次删去，经过这样的流程，得到的子序列就符合题意，
     * 这是 贪心算法 的思想，局部最优则全局最优。

     *
     */


    public String smallestSubsequence(String text) {

        int len=text.length();
        int[] map = new int[26];//记录每个字符出现的频率

        int s=0;//辅助栈,用于快速查找某个字符是否出现在栈中,可以存储31中状态,每个状态在二进制位上
        Deque<Character> stack = new ArrayDeque<>();//维护一个字典排序最小的子序列


        for(int i=0;i<len;i++) map[text.charAt(i)-'a']++;
        for(int i=0;i<len;i++){

            char ch = text.charAt(i);

            map[ch-'a']--;//

            if((s&1<<(ch-'a'))>0) continue;//已经存在说明不需要

            while (!stack.isEmpty()&&stack.peek()>ch&&map[stack.peek()-'a']>0){

                s ^= 1 << (stack.peek() - 'a');//删除栈顶元素
                stack.pop();

            }
            stack.push(ch);
            s |= 1 << (ch - 'a');//进栈
        }
        StringBuilder sb= new StringBuilder();


        while (!stack.isEmpty()){
            sb.append(stack.pollLast());
        }

        return sb.toString();
    }

    public static void main(String[] args) {

    }
}
