package com.leetcode.math;

import java.util.TreeSet;

public class StringMultiply {

    /**
     * 给定两个以字符串形式表示的非负整数num1和num2，返回num1和num2的乘积，它们的乘积也表示为字符串形式。
     *
     * 示例 1:
     *
     * 输入: num1 = "2", num2 = "3"
     * 输出: "6"
     * 示例2:
     *
     * 输入: num1 = "123", num2 = "456"
     * 输出: "56088"
     * 说明：
     *
     * num1和num2的长度小于110。
     * num1 和num2 只包含数字0-9。
     * num1 和num2均不以零开头，除非是数字 0 本身。
     * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
     *
     * 链接：https://leetcode-cn.com/problems/multiply-strings
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {
        if("0".equals(num1)||"0".equals(num2)){
            return "0";
        }
        int m = num1.length(),n=num2.length();
        int [] nums = new int[m+n];
        for(int i=m-1;i>=0;i--){
            int a = num1.charAt(i)-'0';

            for(int j=n-1;j>=0;j--){
                int b = num2.charAt(j)-'0';
                nums[i+j+1]+=a*b;
            }
        }
        for(int i=m+n-1;i>0;i--){
            nums[i-1] +=nums[i]/10;
            nums[i] = nums[i]%10;
        }
        StringBuilder sb = new StringBuilder();
        int index = nums[0]==0?1:0;
        while(index<m+n){
            sb.append(nums[index++]);
        }
        return sb.toString();
    }

    public static int mySqrt(int x) {

        if(x<1) return 0;
        int left = 1,right = x;
        while(right-left>1){

            int mid = left+(right-left)/2;
            if(mid*mid<x){
                left = mid;
            } else if(mid*mid>x){
                right = mid;
            } else {
                return (int)mid;
            }
        }
        return (int)left;
    }

    public static void main(String[] args) {
        TreeSet<Integer> tree  = new TreeSet<>();
        tree.add(10);
        tree.add(-1);
        tree.add(20);
        tree.add(25);
        tree.add(15);
        System.out.println(tree.pollFirst());
        System.out.println(tree.first());

        System.out.println(tree.pollFirst());
        System.out.println(tree.first());

        System.out.println(tree.pollFirst());
        System.out.println(tree.first());

        System.out.println(tree.pollFirst());
        System.out.println(tree.first());

        System.out.println(tree.pollFirst());
        System.out.println(tree.first());

    }
}
