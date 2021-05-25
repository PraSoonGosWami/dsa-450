package dsa;

import java.util.ArrayList;

public class sellBuyStock {
    /**
     * Best Time to Buy and Sell Stock I
     * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
     * O(N) | O(1)
     */

    public static int solution(int [] prices){
        int profit = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < min)
                min = prices[i];
            else if(prices[i] - min > profit)
                profit = prices[i] - min;
        }
        return profit;
    }


    /**
     * Best Time to Buy and Sell Stock II
     * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
     * O(N) | O(1)
     */

    public static int solution2(int [] prices){
        int profit = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] > prices[i-1])
                profit += prices[i] - prices[i-1];
        }

        return profit;

    }

    /**
     * Best Time to Buy and Sell Stock GEEKS FOR GEEKS
     * Print all index for max profit
     * https://practice.geeksforgeeks.org/problems/stock-buy-and-sell-1587115621/1
     * O(N) | O(1)
     */

    public static ArrayList<ArrayList<Integer>> stockBuySell(int A[], int n) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(n == 0 || n == 1)
            return res;
        int minIndex = 0;
        for(int i = 1; i < n; i++){
            if(A[i] <= A[i-1]){
                if(minIndex != i - 1){
                    ArrayList<Integer> index = new ArrayList<>();
                    index.add(0,minIndex);
                    index.add(1,i - 1);
                    res.add(index);
                }
                minIndex = i;
            }
        }

        if(minIndex == n-1)
            return res;
        ArrayList<Integer> index = new ArrayList<>();
        index.add(0,minIndex);
        index.add(1,n - 1);
        res.add(index);

        return res;

    }

}
