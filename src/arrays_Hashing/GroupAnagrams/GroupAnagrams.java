package arrays_Hashing.GroupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
