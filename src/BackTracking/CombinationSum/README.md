# Combination Sum

**Category:** Backtracking (NeetCode)  
**Difficulty:** Medium  
**Time Complexity:** O(T) where T is number of combinations  
**Space Complexity:** O(target)

## Problem Description
Given an array of distinct integers `candidates` and a target integer `target`,  
return all unique combinations where the chosen numbers sum to `target`.  
You may use the same number multiple times.

## Approach
* Use **DFS + backtracking** to build combinations.  
* For each candidate, explore:
  - including it (stay at same index)  
  - skipping it (move to next index)  
* Stop when:
  - sum exceeds target → backtrack  
  - sum equals target → add to results  

## Example
**Input:**  
candidates = [2,3,6,7], target = 7

**Output:**  
[[2,2,3],[7]]

##Java Code
```Java
public class CombinationSum {
	List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        backtrack(nums, target, subset, 0);
        return res;
    }

    public void backtrack(int[] nums, int target, List<Integer> subset, int index){
        if(target == 0){
            res.add(new ArrayList<>(subset));
            return;
        }
        if(target < 0 || index >= nums.length){
            return;
        }
        subset.add(nums[index]);
        backtrack(nums, target - nums[index], subset, index);
        subset.remove(subset.size() - 1);
        backtrack(nums, target, subset, index + 1);
    }
}
