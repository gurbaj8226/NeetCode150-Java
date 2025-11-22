package BackTracking.Subsets;

import java.util.ArrayList;
import java.util.List;

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
