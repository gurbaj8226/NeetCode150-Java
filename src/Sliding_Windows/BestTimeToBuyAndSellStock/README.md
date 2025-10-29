#Best Time to Buy and Sell Stock

**Category:** Sliding Window (Neetcode)

**Difficulty:** Easy

**Time Complexity:** O(N)

**Space Complexity:** O(1)

#Problem Description: given an integer array prices where prices[i] is the price of NeetCoin on the i'th day, return the maximum profit you can achieve

#Approach: 
- Set maximum price to 0, which is what you will return if there is no potential profit.
- Set the variable left to 0 and use a for loop where you set right to 1.
- For each iteration, if right is greater than left, use Math.max to see if this profit is greater. 
- If right is less than left, then set left to right, and keep going. 

#Example: 
Input: [7, 1, 5, 3, 6, 4]

Output: 5

Explanation: Buy at 1, sell at 6

#Java Code: 
public class BestTimeToBuyAndSellStock {
	public int maxProfit(int[] prices) {
	
		int left = 0;
		
		int maximum = 0;
		
		for (int right = 1; right < prices.length; right++) {
		
            if(prices[right]>prices[left]) {
            
				maximum = Math.max(maximum, prices[right] - prices[left]);
				
			}
			else
			
		    	left = right;
			
		}
		return maximum;
	}
}

