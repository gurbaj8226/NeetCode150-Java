package Sliding_Windows.BestTimeToBuyAndSellStock;

public class BestTimeToBuyAndSellStock {
	public int maxProfit(int[] prices) {
		int left = 0;
		int maximum=0;
		for(int right =1;right<prices.length;right++) {
            if(prices[right]>prices[left]) {
				maximum=Math.max(maximum, prices[right]-prices[left]);
			}
			else
		    	left=right;
		}
		return maximum;
	}
}
