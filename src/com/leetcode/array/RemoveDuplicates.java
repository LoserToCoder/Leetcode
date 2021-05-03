package com.leetcode.array;

public class RemoveDuplicates {


    public int removeDuplicatesOptimized(int []nums){

        int n = nums.length;
        if(n<=2){
            return n;
        }
        int slow=2,fast =2;
        while (fast<n){

            if(nums[slow-2]!=nums[fast]){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;

        }
        return slow;
    }


    public int removeDuplicates(int[] nums) {

        int pos =0;
        int head=0,tail=1;
        while (tail<nums.length){
            if(nums[head]!=nums[tail]){
                if(tail>=head+2){
                    nums[pos++] = nums[head];
                    nums[pos++] = nums[head + 1];
                }else {
                    nums[pos++] =nums[head];
                }
                head = tail;
                tail = head+1;
            }else{
                tail++;
            }
        }
        if(head==nums.length-1){
            nums[pos++] = nums[head];
        }else if(head<=nums.length-2){
            nums[pos++] = nums[head];
            nums[pos++] = nums[head + 1];
        }
        return pos;
    }

}
