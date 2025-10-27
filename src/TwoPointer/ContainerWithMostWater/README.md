# Container With Most Water

**Category:** Two Pointers (NeetCode)
**Difficulty:** Medium
**Time Complexity:** O(n)
**Space Complexity:** O(1)

## Problem Description:
You are given an integer array `height` of length `n`. Each element represents the height of a vertical line drawn at that index.
Find two lines that together with the x-axis form a container that holds the most water.

## Approach:
1. Start with two pointers, left at 0 and right at the end of the array. 
2. Calculate the area by subtracting right - left to get the width, and multiplying it by the lesser of the two bar heights, which can be found using the Math.min function. 
3. Track the maximum area using the Math.max function. 
4. Whichever pointer is on the smaller line, move that inwards. This is to find a greater number to multiply with. 
5. Repeat until left meets right.

## Example:
**Input:**
`height = [1,8,6,2,5,4,8,3,7]`

**Output:**
`49`

**Explanation:**
Between lines at indices 1 and 8 → width = 7, height = 7 → 7×7 = 49.

## Java Code:
public class ContainerWithMostWater {

	public static int maxArea(int[] heights) {
	
        int right = heights.length-1;
        
        int area = 0;
        
        int max = 0;
        
        int left = 0;
        
        while(left<right) {
        
        	area=(right-left)*Math.min(heights[left], heights[right]);
        	
        	max = Math.max(max, area);
        	
        	if(heights[left]<=heights[right]) {
        	
        		left++;
        		
        	}
        	
        	else {
        	
        		right--;
        		
        	}
        	
        }
        
        return max;
        
    }
}
