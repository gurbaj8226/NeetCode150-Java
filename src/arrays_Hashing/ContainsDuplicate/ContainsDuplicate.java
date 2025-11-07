package arrays_Hashing.ContainsDuplicate;

import java.util.HashSet;

public class ContainsDuplicate {

	public static void main(String[] args) {
		

	}
	public boolean hasDuplicate(int[] nums) {
    HashSet<Integer> set = new HashSet<>();
    for(int n: nums) {
    	if(set.contains(n)) {
    		return true;
    	}
    	set.add(n);
    }
    return false;
    }
}
