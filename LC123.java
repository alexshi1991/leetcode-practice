public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        
        // DP left to right
        int[] dpLeft = new int[prices.length];
        int low = prices[0];
        for (int i = 1; i < prices.length; i++) {
            dpLeft[i] = Math.max(dpLeft[i-1], prices[i] - low);
            low = Math.min(low, prices[i]);
        }
        
        // DP right to left
        int[] dpRight = new int[prices.length];
        int high = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
            dpRight[i] = Math.max(high - prices[i], dpRight[i+1]);
            high = Math.max(prices[i], high);
        }
        
        // find the max profit
        int maxProfit = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length - 1; i++) {
            maxProfit = Math.max(dpLeft[i] + dpRight[i+1] , maxProfit);
        }
        
        // only 1 transaction
        maxProfit = Math.max(dpLeft[prices.length - 1], maxProfit);
        
        return maxProfit;
    }
}

