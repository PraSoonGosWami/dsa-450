package dsa;

import java.util.Arrays;

public class countInversions {
    /**
     * Count Inversions
     * https://practice.geeksforgeeks.org/problems/inversion-of-array-1587115620/1#
     * O(N*logN) | O(N)
     */

    //the trick is to use merge sort algorithm to count number of inversions
    //we add (mid + 1) - (start + i ) to count if element in right sub array is less than left
    //(mid + 1) - (start + i ) signifies how many element in the left sub array is greater than
    //the element in the right sub array. and this no is the inversion count for particular element

    static long count = 0;

    private static void merge(long[] arr, int start, int mid, int end) {
        long[] left = Arrays.copyOfRange(arr, start, mid + 1);
        long[] right = Arrays.copyOfRange(arr, mid + 1, end + 1);
        int i = 0, j = 0, k = start;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) arr[k++] = left[i++];
            else {
                arr[k++] = right[j++];
                count += (mid + 1) - (start + i);
            }
        }

        while (i < left.length) arr[k++] = left[i++];
        while (j < right.length) arr[k++] = right[j++];

    }

    private static void mergeSort(long[] arr, int start, int end) {
        if (start >= end)
            return;
        int mid = (start + end) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    public static long solution(long[] arr) {
        mergeSort(arr, 0, arr.length - 1);
        return count;
    }
}
