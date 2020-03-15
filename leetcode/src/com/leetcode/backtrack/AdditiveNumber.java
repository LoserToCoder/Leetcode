package com.leetcode.backtrack;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class AdditiveNumber {


    /**
     * 累加数是一个字符串，组成它的数字可以形成累加序列。
     * 一个有效的累加序列必须至少包含 3 个数。除了最开始
     * 的两个数以外，字符串中的其他数都等于它之前两个数相加的和。
     * 给定一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是累加数。
     * 说明: 累加序列里的数不会以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。
     * 示例 1:
         * 输入: "112358"
         * 输出: true
         * 解释: 累加序列为: 1, 1, 2, 3, 5, 8 。1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
     * 示例 2:
         * 输入: "199100199"
         * 输出: true
         * 解释: 累加序列为: 1, 99, 100, 199。1 + 99 = 100, 99 + 100 = 199
     * 链接：https://leetcode-cn.com/problems/additive-number
     */
    public boolean isAdditiveNumber(String num) {
        return backtrack(num,0,new ArrayList<>());
    }
    public boolean backtrack(String s, int pos, List<Long> stack){
        for(int i=pos;i<s.length();i++){
             int c=stack.size();
             String num = s.substring(pos, i + 1);
             if((num.length()>1&&num.charAt(0)=='0')||(c<=1&&i>(c+1)*s.length()/(c+2)))break;
             Long val = Long.parseLong(num);
             if(c>=2){
                int diff=val.compareTo(stack.get(c-1)+stack.get(c-2));
                if(diff<0) continue;
                else if(diff>0) break;
                if(diff==0&&i==s.length()-1) return true;
             }
             stack.add(val);
             if(backtrack(s,i+1,stack)) return true;
             stack.remove(stack.size() - 1);
        }
        return false;
    }


    public static void main(String[] args) {
        AdditiveNumber additiveNumber = new AdditiveNumber();
        //1023  11235813213455890144
        //System.out.println("11111111101111111111".length());
        System.out.println(additiveNumber.isAdditiveNumber("112358"));

    }
}
