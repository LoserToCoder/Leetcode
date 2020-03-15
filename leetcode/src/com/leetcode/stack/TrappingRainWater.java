package com.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class TrappingRainWater {

    /**
     *
     * @param height
     * @return
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，
     * 下雨之后能接多少雨水。
     * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，
     * 可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
     * 示例:
     * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
     * 输出: 6
     * 链接：https://leetcode-cn.com/problems/trapping-rain-water
     *
     * 解决方案: 抓住问题的关键才是解决方式变换的本质
     *:对于数组中的每个元素，我们找出下雨后水能达到的最高位置，等于两边最大高度的较小值减去当前高度的值。
     *
     */
    /**栈的方式解决
     * 我们在遍历数组时维护一个栈。如果当前的条形块小于或等于栈顶的条形块，
     * 我们将条形块的索引入栈，意思是当前的条形块被栈中的前一个条形块界定。
     * 如果我们发现一个条形块长于栈顶，我们可以确定栈顶的条形块被当前条形块
     * 和栈的前一个条形块界定，因此我们可以弹出栈顶元素并且累加答案到res

     * 使用栈来存储条形块的索引下标。
     * 遍历数组：
     * 当栈非空且 height[current]>height[s.peek()]
     * 意味着栈中元素可以被弹出。弹出栈顶元素 [top]。
     * 计算当前元素和栈顶元素的距离，准备进行填充操作
     * dis=current−s.peek()−1
     * 找出界定高度
     * width = min(height[current], height[st.top()]) - height[top]
     * 往答案中累加积水量res=width*dis
     * 将当前索引下标入栈
     * 将current 移动到下个位置
     */
    public int trap(int[] height) {

        int res=0,currentIndex=0;
        Deque<Integer> s = new ArrayDeque<>();
        while (currentIndex < height.length) {


            while (!s.isEmpty() && height[currentIndex] > height[s.peek()]) {
                int top=s.pop();
                if (s.isEmpty()) {
                    break;
                }
                int dis=currentIndex-s.peek()-1;
                int width = Math.min(height[currentIndex], height[s.peek()]) - height[top];
                res+=dis*width;
            }
            s.push(currentIndex++);
        }
        return res;
    }

    public int trapDoublePoint(int []height){

        int left=0,right=height.length-1;
        int res=0;
        int leftMax=0,rightMax=0;
        while (left < right) {

            if(height[left]<height[right]){

                if(height[left]>=leftMax){
                    leftMax = height[left];
                }else{
                    res += (leftMax - height[left]);
                }
                left++;

            }else{

                if (height[right] >= rightMax) {
                    rightMax = height[right];
                }else{
                    res += (rightMax - height[right]);
                }
                right--;

            }


        }
        return res;

    }

    public static void main(String[] args) {


        TrappingRainWater rainWater = new TrappingRainWater();

        int[] heights = {0,1,0,2,1,0,1,3,2,1,2,1};

        System.out.println(rainWater.trap(heights));

    }
}
