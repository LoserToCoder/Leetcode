package com.leetcode.test;


import sun.misc.Launcher;

import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLClassLoader;
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

    private static final Integer NCPU = Runtime.getRuntime().availableProcessors();



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

    public static void main(String[] args) {

        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();

        System.out.println("启动类加载器");
        for(URL url:urLs){
            System.out.println("=======> "+url.toExternalForm());
        }

        printClassLoader("扩展类加载器",Test.class.getClassLoader().getParent());

        printClassLoader("应用类加载器",Test.class.getClassLoader());

    }

    private static void printClassLoader(String name,ClassLoader classLoader){

        if(classLoader!=null){
            System.out.println(name+" classloader ==>"+classLoader.toString());
            printURLForClassloader(classLoader);
        }

    }

    private static void printURLForClassloader(ClassLoader classLoader) {

        Object ucp = insightField(classLoader, "ucp");
        Object path = insightField(ucp, "path");
        List paths =(List) path;
        for(Object p:paths){
            System.out.println(" ====> "+p.toString());
        }

    }

    private static Object insightField(Object object,String name){
        Field f = null;
        try {

            if(object instanceof URLClassLoader){
                f = URLClassLoader.class.getDeclaredField(name);
            }else {
                f = object.getClass().getDeclaredField(name);
            }
            f.setAccessible(true);
            return f.get(object);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }





}
