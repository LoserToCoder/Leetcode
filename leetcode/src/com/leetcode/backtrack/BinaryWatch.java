package com.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {

    /***
      二进制手表顶部有 4 个 LED 代表小时（0-11），底部的 6 个 LED 代表分钟（0-59）。
       每个 LED 代表一个 0 或 1，最低位在右侧。例如，上面的二进制手表读取 “3:25”。
      给定一个非负整数 n代表当前 LED 亮着的数量，返回所有可能的时间。
      案例:
      输入: n = 1
      返回: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
      链接：https://leetcode-cn.com/problems/binary-watch
      注意事项:
      输出的顺序没有要求。
      小时不会以零开头，比如 “01:00”是不允许的，应为 “1:00”。
      分钟必须由两位数组成，可能会以零开头，比如 “10:2”是无效的，应为 “10:02”。
      链接：https://leetcode-cn.com/problems/binary-watch
     */

    private final static String[][] hours={ {"0"},{"1","2","4","8"},{"3","5","6","9","10"},{"7","11"}};

    private final static String[][] minutes = {
            {"00"}, {"01", "02", "04", "08", "16", "32"},
            {"03", "05", "06", "09", "10", "12", "17", "18", "20", "24", "33", "34", "36", "40", "48"},
            {"07", "11", "13", "14", "19","21","22","25","26","28","35","37","38","41","42","44","49","50","52","56"},
            {"15", "23", "27", "29", "30", "39", "43", "45", "46", "51", "53", "54", "57", "58"}, {"31", "47", "55", "59"}
    };
    public List<String> readBinaryWatch(int num) {
        List<String> watch = new ArrayList<>();
        if(num>8){
            return watch;
        }
        if(num<5){
            backtrack(watch,0,num);
        }else{
            backtrack(watch,num-5,5);
        }
        return watch;
    }
    public void backtrack(List<String> watch,int h,int m){
        if(h>3||m<0) return;
        String []hs=hours[h];
        String []ms=minutes[m];
        for(int i=0;i<hs.length;i++){
            for(int j=0;j<ms.length;j++){
                watch.add(hs[i]+":"+ms[j]);
            }
        }
        backtrack(watch,h+1,m-1);

    }

    public static void main(String[] args) {

        BinaryWatch watch = new BinaryWatch();
        List<String> joint = watch.readBinaryWatch(8);
        StringBuilder sb=new StringBuilder();
        sb.append("[");
        int i;
        for (i = 0; i < joint.size()-1; i++) {
            sb.append(joint.get(i)+",");
        }
        sb.append(joint.get(i)+"]");
        System.out.println(sb.toString());

    }
}
