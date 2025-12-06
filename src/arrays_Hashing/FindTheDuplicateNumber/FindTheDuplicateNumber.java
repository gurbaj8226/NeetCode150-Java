package arrays_Hashing.FindTheDuplicateNumber;

public class FindTheDuplicateNumber {
	public int findDuplicate(int[] nums) {

		for (int n : nums) {
			int idx = Math.abs(n) - 1;

			if (nums[idx] < 0) {
				return Math.abs(n);
			}

			nums[idx] *= -1;
		}

		return -1;
	}
}
