package dsa.arrays;

import java.util.HashSet;

public class findDuplicate {
    /**
     * Find the Duplicate Number
     * https://leetcode.com/problems/find-the-duplicate-number/
     */

    //O(N) | O(N)
    public static int solution1(int[] nums) {

        HashSet<Integer> set = new HashSet<>();
        for (int x : nums) {
            if (set.contains(x)) {
                return x;
            }
            set.add(x);
        }
        return 0;
    }


    //O(N) | O(1)
    //if changing of array elements is allowed
    public static int solution2(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            int j = Math.abs(nums[i]);
            if(nums[j] < 0)
                return Math.abs(j);
            nums[j] = -1 * nums[j];
        }
        return 0;
    }

    //O(N) | O(1)
    //if changing of array elements is not allowed
    // floyd cycle detection algo taking 2 pointers
    // slow and fast
    public static int solution3(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        //finding the intersection point
        //detect if loop is present
        //if slow == speed loop is present
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow != fast);

        //finding the duplicate
        //setting slow to arr[0] again
        //and increasing both pointer at same speed
        slow = nums[0];
        while (slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }



}
