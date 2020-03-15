package com.leetcode.stack;
import java.util.ArrayDeque;
import java.util.Deque;

public class SimplifyPath {


    /**
     * 以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，
     * 将其转换为规范路径。在 Unix 风格的文件系统中，一个点（.）表示
     * 当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；
     * 两者都可以是复杂相对路径的组成部分。更多信息请参阅：Linux / Unix中的绝对路径 vs 相对路径
     * 请注意，返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。
     * 最后一个目录名（如果存在）不能以 / 结尾。此外，规范路径必须是表示绝对路径的最短字符串。
     * 示例 1：
     * 输入："/home/"
     * 输出："/home"
     * 解释：注意，最后一个目录名后面没有斜杠。
     * 示例 2：
     * 输入："/../"
     * 输出："/"
     * 解释：从根目录向上一级是不可行的，因为根是你可以到达的最高级。
     * 示例 3：
     * 输入："/home//foo/"
     * 输出："/home/foo"
     * 解释：在规范路径中，多个连续斜杠需要用一个斜杠替换。
     * 示例 4：
     * 输入："/a/./b/../../c/"
     * 输出："/c"
     * 示例 5：
     * 输入："/a/../../b/../c//.//"
     * 输出："/c"
     * 示例 6：
     * 输入："/a//b////c/d//././/.."
     * 输出："/a/b/c"
     * 链接：https://leetcode-cn.com/problems/simplify-path
     * @param path
     * @return
     * 算法思路: 拆分处理
     *  以'/'为分隔符
     */



    public String simplifyPath(String path){

        String []s=path.split("/");
        Deque<String> stack = new ArrayDeque<>();
        for(int i=0;i<s.length;i++){
            if(!stack.isEmpty()&&"..".equals(s[i])){
                stack.pop();
            } else if (!"".equals(s[i]) && !".".equals(s[i]) && !"..".equals(s[i])) {
                stack.push(s[i]);
            }
        }
        if(stack.isEmpty()) return "/";
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append('/').append(stack.pollLast());
        }
        return sb.toString();
    }


    private void handle(Deque<String> s,String p){
        if(!s.isEmpty()&&"..".equals(p)){
            s.pop();
        }else if(!"".equals(p)&&!".".equals(p)&&!"..".equals(p)){
            s.push(p);
        }
    }

    public String optimizeSimplifyPath(String path){

        Deque<String> s = new ArrayDeque<>();
        int slash=0;
        for(int i=1;i<path.length();i++){
            if(path.charAt(i)=='/'){
                String p=path.substring(slash+1,i);
                handle(s,p);
                slash=i;
            }
        }
        handle(s,path.substring(slash+1));
        if(s.isEmpty()) return "/";
        StringBuilder sb = new StringBuilder();
        while (!s.isEmpty()){
            sb.append('/').append(s.pollLast());
        }
        return sb.toString();
    }


    public static void main(String[] args) {


        SimplifyPath path = new SimplifyPath();
        System.out.println(path.optimizeSimplifyPath("/a//b////c/d//././/.."));

    }
}
