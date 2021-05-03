package com.leetcode.string;

public class AddBinary {

    public String addBinary(String a, String b) {

        if(a.length()<b.length()){
            return compute(a, b);
        }
        return compute(b, a);
    }

    public String compute(String s1,String s2){
        int n=s1.length()-1,m=s2.length()-1;
        char[] res = new char[m + 2];
        char bit = '0';
        int p=res.length-1;
        while (n>=0){

            char c1 = s1.charAt(n--);
            char c2 = s2.charAt(m--);
            if(c1!=c2){
                res[p--] = (bit == '0') ? '1' : '0';
            }else {
                res[p--] = (bit == '0') ? '0' : '1';
                bit = (c1 == '1') ? '1' : '0';
            }
        }

        while (m>=0){

            char c = s2.charAt(m--);
            if(c!=bit){
                res[p--] = '1';
                bit = '0';
            }else {
                res[p--] ='0';
            }
        }

        int offset=1;
        if(bit=='1') {
            res[p] = '1';
            offset=0;
        }
        return String.copyValueOf(res, offset, res.length-offset);
    }


    public static void main(String[] args) {

        AddBinary binary = new AddBinary();
        System.out.println(binary.addBinary("100","110010"));

    }

}
