package dsa;


import java.util.Arrays;


import static dsa.unionIntersection.unionUnsorted1;
import static dsa.unionIntersection.unionUnsorted2;
import static dsa.unionIntersection.solution;
import dsa.maxSubarraySum.*;

public class Main {
    public static void main(String[] args) {
        int arr[] = new int[] {-2, -3, 4, -1, -2, 1, 5, -3};
        int arr2[] = new int[] {2,2,3,3,9};
        //unionUnsorted1(arr,arr2);
        maxSubarraySum.solution(arr);
        maxSubarraySum.solution2(arr);

    }
}
