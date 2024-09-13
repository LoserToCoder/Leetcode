package com.leetcode.array;

import java.util.Arrays;

public class FindMaxNumAndAggCount {


    public int[] maxNumAndAggCount(int[] array) {

        int[] result = new int[2];


        int low = 0, high = array.length-1;
        while (low < high ) {

            int mid = (high-low)/2 +low;
            if (array[mid] <= array[high]) {
                low = mid + 1;
            } else {
                high = high-1;
            }
        }
        result[0] = array[high];
        int l = high-1,r =high;
        while (l >= 0 && array[l] == array[high]) {
            result[1]++;
            l--;
        }
        while (r < array.length && array[r] == array[high]) {
            result[1]++;
            r++;
        }
        return result;
    }

    public static void main(String[] args) {
        FindMaxNumAndAggCount findMaxNumAndAggCount = new FindMaxNumAndAggCount();
        int[] array = {1, 3, 3, 3, 4, 5, 6, 7, 8, 8, 8, 8, 8, 9, 10, 10, 11, 11, 12, 23, 33, 33, 10, 2, 2, 2, 2, 2, 2, 1, 1, 1};
        int[] result = findMaxNumAndAggCount.maxNumAndAggCount(array);
        System.out.println(Arrays.toString(result));

        int [] ans = findMaxNumAndAggCount.maxNumAndAggCount(new int[]{1, 1, 3, 3, 5, 6, 7, 7, 7, 8, 10, 15, 20, 22, 23, 23, 45, 56, 80,80,80, 45, 45, 43, 42, 32, 32, 14, 11, 6, 3, 3});

        System.out.println(Arrays.toString(ans));

    }


}
