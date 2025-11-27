# Car Fleet

**Category:** Stacks (NeetCode)  
**Difficulty:** Medium  
**Time Complexity:** O(n log n) (sorting)  
**Space Complexity:** O(n)

## Problem Description
There are `n` cars going to the same destination.  
You are given:

* `target` — destination point  
* `position[i]` — current position of car `i`  
* `speed[i]` — speed of car `i`

A **car fleet** forms when:
* A faster car catches a slower car **from behind**,  
* And they move together at the slower car's speed.  

Return the **number of car fleets** that will arrive at the destination.

## Approach
* Pair each car as `(position, timeToTarget)`, where:  
  `time = (target - position) / speed`
* Sort cars **in decreasing order of position** (closest to target first).  
* Use a **stack** to track fleets:
  * Traverse sorted cars:
    * If the current car’s time is **greater** than the stack top → it becomes a new fleet.
    * If the current car’s time is **less/equal** → it joins the existing fleet.
* The number of items in the stack = number of fleets.

Sorting ensures we only look backward.

## Example
**Input:**  
`target = 12`  
`position = [10,8,0,5,3]`  
`speed = [2,4,1,1,3]`

**Output:**  
`3`

## Code (Java)
```java
public class CarFleet {
	 public int carFleet(int target, int[] position, int[] speed) {
	        int[][] pair = new int[position.length][2];
	        for(int i = 0; i < position.length; i++){
	            pair[i][0]= position[i];
	            pair[i][1] = speed[i];
	        }
	        Arrays.sort(pair, (a,b) -> Integer.compare(b[0], a[0]));
	        Stack<Double> stack = new Stack<>();

	    for(int[] p: pair){
	        stack.push((double) (target - p[0]) / p[1]);
	        if(stack.size() >= 2 && stack.peek() <= stack.get(stack.size() - 2)){
	        stack.pop();
	    }
	    }


	    return stack.size();
	    }
}

