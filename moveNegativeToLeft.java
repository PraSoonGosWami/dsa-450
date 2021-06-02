package dsa;

public class moveNegativeToLeft {
    /**
     * Move all negative numbers to beginning and positive to end with constant extra space
     * https://www.geeksforgeeks.org/move-negative-numbers-beginning-positive-end-constant-extra-space/
     */

    /**
     * using partition algo of quick sort by keeping pivot as 0
     * O(N) | O(1)
     */
    public static void solution(int arr[]) {
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                if (i != index) {
                    int t = arr[i];
                    arr[i] = arr[index];
                    arr[index] = t;
                }
                index++;
            }
        }
        System.out.println(index);
    }
}
