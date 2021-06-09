package dsa;

public class medianOfTwoSortedArraysOfEqualSizes {
    /**
     * Median of two sorted arrays of equal size.
     * https://www.geeksforgeeks.org/median-of-two-sorted-arrays/
     * O(logN) | O(1)
     */

    private static float findMedianUtil(int[] arr, int start, int end) {
        int n = end - start + 1;
        int mid = (start + end) / 2;
        if (n % 2 == 0)
            return (arr[mid] + arr[mid + 1]) / 2;
        return arr[mid];
    }

    private static float findMedian(int[] arr1, int s1, int e1, int[] arr2, int s2, int e2) {

        if (e1 == s1 + 1)
            return (float) (Math.max(arr1[s1], arr2[s2]) + Math.min(arr1[e1], arr2[e2])) / 2;


        float m1 = findMedianUtil(arr1, s1, e1);
        float m2 = findMedianUtil(arr2, s2, e2);


        if (m1 == m2) return m1;

        else if (m1 < m2) return findMedian(arr1, (s1 + e1) / 2, e1, arr2, s2, (s2 + e2) / 2);

        else return findMedian(arr1, s1, (s1 + e1) / 2, arr2, (s2 + e2) / 2, e2);
    }

    public static void solution(int[] arr1, int[] arr2) {
        System.out.println(findMedian(arr1, 0, arr1.length - 1, arr2, 0, arr2.length - 1));

    }
}
