package com.leetcode.binary;

public class GuessNumber extends GuessGame{

    /**
     我们正在玩一个猜数字游戏。 游戏规则如下：
     我从 1 到 n 选择一个数字。 你需要猜我选择了哪个数字。
     每次你猜错了，我会告诉你这个数字是大了还是小了。
     你调用一个预先定义好的接口 guess(int num)，它会返回 3 个可能的结果（-1，1 或 0）：
     -1 : 我的数字比较小
     1 : 我的数字比较大
     0 : 恭喜！你猜对了！
     示例 :
     输入: n = 10, pick = 6
     输出: 6
     链接：https://leetcode-cn.com/problems/guess-number-higher-or-lower
     */
    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;//=>注意此行  (不要观念上二分查找就是(low+high)/2)
            //int mid=(low+high)/2;
            /**
             * 二分法中位数的写法问题:
             * int mid=(high+low)/2;  如果出现 high和low都是大于Integer最大值的一半
             * 就会出现整形溢出问题,严重可能导致死循环问题而且会耗尽CPU
             * int mid=low+(high-low)/2;能避免这样的问题
             */
            int res = guess(mid);
            if (res == 0)
                return mid;
            else if (res < 0)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }

    public GuessNumber(int guess){
        super(guess);
    }

    public static void main(String[] args) {
        GuessNumber guessNumber = new GuessNumber(170276671);
        guessNumber.guessNumber(212675339);
    }
}
