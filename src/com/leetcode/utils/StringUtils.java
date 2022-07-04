package com.leetcode.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StringUtils {

    public static String arrayToString(int[] nums) {

        if(nums==null||nums.length==0) return "";
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(nums[0]);
        for(int i=1;i<nums.length;i++){
            sb.append(",")
              .append(nums[i]);
        }
        sb.append("]");

        return sb.toString();
    }

    public static ArrayList<Integer> invertedIndex (ArrayList<Integer> ID, ArrayList<String> content, String word) {
        // write code here
        Map<String,ArrayList<Integer>> invertMap = new HashMap<>();
        for(int i=0;i<content.size();i++){
            String doc = content.get(i);
            String [] keyWords = doc.split(" ");
            for(String keyWord: keyWords) {

                ArrayList<Integer> docIds = null;
                if(!invertMap.containsKey(keyWord)){
                    docIds = new ArrayList<>();
                    invertMap.put(keyWord,docIds);
                }else {
                    docIds = invertMap.get(keyWord);
                }
                if(!docIds.contains(ID.get(i))){
                    docIds.add(ID.get(i));
                }
            }

        }
        return invertMap.get(word);
    }

    public static void main(String[] args) {

        invertedIndex(new ArrayList<>(Arrays.asList(1,2,4,9)),new ArrayList<>(Arrays.asList("My lover", "Yours", "you are young", "My old age")),"My");
    }


}
