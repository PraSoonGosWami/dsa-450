package dsa.arrays;

public class maxSubarraySum {
    /**
     * Kadane's Algorithm | Max Sub array sum
     * https://practice.geeksforgeeks.org/problems/kadanes-algorithm-1587115620/1
     */

    //O(N) | O(1)
    public static void solution(int arr[]){
        int t = 0;
        int max = Integer.MIN_VALUE;
        for(int x : arr){
            t = Integer.max(x, x+t);
            max = Integer.max(t,max);
        }

        System.out.println(max);
    }

    //O(N) | O(1)
    public static void solution2(int arr[]){
        int t = 0;
        int max = 0;
        for(int x : arr){
            t =  x+t;
            if(max < t)
                max = t;
            if(t<0)
                t = 0;
        }

        System.out.println(max);
    }
}
