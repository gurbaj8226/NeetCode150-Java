# Koko Eating Bananas

**Category:** Binary Search (NeetCode)  
**Difficulty:** Medium  
**Time Complexity:** O(n · log(m))  
**Space Complexity:** O(1)

## Problem Description
Koko loves bananas.  
She has `piles[i]` bananas in each pile and wants to eat all of them within `h` hours.

Each hour, she chooses one pile and eats `k` bananas from it.  
If the pile has fewer than `k` bananas, she eats the whole pile.

Return the **minimum integer k** such that she can finish all bananas within `h` hours.

## Approach
* Use **binary search on the answer** (search for the right eating speed).  
* Range of k is `1` to `max(piles)`.  
* For each k, compute hours used:
  * `hours += ceil(pile / k)`  
* If hours ≤ h → speed is valid → try smaller k.  
* Else → increase k.

## Example
**Input:**  
piles = [3, 6, 7, 11], h = 8  

**Output:**  
`4`

## Java Code
```java
public class KokoEatingBananas {
	 public int minEatingSpeed(int[] piles, int h) {
	        int left = 1;
	        int right = Arrays.stream(piles).max().getAsInt();
	        int result = 0;

	        while(left <= right){
	            int k = (left + right)/2;

	            long totalTime = 0;
	            for(int p: piles){
	                totalTime += Math.ceil((double)p / k);
	            }

	            if(totalTime <= h){
	                result = k;
	                right = k - 1;
	            }
	            else{
	                left = k + 1;
	            }
	        }
	        return result;
	    }
}
