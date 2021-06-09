package dsa;

import java.util.Arrays;
import java.util.HashSet;

public class subArrayWithGivenSum {

    /**
     * Find a sub array with given sub
     * https://www.geeksforgeeks.org/find-subarray-with-given-sum/
     */

    /**
     * All the elements in the array may be negative or non negative.
     * Works for all kinds of element.
     * See below for more optimized solutions.
     * O(N) | O(N)
     */
    public static boolean solution1(int[] arr, int k) {
        HashSet<Integer> set = new HashSet<>();
        int sum = 0;
        for (int x : arr) {
            sum += x;
            if (set.contains(Math.abs(sum - k)) || sum == k || x == k) return true;
        }

        return false;
    }

    /**
     * All the elements in the array are non negative.
     * We use sliding window strategy.
     * O(N) | O(1)
     */
    public static boolean solution2(int[] arr, int k) {

        int start = 0, sum = 0;
        for(int i = 0; i < arr.length; i++){
            while (sum > k && start < i){
                sum -= arr[start];
                start++;
            }
            if(sum == k){
                System.out.println(start + "-" + (i-1));
                return true;
            }
            sum += arr[i];
        }
        //if last element alone == k
        //we need to check for the edge case
        if(sum - arr[start] == k) {
            System.out.println(arr.length-1);
            return true;
        }
        return false;
    }

    /**
     * All the elements in the array may be negative or non negative.
     * The idea is to make the whole array positive find adding abs value
     * of the minimum element to all the elements of the array
     * And then use solution2
     * https://www.geeksforgeeks.org/find-subarray-with-given-sum-with-negatives-allowed-in-constant-space/
     * O(N) | O(1)
     */
    public static boolean solution3(int[] arr, int k) {
        int min = Integer.MAX_VALUE;
        for(int x : arr) min = Math.min(min,x);
        min = Math.abs(min);
        int sum = 0, start = 0;
        for(int i = 0; i < arr.length; i++){
            while( sum - (i - start) * min  > k && start < i ){
                sum = sum - arr[start] - min;
                start++;
            }

            if(sum - (i - start) * min == k ) {
                System.out.println(start + "-" + (i-1));
                return true;
            }

            sum += arr[i] + min;
        }

        if(sum - arr[start] == k) return true;

        return false;
    }

}
