package com.leetcode.string;

public class ValidIPAddress {

    /**
     * IPv6,Neither,IPv4
     * @param IP
     * @return
     */
    public String validIPAddress(String IP) {
        if(IP==null||"".equals(IP)) {
            return "Neither";
        }
        if(IP.contains(".")){
            return ipV4(IP);
        }else if(IP.contains(":")){
            return ipV6(IP);
        }else{
            return "Neither";
        }
    }

    public String ipV4(String IP){
        // limit ==-1 分割出以.开头或者结尾的空字符串
        String[] ipSegments = IP.split("\\.",-1);
        if(ipSegments.length!=4){
            return "Neither";
        }
        for(String s:ipSegments){
            if(s.length()==0||s.length()>3||(s.charAt(0)=='0'&&s.length()>1)){
                return "Neither";
            }
            for(int i=0;i<s.length();i++){
                if(!Character.isDigit(s.charAt(i))){
                    return "Neither";
                }
            }
            int val = Integer.parseInt(s);
            if(val>255){
                return "Neither";
            }
        }
        return "IPv4";
    }

    public String ipV6(String IP){
        String[] ipSegments = IP.split("\\:",-1);
        if(ipSegments.length!=8){
            return "Neither";
        }
        for(String s:ipSegments){
            if(s.length()==0||s.length()>4){
                return "Neither";
            }
            for(int i=0;i<s.length();i++){
                char ch = s.charAt(i);
                if(!Character.isDigit(ch)&&(Character.toLowerCase(ch)>'f'||Character.toLowerCase(ch)<'a')){
                    return "Neither";
                }
            }
        }
        return "IPv6";
    }

    public static void main(String[] args) {
        System.out.println(Character.toLowerCase('0'));
    }
}
