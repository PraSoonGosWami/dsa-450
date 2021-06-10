package dsa.arrays;

import java.util.HashMap;

public class elementsMoreThanNbyK {

    /**
     * Given an array of size n and a number k, find all elements that appear more than n/k times
     * https://www.geeksforgeeks.org/given-an-array-of-of-size-n-finds-all-the-elements-that-appear-more-than-nk-times/
     * O(N) | O(N)
     */

    public static void solution(int [] arr, int k, int n){
        if(n == 0) return;
        if(n == 1) {
            System.out.println(arr[0]);
            return;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int x : arr){
            int val = map.getOrDefault(x,0);
            map.put(x, val+1);
        }

        for(int key : map.keySet()){
            if(map.get(key) > n/k) System.out.print(key + " ");
        }

        System.out.println("");
    }
}
