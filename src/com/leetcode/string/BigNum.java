package com.leetcode.string;

public class BigNum {

    public String solve (String s, String t) {

        StringBuilder sb = new StringBuilder();

        int i=s.length()-1,j=t.length()-1;
        int bit =0;
        int m=0,n=0,sum=0;
        while (i>=0||j>=0){

            sum=0;
            if(i>=0){
                m = s.charAt(i) - '0';
                sum+=m;
                i--;
            }
            if(i>=0){
                n = t.charAt(j) - '0';
                sum+=n;
                j--;
            }
            sum +=bit;
            sb.append(sum % 10);
            bit = sum/10;

        }
        return sb.reverse().toString();
    }

}
