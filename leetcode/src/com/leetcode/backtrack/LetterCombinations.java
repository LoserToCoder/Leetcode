package com.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/***
 *给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 示例:
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 */
public class LetterCombinations {


    private final static String[] LETTERS = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits){

        List<String> letters=new ArrayList<>();
        if (digits == null || digits.length() < 1) {
            return letters;
        }
        backtrack(letters,0,digits,new StringBuilder());
        return letters;
    }

    public void backtrack(List<String> letters,int pos,String digits,StringBuilder sb) {

        if(pos==digits.length()){
            letters.add(sb.toString());
            return;
        }
        int k=digits.charAt(pos)-'2';
        String chs=LETTERS[k];
        for(int i=0;i<chs.length();i++){
            sb.append(chs.charAt(i));
            backtrack(letters,pos+1,digits,sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }


    /***
     *手机的九宫格输入法中，输入数字的键位是可以和字母键位对应的。
     * 如“2”对应“ABC”，“9”对应“WXYZ”，现假设“1”和“0”为空字符，
     * 以此规则试设计一个程序，将单词用一串数字来进行表示。
     * 举例：输入：cat（不区分大小写）
     * 输出：228
     */

    public String letterTransDigit(String word){

        int[]dict={2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,7,8,8,8,9,9,9,9};
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            int pos=0;
            if(ch<97){
                pos = ch - 'A';
            }else{
                pos = ch - 'a';
            }
            sb.append(dict[pos]);

        }
        return sb.toString();
    }

    public static void main(String[] args) {


        String digits="94367";
        LetterCombinations letterCombinations = new LetterCombinations();
        List<String> list = letterCombinations.letterCombinations(digits);
        for (String item:list) {
            String digit = letterCombinations.letterTransDigit(item);
            System.out.println(item+"==>"+digit);
        }
    }
}
