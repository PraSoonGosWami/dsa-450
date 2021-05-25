package dsa;

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

}
