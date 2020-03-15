package com.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Bracket {


    /**
     * 括号。设计一种算法，打印n对括号的所有合法的（例如，开闭一一对应）组合。
     * 说明：解集不能包含重复的子集。
     * 例如，给出 n = 3，生成结果为：
     * [
     *   "((()))",
     *   "(()())",
     *   "(())()",
     *   "()(())",
     *   "()()()"
     * ]
     * 链接：https://leetcode-cn.com/problems/bracket-lcci
     * @param n
     * @return
     * 算法: 从头开始构建有效括号,避免出现重复字符串
     * 每次递归调用都会有个指向字符串的某个字符,只需要选择左括号或右括号
     *  1. 左括号：只要左括号没使用完毕，就可以插入左括号
     *  2. 右括号:  主要不造成语法错误(右括号比左括号还多),就可以插入右括号
     */

    private List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtrace(n,n,0,new char[2*n]);
        return ans;
    }


    /**
     *
     * @param left   代表左边的括号
     * @param right  代表右边的括号
     * @param index  字符索引
     * @param brackets
     */

    public void backtrace(int left,int right,int index,char[] brackets){

        //(right<left) 意味着")"使用超过数目超过"(" 显然是个无效组合
        if(left<0||right<left) return;

        if(left==0&&right==0){
            ans.add(String.valueOf(brackets));
            return;
        }
        /*还有左括号可用，则加入一个左括号*/
        if(left>0){
            brackets[index] = '(';
            backtrace(left-1,right,index+1,brackets);
        }

        /*字符串是有效的,则加入右括号*/
        if(right>left){
            brackets[index] = ')';
            backtrace(left,right-1,index+1,brackets);
        }

    }

    /*public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if (n == 0)
            return list;
        backtrack("", 0, 0, n, list);

        return list;
    }

    // open:左括号的个数；close:右括号的个数;n:括号对数
    private void backtrack(String combination, int open, int close, int n, List<String> list) {
        if (combination.length() == 2 * n) {
            list.add(combination);
            return;
        }
        //如果左括号小于n，即还可以添加左括号
        if (open < n) {
            backtrack(combination + "(", open + 1, close, n, list);
        }
        //如果右括号小于左括号(必须如此，这样的括号才是有效的)
        if (close < open) {
            backtrack(combination + ")", open, close + 1, n, list);
        }
    }
    */

    public static void main(String[] args) {

        Bracket bracket = new Bracket();
        System.out.println(bracket.generateParenthesis(4));

    }
}
