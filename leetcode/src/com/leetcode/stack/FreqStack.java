package com.leetcode.stack;

import java.util.*;


/**
 * 实现 FreqStack，模拟类似栈的数据结构的操作的一个类。
 *
 * FreqStack有两个函数：
 *
 * push(int x)，将整数x推入栈中。
 * pop()，它移除并返回栈中出现最频繁的元素。
 * 如果最频繁的元素不只一个，则移除并返回最接近栈顶的元素。
 * 示例：
 * 输入：
 * ["FreqStack","push","push","push","push","push","push","pop","pop","pop","pop"],
 * [[],[5],[7],[5],[7],[4],[5],[],[],[],[]]
 * 输出：[null,null,null,null,null,null,null,5,7,5,4]
 * 解释：
 * 执行六次 .push 操作后，栈自底向上为 [5,7,5,7,4,5]。然后：
 * pop() -> 返回 5，因为 5 是出现频率最高的。
 * 栈变成 [5,7,5,7,4]。
 * pop() -> 返回 7，因为 5 和 7 都是频率最高的，但 7 最接近栈顶。
 * 栈变成 [5,7,5,4]。
 * pop() -> 返回 5 。
 * 栈变成 [5,7,4]。
 * pop() -> 返回 4 。
 * 栈变成 [5,7]。
 * 链接：https://leetcode-cn.com/problems/maximum-frequency-stack
 *
 算法思想:
 为每一个频率都维护一个栈,元素在新增的时候会出现低频率-->高频率的切换
 频率的出现是由低向高,且是连续的, 如果最大频率是5, 一定处在频率是 4,3,2,1的栈
 此时不需要把低频率的元素删除,因为当出栈时候,元素有高频率-->低频率的切换,且元素的相对顺序没有变化
 使用一个map维护一个频率->stack映射表
 使用一个map维护元素出现的频率
 使用一个变量代表最大频率,因为只要有最高频率,其他的频率都可以知道,因为频率是有元素新增的时候,
 逐渐变大的, 当出栈时候,只需要判断当前最大频率维护的栈是否为空,如果为空,最大频率-1即可

 */
public class FreqStack {




    private int maxFreq;

    private Map<Integer,Integer> freq;

    private Map<Integer, Deque<Integer>> map;
    public FreqStack() {
        map =new HashMap<>();
        freq = new HashMap<>();
        maxFreq=0;
    }

    public void push(int x) {

        int f=freq.getOrDefault(x,0)+1;
        freq.put(x, f);
        if(f>maxFreq){
            maxFreq=f;
        }
        //不存在时,新增之后开始计算
        map.computeIfAbsent(f, z -> new ArrayDeque<>()).push(x);
    }

    public int pop() {

        Integer k = map.get(maxFreq).pop();
        if(map.get(maxFreq).isEmpty()){
            maxFreq--;
        }
        freq.put(k,freq.get(k)-1);
        return k;
    }

    public static void main(String[] args) {

        FreqStack freqStack = new FreqStack();

        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(4);
        freqStack.push(5);

        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
    }
}
