package dsa;

import java.util.Arrays;
import java.util.LinkedList;

public class mergeIntervals {

    /**
     * Merge intervals
     * https://leetcode.com/problems/merge-intervals/
     * O(N log N) | O(N)
     */

    public static int[][] solution(int[][] intervals){
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0],b[0]));
        LinkedList<int []> res = new LinkedList<>();
        for(int [] interval : intervals){
            if(res.isEmpty() || res.getLast()[1] < interval[0])
                res.add(interval);
            else
                res.getLast()[1] = Integer.max(res.getLast()[1], interval[1]);
        }

        return res.toArray(new int[res.size()][2]);
    }
}
