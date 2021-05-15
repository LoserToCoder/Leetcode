package com.leetcode.string;


import java.util.HashMap;
import java.util.Map;

public class IntToRoman {



    public String intToRoman(int num) {
        int[] nums = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] chars = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        StringBuilder sb = new StringBuilder();
        for (int i = nums.length - 1; i >= 0; ) {
            if (num == nums[i]) {
                sb.append(chars[i]);
                break;
            } else if (num > nums[i]) {
                sb.append(chars[i]);
                num -= nums[i];
            } else {
                i--;
            }
        }
        return sb.toString();
    }

    /**
     *
     */

    String[] thousands = {"", "M", "MM", "MMM"};
    String[] hundreds  = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    String[] tens      = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    String[] ones      = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    public String intToRomanSuper(int num) {
        StringBuffer roman = new StringBuffer();
        roman.append(thousands[num / 1000]);
        roman.append(hundreds[num % 1000 / 100]);
        roman.append(tens[num % 100 / 10]);
        roman.append(ones[num % 10]);
        return roman.toString();
    }

    Map<Character, Integer> map = new HashMap<Character,Integer>(){{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};
    public int romanToInt(String s) {

        int len = s.length();
        int ans = 0;
        for(int i=0;i<len;i++){

            int curVal = map.get(s.charAt(i));

            if (i < len - 1 && curVal < map.get(s.charAt(i + 1))) {
                ans -= curVal;
            }else{
                ans +=curVal;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        new IntToRoman().romanToInt("MCMXCIV");

    }


}
