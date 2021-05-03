package com.leetcode.map;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {


    public boolean isHappy(int n){
        Set<Integer> map = new HashSet<>();
        int res=0;
        int bit=0;
        while(res!=1){
            if(!map.contains(n)) map.add(n);
            else return false;
            res=0;
            while (n!=0){
               bit=n%10;
               n=n/10;
               res+=bit*bit;
            }
            n=res;
        }
        return res==1;
    }

    public static void main(String[] args) {
        System.out.println(new HappyNumber().isHappy(2));
    }
}
