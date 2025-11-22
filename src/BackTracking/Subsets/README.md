# Subsets

**Category:** Backtracking (NeetCode)  
**Difficulty:** Medium  
**Time Complexity:** O(n × 2ⁿ)  
**Space Complexity:** O(n)

## Problem Description
Given an integer array `nums`, return *all possible subsets* (the power set).  
The solution set must not contain duplicate subsets.

## Approach
* Use **backtracking** to explore all subset combinations.  
* At each index, choose to **include** or **exclude** the number.  
* Add the current path to the result at every step.  
* Recursively build all subsets until all elements are processed.

## Example
**Input:**  
nums = [1,2,3]

**Output:**  
[[],[1],[1,2],[1,2,3],[1,3],[2],[2,3],[3]]

##Java Code
```Java
public class Subsets {
	public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs(nums, result, subset, 0);
        return result;
    }
    public void dfs(int[] nums, List<List<Integer>> result, List<Integer> subset, int index){
        if(index == nums.length){
            result.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[index]);
        dfs(nums, result, subset, index + 1);
        subset.remove(subset.size() -1);
        dfs(nums, result, subset, index + 1);
    }
}