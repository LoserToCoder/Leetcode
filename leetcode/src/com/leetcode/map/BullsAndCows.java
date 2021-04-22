package com.leetcode.map;

import java.util.*;

public class BullsAndCows {

    /**
     * 你正在和你的朋友玩猜数字（Bulls and Cows）游戏：你写下一个数字让你的朋友猜。每次他猜测后，
     * 你给他一个提示，告诉他有多少位数字和确切位置都猜对了（称为“Bulls”, 公牛），有多少位数字猜对了
     * 但是位置不对（称为“Cows”, 奶牛）。你的朋友将会根据提示继续猜，直到猜出秘密数字。
     * 请写出一个根据秘密数字和朋友的猜测数返回提示的函数，用 A 表示公牛，用B表示奶牛。
     * 请注意秘密数字和朋友的猜测数都可能含有重复数字。
     * 示例 1:
     * 输入: secret = "1807", guess = "7810"
     * 输出: "1A3B"
     * 解释: 1公牛和3奶牛。公牛是 8，奶牛是 0, 1和 7。
     * 示例 2:
     * 输入: secret = "1123", guess = "0111"
     * 输出: "1A1B"
     * 解释: 朋友猜测数中的第一个 1是公牛，第二个或第三个 1可被视为奶牛。
     * 说明: 你可以假设秘密数字和朋友的猜测数都只包含数字，并且它们的长度永远相等。
     * 链接：https://leetcode-cn.com/problems/bulls-and-cows
     * @param secret
     * @param guess
     * @return
     */

    /***
     * 简单的map可以使用int[]来替代
     * @param secret
     * @param guess
     * @return
     */
    public String getHint(String secret,String guess){
        int []map=new int[10];
        int bulls=0,cows=0;
        for(int i=0;i<secret.length();i++){
            char sc = secret.charAt(i);
            if(sc==guess.charAt(i)){
                bulls++;
            }else{
                map[sc-'0']++;
            }
        }
        for(int i=0;i<guess.length();i++){
            char gc = guess.charAt(i);
            if(gc!=secret.charAt(i)&&map[gc-'0']>0){
                cows++;
                map[gc-'0']--;
            }
        }
        return bulls + "A" + cows + "B";
    }
    public static void main(String[] args) {

        BullsAndCows bullsAndCows = new BullsAndCows();
        String hint = bullsAndCows.getHint("1123", "0111");
        System.out.println(hint);

    }
}
