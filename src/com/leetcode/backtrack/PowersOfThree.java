package com.leetcode.backtrack;

public class PowersOfThree {

    /**
     * 思想二进制,进制转换
     * @param n
     * @return
     */
    public boolean checkPowersOfThree(int n) {
        //最多可以余1，然后看能不能整除3
        while(n!=0){
            if(n%3==1||n%3==0){
                n/=3;
            }else{
                return false;
            }
        }
        return true;
    }


}
