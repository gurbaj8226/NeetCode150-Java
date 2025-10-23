#Permutation in String

**Category:** Sliding Window (Neetcode)

**Difficulty:** Medium

**Time Complexity:** O(N)

**Space Complexity:** O(1)

#Problem Description: Given two string 's1' and 's2', return 'true' if 's2' contains a substring that is a permutation of 's1'.

#Approach: 
- Create two integer arrays of size 26 to track the character count in both Strings. 
- Use a for loop to fill the arrays up to the length of s1, which will be the size of the window. 
- "s1.charAt(i) - 'a'" represents the characters ASCII values, as 'a' = 97, and every other letter is 97 + the number of the letter. This allows you to keep track of which number letter by referring specifically to the array index. 
- Next, you will use the final for loop to check if the Arrays are equal, and if not, slide the window once to the left and right each. 
- The for loop uses "i < s2.length() - s1.length()" because our initial condition checks the first window size, so then we can move onto the rest. 

#Example: 
Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: The substring 'ba' is present in 's2', which is a permutation of 'ab', so the function returns true; 

#Java Code: 

package Sliding_Windows.PermutationInString;

import java.util.Arrays;

public class PermutationInString {

	public static boolean PermInString(String s1, String s2) {
	
		if (s1.length() > s2.length()) {
		
			return false;
			
		}

		int[] s1Count = new int[26];
		
		int[] s2Count = new int[26];

		for (int i = 0; i < s1.length(); i++) {
		
			s1Count[s1.charAt(i) - 'a']++;
			
			s2Count[s2.charAt(i) - 'a']++;
			
		}

		for (int i = 0; i < s2.length() - s1.length(); i++) {
		
			if (Arrays.equals(s1Count, s2Count))
			
				return true;

			s2Count[s2.charAt(i) - 'a']--;
			
			s2Count[s2.charAt(i + s1.length()) - 'a']++;
			
		}
		
		return Arrays.equals(s1Count, s2Count);
		
	}
}


