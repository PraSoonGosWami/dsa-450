package dsa;

import java.util.Arrays;

public class nextPermutation{
    /**
     * Next Permutation
     * https://leetcode.com/problems/next-permutation/
     * O(N) | O(1)
     */

    public static void solution(char [] nums){
        int n = nums.length;
        //get the pivot element and break from the loop
        //pivot element is that element from back where a[i] < a[i+1]
        //then element at i is pivot
        int i = n - 2;
        while(i >= 0){
            if(nums[i] < nums[i+1])
                break;
            i--;
        }

        //if pivot index is < 0
        //that means no next greater permutation can be find
        //ex = 3 2 1

        //get the element from back which is greater than pivot element
        //when found swap pivot with the first appearing greater number from back
        //break from the loop
        int j = n - 1;
        while(j > i && i != - 1){
            if(nums[j] > nums[i]){
                char t = nums[j];
                nums[j] = nums[i];
                nums[i] = t;
                break;
            }
            j--;
        }

        //now reverse the whole array after pivot till end
        //from pivot index + 1 to end
        int start = i + 1;
        int end = n - 1;
        while(start < end){
            char t = nums[start];
            nums[start] = nums[end];
            nums[end] = t;
            start++; end--;
        }

        System.out.println(String.valueOf(nums));
    }
}
