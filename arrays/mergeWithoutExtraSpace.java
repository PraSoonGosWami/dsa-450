package dsa.arrays;

import java.util.Arrays;

public class mergeWithoutExtraSpace {
    /**
     * Merge Without Extra Space
     * https://practice.geeksforgeeks.org/problems/merge-two-sorted-arrays5135/1
     */

    //O(N*logN + M*logM)
    public static void solution(int arr1[], int arr2[], int n, int m) {
        // code here
        int i = n - 1, j = 0;

        while (i >= 0 && j < m) {
            if (arr2[j] < arr1[i]) {
                int t = arr2[j];
                arr2[j] = arr1[i];
                arr1[i] = t;
                i--;
                j++;
            } else break;

        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }
}


