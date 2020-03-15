package com.leetcode.string;

public class CheckRecord {


    public boolean checkRecord(String s){

        int ac=0;
        boolean match=false;
        for(int i=0,len=s.length();i<len;i++){
            if(ac>1||match) return false;
            char sc = s.charAt(i);
            if(sc=='A') ac++;
            else if(sc=='L'){
                if(len-i>=3&&s.substring(i,i+3).equals("LLL")){
                    match=true;
                }
            }
        }
        return ac<=1&&!match;

    }

    public static void main(String[] args) {

        CheckRecord record = new CheckRecord();
        boolean b = record.checkRecord("PPALLL");
        System.out.println(b);

    }

}
