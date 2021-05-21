package dsa;

public class cyclicRotation {
    /**
     * Cyclically rotate an array by one
     * https://practice.geeksforgeeks.org/problems/cyclically-rotate-an-array-by-one2614/1
     */

    private static void reverse(long arr[], int start, int end){
        while(start < end){
            long t = arr[start];
            arr[start] = arr[end];
            arr[end] = t;
            start++;
            end--;
        }
    }

    public void rotate(long arr[], long n){
        reverse(arr,0,(int)n-2);
        reverse(arr,0,(int)n-1);
    }
}
