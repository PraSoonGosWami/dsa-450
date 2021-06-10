package dsa.arrays;

import java.util.Arrays;

public class alternateNegPos {

    /**
     * Rearrange array in alternating positive & negative items with O(1) extra space
     * Also maintain the order of the appearance of element
     * https://www.geeksforgeeks.org/rearrange-array-alternating-positive-negative-items-o1-extra-space/
     * O(N^2) | O1)
     */

    private static void rightRotate(int arr[], int start, int end) {
        if (end == -1)
            return;
        int t = arr[end];
        while (end > start) {
            arr[end] = arr[end - 1];
            end--;
        }
        arr[start] = t;
    }

    private static int returnIndex(int[] arr, int start, boolean findNeg) {
        int j = start + 1;
        while (j < arr.length) {
            if ((findNeg && arr[j] < 0) || (!findNeg && arr[j] >= 0))
                return j;
            j++;
        }

        //returns -1 if nothing foind
        return -1;
    }

    public static void solution(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //if not negative at even index
            if (i % 2 == 0 && arr[i] >= 0) {
                //find next neg
                int j = returnIndex(arr, i, true);
                rightRotate(arr, i, j);
            }
            //if not positive at odd index
            if (i % 2 != 0 && arr[i] < 0) {
                //find next pos
                int j = returnIndex(arr, i, false);
                rightRotate(arr, i, j);
            }
        }
    }

    /**
     * Without maintaining the order
     * O(N) | O(1)
     */
    public static void solution2(int[] arr){
        //quick sort partition
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
        int i = 1, j = index;
        while(i < arr.length && j < arr.length){
            if((i % 2 == 0 && arr[i] >= 0) || (i % 2 != 0 && arr[i]< 0)){
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                j++;
            }
            i++;

        }
    }
}
