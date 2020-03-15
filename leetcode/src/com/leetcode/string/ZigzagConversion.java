package com.leetcode.string;

import java.util.HashSet;
import java.util.Set;

public class ZigzagConversion {


    /**
     * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
     * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
     * L   C   I   R
     * E T O E S I I G
     * E   D   H   N
     * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
     * 请你实现这个将字符串进行指定行数变换的函数：
     * string convert(string s, int numRows);
     * 示例 1:
     * 输入: s = "LEETCODEISHIRING", numRows = 3
     * 输出: "LCIRETOESIIGEDHN"
     * 示例 2:
     * 输入: s = "LEETCODEISHIRING", numRows = 4
     * 输出: "LDREOEIIECIHNTSG"
     * 解释:
     * L     D     R
     * E   O E   I I
     * E C   I H   N
     * T     S     G
     * 链接：https://leetcode-cn.com/problems/zigzag-conversion
     * @param s
     * @param numRows
     * @
     *
     * 算法:
     * 首先访问 行 0 中的所有字符，接着访问 行 1，然后 行 2，依此类推...
     *
     * 对于所有整数 k，
     * 行0中字符位于索引k (2*numRows-2)处
     * 行numRows-1中字符位于索引k(2*numRows-2)+numRows-1处
     *
     * 内部的行i中，字符位于索引可k(2*numRows-2)-i以及(k+1)(2*numRows-2)-i处
     */
    public String convert(String s, int numRows) {
        if(numRows==1) return s;
        StringBuilder sb = new StringBuilder();
        int n=s.length();

        int offset=2*numRows-2;
        for(int i=0;i<numRows;i++){


            for (int j = 0; j + i < n; j += offset) {

                sb.append(s.charAt(i + j));

                if(i!=0&&i!=numRows-1&&j+offset-i<n){
                    sb.append(s.charAt(j + offset - i));
                }

            }

        }
        return sb.toString();

    }

    public static void main(String[] args) {

        ZigzagConversion zig = new ZigzagConversion();

        System.out.println(zig.convert("LEETCODEISHIRING",4));

    }
}
