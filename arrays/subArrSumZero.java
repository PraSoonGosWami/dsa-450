package dsa.arrays;

import java.util.Arrays;
import java.util.HashSet;

public class subArrSumZero {
    /**
     * Subarray with 0 sum
     * https://practice.geeksforgeeks.org/problems/subarray-with-0-sum-1587115621/1
     */

    //O(N^2) | O(N)
    public static boolean solution1(int [] arr, int n){
        if(arr[0] == 0)
            return true;

        for(int i = 1; i < n; i++){
            if(arr[i] == 0) return true;
            arr[i] = arr[i] + arr[i-1];
            if(arr[i] == 0) return true;
        }
        for(int i = 0; i < n-1; i++){
            for(int j = i + 1; j < n; j++){
                if(arr[i] - arr[j] == 0) return true;
            }
        }

        return false;
    }

    //O(N) | O(N)
    public static boolean solution2(int [] arr, int n){
        if(n == 0) return false;
        if(arr[0] == 0) return true;
        HashSet<Integer> set = new HashSet<>();
        int sum = 0;
        for(int x : arr){
            sum += x;
            if(set.contains(sum) || sum == 0 || x == 0) return true;
            set.add(sum);
        }

        return false;
    }


}
