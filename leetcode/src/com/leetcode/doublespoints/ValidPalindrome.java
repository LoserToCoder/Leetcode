package com.leetcode.doublespoints;

public class ValidPalindrome {


    /**
     * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，
     * 可以忽略字母的大小写。
     * 说明：本题中，我们将空字符串定义为有效的回文串。
     * 示例 1:
     * 输入: "A man, a plan, a canal: Panama"
     * 输出: true
     * 示例 2:
     * 输入: "race a car"
     * 输出: false
     * 链接：https://leetcode-cn.com/problems/valid-palindrome
     * @param s
     * @return
     */

    public boolean isPalindrome(String s) {

        int front=0,tail=s.length()-1;

        while (front<tail){

            char fc = s.charAt(front);
            char tc = s.charAt(tail);

            if(!Character.isLetter(fc)&&!Character.isDigit(fc)){
                front++;
                continue;
            }
            if (!Character.isLetter(tc)&&!Character.isDigit(tc)) {
                tail--;
                continue;
            }

            if(Character.toLowerCase(fc)!=Character.toLowerCase(tc)){
                return false;
            }
            front++;
            tail--;
        }
        return true;
    }

    public static void main(String[] args) {

        ValidPalindrome palindrome = new ValidPalindrome();

        System.out.println(palindrome.isPalindrome("race a car"));

    }


}
