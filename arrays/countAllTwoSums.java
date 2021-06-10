package dsa.arrays;

import java.util.HashMap;
import java.util.HashSet;

public class countAllTwoSums {
    /**
     * Count pairs with given sum
     * https://practice.geeksforgeeks.org/problems/count-pairs-with-given-sum5022/1#
     * O(N) | O(N)
     */

    public static int solution(int [] arr, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int x : arr){
            if(map.containsKey(x)){
                count += map.get(x);
            }
            //finding complement of the element x
            int comp = k - x;
            if(comp > 0){
                int value = map.getOrDefault(comp,0);
                map.put(comp,value+1);
            }

        }

        return count;
    }
}
