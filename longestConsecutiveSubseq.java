package dsa;

import java.util.Arrays;
import java.util.HashSet;

public class longestConsecutiveSubseq {

    /**
     * Longest consecutive subsequence
     * https://practice.geeksforgeeks.org/problems/longest-consecutive-subsequence2449/1
     */

    //O(N log N) | O(1)
    public static void solution1(int[] arr) {
        if (arr.length == 0)
            return;
        if (arr.length == 1) {
            System.out.println(arr[0]);
            return;
        }
        Arrays.sort(arr);
        int count = 0, res = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1] + 1) count++;
            else if (arr[i] != arr[i - 1]) count = 0;

            res = Integer.max(res, count);
        }

        System.out.println(res+1);
    }


    //O(N) | O(N)

    public static void solution2(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int x : arr) set.add(x);
        int res = 0;
        for (int x : arr) {
            /**
             * start of a sub sequence
             * we find element which do not have a smaller consecutive element
             * then we keep on incrementing the number until its not found in hashset
             * for ex {1,9,3,10,4,20,2}
             * s1 - 1 is the start of sub sequence as there no 0 in the array
             * s2 - now we increment 1 by 1 till it can be seen in the set
             * s3 - finally when x = 5 it will break as there's no 5 in the set
             * s4 - count = 5 - 1 = 4 | res = max(res,count)
             * next we move to element 9 in array as there's no 8 so 9 is starting of a sub seq
             * and repeat from s1 to s4
             */
            if (!set.contains(x - 1)) {
                int y = x;
                while(set.contains(y)) y++;
                res = Integer.max(res, y -x);
            }
        }

        System.out.println(res);
    }


}
