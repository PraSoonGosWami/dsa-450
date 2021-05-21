package dsa;

public class maxMinElementArray {
    /**
     * Maximum and minimum of an array using minimum number of comparisons
     * https://www.geeksforgeeks.org/maximum-and-minimum-in-an-array/
     */

    public static void solution(int arr[]) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int x : arr) {
            min = Math.min(min, x);
            max = Math.max(max, x);
        }
        System.out.println("MAX: " + max + " MIN: " + min);
    }
}
