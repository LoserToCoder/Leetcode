package com.leetcode.test;
import java.util.*;

public class Test {


    /**
     * Exception
     * RuntimeException:
     * IllegalArgumentException
     * NullPointerException
     * ClassCastException
     * ArithmeticException
     * IndexOutOfBoundsException
     */

    /*static 语句块，只能访问到定义在 static 语句块之前的变量*/

    public List<String> findRepeatedDnaSequences(String s) {
        int len = s.length();
        Map<String, Integer> map = new HashMap<>();

        for(int i=0;i+10<=len;i++){
            String sub = s.substring(i,i+10);
            map.put(sub, map.getOrDefault(sub, 0) + 1);
        }
        List<String> ret = new ArrayList<>();
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            if(entry.getValue()>1){
                ret.add(entry.getKey());
            }
        }
        return ret;
    }


    public int largestRectangleArea(int[] heights) {
        int ans = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < heights.length; i++) {

            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {

                int j = stack.pop();
                if (stack.isEmpty()) {
                    ans = Math.max(ans, i * heights[j]);
                } else {
                    ans = Math.max(ans, (i - stack.peek() - 1) * heights[j]);
                }
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {

            int j = stack.pop();
            if (stack.isEmpty()) {
                ans = Math.max(ans, heights[j] * heights.length);
            } else {
                ans = Math.max(ans, (heights.length - stack.peek() - 1) * heights[j]);
            }
        }
        return ans;
    }


    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int[] alphabets = new int[128];
        Arrays.fill(alphabets,-1);
        int len = s.length();
        int maxLen = 0;
        int prev =-1;
        for(int i=0;i<len;i++){
            char c = s.charAt(i);
            prev = Math.max(prev, alphabets[c]);
            alphabets[c]=i;
            maxLen = Math.max(maxLen, i - prev);
        }
        return maxLen;
    }

    public static String solve (String s, String t) {
        if(s.length()==0||t.length()==0){
            return s.length()==0 ? t:s;
        }
        // write code here
        int n = Math.max(s.length(),t.length());
        int [] nums = new int[n+1];
        int i = s.length()-1,j=t.length()-1;
        while(i>=0 || j>=0){

            int a = 0 ,b=0;
            if(i>=0) {
                a = s.charAt(i)-'0';
                i--;
            }

            if(j>=0){
                b = t.charAt(j)-'0';
                j--;
            }
            nums[n] +=(a+b)%10;
            nums[n-1]=(a+b)/10;
            n--;
        }
        StringBuilder sb = new StringBuilder();
        for(int k=0;k<nums.length;k++){
            if(k==0 && nums[k]==0){
                continue;
            }
            sb.append(nums[k]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        solve("1","99");
    }






}
