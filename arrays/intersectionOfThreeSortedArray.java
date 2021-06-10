package dsa.arrays;

import java.util.ArrayList;

public class intersectionOfThreeSortedArray {
    /**
     * Unique Common elements in 3 sorted array
     * https://practice.geeksforgeeks.org/problems/common-elements1132/1#
     * O(N1 + N2 + N3)
     * if a[i] == b[j] == c[j] increment all pointers and add element to result
     * else if a[i] < b[j] increment i as i is less than j and cannot be equal
     * else if b[j] < c[k] increment j as j is less than k and cannot be equal
     * else increment k as k is smaller than all
     */

    public static ArrayList<Integer> solution(int A[], int B[], int C[]) {

        int i = 0, j = 0, k = 0;
        ArrayList<Integer> res = new ArrayList<>();
        while (i < A.length && j < B.length && k < C.length) {
            if (A[i] == B[j] && B[j] == C[k]) {
                res.add(A[i]);
                i++;
                j++;
                k++;
            }
            else if(A[i] < B[j]) i++;
            else if(B[j] < C[k]) j++;
            else k++;
        }
        return res;
    }
}
