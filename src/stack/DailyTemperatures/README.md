# Daily Temperatures

**Category:** Stack (NeetCode)  

**Difficulty:** Medium  

**Time Complexity:** O(n)  

**Space Complexity:** O(n)

## Problem Description
Given an array of integers `temperatures` representing the daily temperatures,  
return an array `answer` such that `answer[i]` is the number of days you have to wait after the `i-th` day to get a warmer temperature.  
If there is no future day for which this is possible, keep `answer[i] = 0`.

## Approach
* Use a stack that stores indices of unresolved temperatures.  
* Iterate through the array:
  * While the current temperature is greater than the temperature at the top index of the stack, pop it.
  * The difference between the current index and the popped index gives the number of days waited.
  * Push the current index onto the stack.
* This ensures each index is pushed and popped at most once → O(n).

## Example
**Input:**  
`temperatures = [73, 74, 75, 71, 69, 72, 76, 73]`  

**Output:**  
`[1, 1, 4, 2, 1, 1, 0, 0]`  

**Explanation:**  
You wait 1 day after 73 to get 74, 1 day after 74 to get 75, 4 days after 75 to get 76, etc.

## Java Code
```java
public class DailyTemperatures {
	 public int[] dailyTemperatures(int[] temperatures) {
	        Stack < Integer > stack = new Stack<>();
	        int[] result = new int[temperatures.length];
	        for(int i = 0; i < temperatures.length; i++){
	            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
	                int index = stack.pop();
	                result[index] = i - index;
	            }
	            stack.push(i);
	        }
	        return result;
	    }
}

---