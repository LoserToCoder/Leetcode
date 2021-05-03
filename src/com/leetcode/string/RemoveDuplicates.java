package com.leetcode.string;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveDuplicates {



    /*
        给出由小写字母组成的字符串S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。

        在 S 上反复执行重复项删除操作，直到无法继续删除。

        在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。

        示例：

        输入："abbaca"
        输出："ca"
        解释：
        例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。
        之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。

        链接：https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string
     */

    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder(s);
        int i=0,j=1;
        while (j<sb.length()){

            if(sb.charAt(i)==sb.charAt(j)){
                sb.delete(i, i + 2);
                if(i>0){
                    i--;
                }
                if(j>1){
                    j--;
                }
            }else{
                i++;
                j++;
            }

        }
        return sb.toString();
    }


    /*public String removeDuplicatesOptimized(String s){

        if(s==null||s.length()<=1){
            return s;
        }
        Deque<Character> stack = new ArrayDeque<Character>();
        int i = 0;
        while (i<s.length()){

            if(stack.isEmpty()){
                stack.push(s.charAt(i));
            }else{
                char next = s.charAt(i);
                if (stack.peek() == next) {
                    stack.pop();
                }else{
                    stack.push(next);
                }
            }
            i++;
        }
        int len = stack.size();
        char[] results = new char[len];
        while (!stack.isEmpty()){
            results[len-1]=stack.pop();
            len--;
        }
        return new String(results);
    }
*/
    /**
     * 逆向结果问题
     */
    public String removeDuplicatesOptimized(String s){

        if(s==null||s.length()<=1){
            return s;
        }
        char[] chs = s.toCharArray();
        int prev = 0;
        for(int i=1;i<chs.length;i++){

            /**
             * 处理边界越界
             */
            if(prev==-1){
                chs[++prev] = chs[i];
                continue;
            }
            if(chs[prev]!=chs[i]){
                chs[++prev] = chs[i];
            }else if(chs[prev]==chs[i]){
                prev--;
            }

        }
        return new String(chs, 0, prev+1);
    }
}
