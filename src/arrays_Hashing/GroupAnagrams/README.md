# Group Anagrams

**Category:** Arrays & Hashing (NeetCode)

**Difficulty:** Medium

**Time Complexity:** O(N * K log K)

**Space Complexity:** O(N * K)

---

## Problem Description

Given an array of strings `strs`, group the anagrams together. An anagram is a word or phrase formed by rearranging the letters of a different word or phrase.

## Approach

- Use a HashMap<String, List<String>>, as the String represents each word that will be put in the sublists which are represented by List<String>. 
- Iterate through each String in the ArrayList, and initialize a new array of size 26 for all the letters in the alphabet. 
- Iterate through each character of the String, and update the array with [c-'a']++, which is essentially returning the character value, which keeps track of the composition of characters. 
- Convert the array to a String, and if the specific values are absent, add it to the HashMap and create a new sublist, otherwise, just add it to the sublist it belongs to. 
- Return the new ArrayList of all the HashMap's values. 

## Example
**Input:** `["eat","tea","tan","ate","nat","bat"]`

**Output:** `[["bat"],["nat","tan"],["ate","eat","tea"]]`

**Explanation:**
- “eat”, “tea”, and “ate” all have the same sorted form → `"aet"`

- “tan” and “nat” → `"ant"`

- “bat” → `"abt"`

---

## Java Code
```java

public class GroupAnagrams {

	public static List<List<String>> groupAnagrams(String[] strs) {
	
		Map <String, List<String>> anagrams = new HashMap<>();
		
		for(String s: strs) {
		
			int[] count = new int[26];
			
			for(char c: s.toCharArray()) {
			
				count[c-'a']++;
				
			}
			
			String key = Arrays.toString(count);
			
			anagrams.putIfAbsent(key, new ArrayList<>());
			
			anagrams.get(key).add(s);
			
		}
		
		return new ArrayList<>(anagrams.values());
		
    }

}