# Valid Palindrome

**Category:** Two Pointers (NeetCode)
**Difficulty:** Easy
**Time Complexity:** O(n)
**Space Complexity:** O(1)

## Problem Description:
Given a string `s`, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

## Approach:
- Clean the string so that it is only using alphanumeric characters and lowercase. 
- Use two pointers, left starting at 0, and right starting at the end of the string. 
- Compare the characters, if they are not true, immediately return false, otherwise, move both pointers inwards. 
- If you have gone through the entire String, while left is no longer less than right, and it has not returned false, then return true. 

## Example:
**Input:**
`s = "A man, a plan, a canal: Panama"`

**Output:**
`true`

**Explanation:**
Ignoring punctuation and case, `"amanaplanacanalpanama"` is a palindrome.

## Java Code:
public class ValidPalindrome {

	public boolean isPalindrome(String s) {
	
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