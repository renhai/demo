package com.sankuai.meituan.test.interview;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * @author andy
 *
 */
public class BestTimeToBuyAndSellStockII {

	public static void main(String[] args) {
		int[] prices = {11,1,7,6};
		int res = new BestTimeToBuyAndSellStockII().maxProfit(prices);
		System.out.println(res);
	}
	
	//explain: https://leetcode.com/discuss/42176/three-lines-in-c-with-explanation
    public int maxProfit(int[] prices) {
    	int max = 0;
    	for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i - 1]) {
				max += (prices[i] - prices[i - 1]);
			}
		}
    	return max;
    }

}
