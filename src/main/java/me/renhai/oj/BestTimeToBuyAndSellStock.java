package me.renhai.oj;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * @author andy
 *
 */
public class BestTimeToBuyAndSellStock {

	public static void main(String[] args) {
		int[] prices = {11,1,7,6};
		int res = new BestTimeToBuyAndSellStock().maxProfit(prices);
		System.out.println(res);
	}
	
	// [11,1,7,6]
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxPro = 0;
        for (int i = 0; i < prices.length; i++) {
			min = Math.min(min, prices[i]);
			maxPro = Math.max(maxPro, prices[i] - min);
		}
        return maxPro;
    }

}
