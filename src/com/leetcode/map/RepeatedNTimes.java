package com.leetcode.map;

import java.util.HashSet;
import java.util.Set;

public class RepeatedNTimes {

    public int repeatedNTimes(int[] A) {
        Set<Integer> map=new HashSet<>();
        int i=0;
        for(;i<A.length;i++){
            if(map.contains(A[i])){
                break;
            }
            map.add(A[i]);
        }
        return A[i];
    }

    public int repeatedNTimesSp(int[] A) {
        for (int k = 1; k <= 3; ++k)
            for (int i = 0; i < A.length - k; ++i)
                if (A[i] == A[i+k])
                    return A[i];

        throw null;
    }

}
