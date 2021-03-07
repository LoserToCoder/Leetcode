package com.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {

    /***
     * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
     * 示例
     * 输入: "25525511135"
     * 输出: ["255.255.11.135", "255.255.111.35"]
     * 链接：https://leetcode-cn.com/problems/restore-ip-addresses
     解题思路:
     DFS 深搜
     需要注意的点是 IP 的规则，以 0 开头的数字和超过 255 的数字都为非法的。
     * @param s
     * @return
     */

    private List<String> ips = new ArrayList<>();

    private List<String> segments = new ArrayList<>();

    private StringBuilder sb = new StringBuilder();

    public List<String> restoreIpAddresses(String s){
        backtrack(s,0);
        return ips;
    }
    private void backtrack(String s,int pos) {
          int c=segments.size();
          int remaining=s.length()-pos;
          if((4-c)*3<remaining){
            return;
          }
          if(c==4&&remaining==0){
              sb.append(segments.get(0));
              for (int i=1;i<c;i++){
                  sb.append('.')
                    .append(segments.get(i));
              }
              ips.add(sb.toString());
              sb.delete(0, sb.length());
              return;
          }
          for(int i=pos;i<pos+3&&i<s.length();i++){
              String segment = s.substring(pos, i + 1);
              Integer ipVal = Integer.parseInt(segment);
              String value = String.valueOf(ipVal);
              if(ipVal>255||!value.equals(segment)) break;
              segments.add(segment);
              backtrack(s,i+1);
              segments.remove(segments.size() - 1);
          }
    }

    public static void main(String[] args) {

        RestoreIPAddresses restoreIPAddresses = new RestoreIPAddresses();
        String []ips={"19216811","25525511135","1111318633","1123411331","111135746","18248107165","106131216","4795162193","1111329129"};
        long t1 = System.currentTimeMillis();
        for(String ip:ips){

          List<String> ipAddresses = restoreIPAddresses.restoreIpAddresses(ip);
          for (String s : ipAddresses) {
            System.out.println(s);
          }
        }
        long t2 = System.currentTimeMillis();
        System.out.printf("%d个测试案例/总耗时%dms",ips.length,t2-t1);

    }
}
