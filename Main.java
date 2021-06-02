package dsa;

import java.util.*;


public class Main {

    public static void main(String[] args) {
        int[] arr = new int[]{4,3,0,1,6};
        int arr2[][] = new int[][]{{1, 3}, {2, 5}, {1, 0}, {3, 6}, {9, 9}};


        boolean res = subArrSumZero.solution1(arr,arr.length);
        System.out.println(res);


    }
}
