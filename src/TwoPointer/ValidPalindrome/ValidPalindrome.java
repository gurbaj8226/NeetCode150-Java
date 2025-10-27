package TwoPointer.ValidPalindrome;

public class ValidPalindrome {
	public static boolean isPalindrome(String s) {
		String isPalindrome = s.toLowerCase().replaceAll("[^a-z0-9]", "");
		int left = 0;
		int right = isPalindrome.length() - 1;
		while (left < right) {
			if (isPalindrome.charAt(right) != isPalindrome.charAt(left))
				return false;
			left++;
			right--;
		}
		return true;
	}
}
