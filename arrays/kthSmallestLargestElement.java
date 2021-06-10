package dsa.arrays;

import java.util.Arrays;

public class kthSmallestLargestElement {
    /**
     Kth smallest element
     https://practice.geeksforgeeks.org/problems/kth-smallest-element5635/1
    **/

    // O(N*logN) | O(1)
    public static int smallest1(int[] arr, int k){
        Arrays.sort(arr);
        return arr[k-1];
    }

    /**
     * O(N + K*logN) | O(1)
     * using min heap or heap select
     **/

    //creating min heap - O(logN)
    private static void heapify(int[] arr, int heapSize, int index ){
        int leftChild = 2*index + 1;
        int rightChild = leftChild+1;
        int min = index;

        if(leftChild < heapSize && arr[leftChild] < arr[min])
            min = leftChild;
        if(rightChild < heapSize && arr[rightChild] < arr[min])
            min = rightChild;
        if(min != index){
            int t = arr[min];
            arr[min] = arr[index];
            arr[index] = t;
            heapify(arr,heapSize,min);
        }
    }
    public static int smallest2(int[] arr, int k){
        int n =  arr.length;
        //heapifying the array - O(N) | O(1)
        for(int i = n/2 -1; i >= 0; i--)
            heapify(arr,n,i);
        //running heapify again for k times - K*logN
        for(int i = n-1; i >= n-k; i--){
            int t = arr[0];
            arr[0] = arr[i];
            arr[i] = t;
            heapify(arr,i,0);
        }
        return arr[n-k];
    }

    //use same logic for kth maximum element;

    /** Also look for a more optimised algo quick select with almost linear time complexity */
}
