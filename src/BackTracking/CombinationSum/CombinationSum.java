package BackTracking.CombinationSum;

import java.util.ArrayList;
import java.util.List;

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
