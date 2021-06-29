package com.leetcode.math;

public class Gcd {

    /**
     *
     * @param a
     * @param b
     * @return
     */
    public int gcd (int a, int b) {
        int ans = 0;
        while(b!=0){
            ans = a%b;
            a = b;
            b = ans;
        }
        return a;
    }
}
