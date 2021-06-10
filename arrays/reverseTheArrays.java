package dsa.arrays;

public class reverseTheArrays {
    //Write a program to reverse an array or string
    /** https://www.geeksforgeeks.org/write-a-program-to-reverse-an-array-or-string/ */

    public static void solution(int arr[]){
        int start = 0;
        int end = arr.length - 1;
        int temp;
        while (start < end)
        {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
