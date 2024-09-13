package com.leetcode.array;

public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        int l=0, h =nums.length-1;
        while (l<h){
            int mid =((h-l)>>1)+l;

            if(nums[mid]<=nums[h]){
                l = mid+1;
            }else{
                h = h-1;
            }
        }
        return l;
    }

    public static int [] getMaxNumAndCounts(int[]array){

        int L = 0,R = array.length-1;
        while(L<R){

            int mid = L+((R-L)>>1);

            if(array[mid]<=array[R]){
                L = mid+1;
            }else{
                R = R-1;
            }
        }
        int []ans ={0,0};
        ans[0] =array[L];


        int i=L;
        while(i<array.length){
            if(array[i]==ans[0]){
                ans[1]++;
            }else{
                break;
            }
            i++;
        }
        i=L-1;
        while(i>=0){
            if(array[i]==ans[0]){
                ans[1]++;
            }else{
                break;
            }
            i--;
        }
        return ans;

    }

    public static void main(String[] args) {
        int [] ans = getMaxNumAndCounts(new int[]{1, 1, 3, 3, 5, 6, 7, 7, 7, 8, 10, 15, 20, 22, 23, 23, 45, 56, 80,80,80, 45, 45, 43, 42, 32, 32, 14, 11, 6, 3, 3});
        System.out.println(ans);
    }
}
