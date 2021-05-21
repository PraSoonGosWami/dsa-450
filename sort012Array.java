package dsa;

public class sort012Array {

    /**
     * Sort an array of 0s, 1s and 2s
     * https://practice.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s4231/1
     *
     **/

    //O(N) | O(1)
    public static void solution(int a[], int n) {
        int zeros = 0;
        int ones = 0;
        for (int x : a) {
            if (x == 0) zeros++;
            if (x == 1) ones++;
        }
        for (int i = 0; i < zeros; i++)
            a[i] = 0;

        for (int j = zeros; j < ones + zeros; j++)
            a[j] = 1;

        for (int k = ones + zeros; k < n; k++)
            a[k] = 2;
    }
}
