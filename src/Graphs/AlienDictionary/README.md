# Alien Dictionary

**Category:** Graphs (Topological Sort)  
**Difficulty:** Hard  
**Time Complexity:** O(C) where C = total characters across all words  
**Space Complexity:** O(U + E) where U = unique characters, E = ordering edges  

## Problem Description  
You are given a list of words sorted according to the rules of an **alien language**.  
Your task is to determine a **valid alphabetical order** for the alien language.

Rules:
* When comparing two adjacent words, the **first differing character** determines the order.  
* If a longer word comes before its exact prefix (e.g., `"abc"` before `"ab"`), the ordering is **invalid** → return `""`.  
* If a cycle exists in ordering dependencies, return `""`.

## Approach  
* Treat each character as a node in a **directed graph**.  
* Compare each adjacent pair of words:  
  * Find the **first differing character** → this creates an edge `c1 → c2` meaning `c1` must appear before `c2`.  
* Build:  
  * `adj` → adjacency list  
  * `indegree` → count of how many characters must precede each character  
* Use **Kahn’s Algorithm** for topological sorting:  
  * Add all characters with indegree `0` to a queue  
  * Pop from queue, append to result, and reduce indegrees of neighbors  
  * If any character never reaches indegree `0`, a cycle exists → return `""`  
* If the final string length is not equal to the number of unique characters, return `""`.

## Example  
**Input:**  
["wrt", "wrf", "er", "ett", "rftt"]

**Output:**  
"wertf"

**Explanation:**  
By comparing adjacent words, we derive ordering rules:  
w → e → r → t → f  
This forms one valid alien alphabet ordering.

##Java Code
```Java
public class AlienDictionary {
	public String foreignDictionary(String[] words) {
	      Map <Character, Set<Character>> adj = new HashMap<>();
	      Map <Character, Integer> indegree = new HashMap<>();

	      for(String word: words){
	        for(char c: word.toCharArray()){
	            adj.putIfAbsent(c, new HashSet<>());
	            indegree.putIfAbsent(c, 0);
	        }
	      }

	      for(int i = 0; i < words.length - 1; i++){
	        String w1 = words[i];
	        String w2 = words[i + 1];
	        int minlen = Math.min(w1.length(), w2.length());
	        if(w1.length() > w2.length() && w1.substring(0, minlen).equals(w2.substring(0, minlen))){
	            return "";
	        }
	            for(int j = 0; j < minlen; j++){
	                if(w1.charAt(j) != w2.charAt(j)){
	                    if(!adj.get(w1.charAt(j)).contains(w2.charAt(j))){
	                        adj.get(w1.charAt(j)).add(w2.charAt(j));
	                        indegree.put(w2.charAt(j), indegree.get(w2.charAt(j)) + 1);
	                    }
	                    break;
	                }
	            }
	      }
	      
	      Queue <Character> q = new LinkedList<>();
	      for(char c: indegree.keySet()){
	        if(indegree.get(c) == 0){
	            q.offer(c);
	        }
	      }
	      StringBuilder res = new StringBuilder();
	      while(!q.isEmpty()){
	        char curr = q.poll();
	        res.append(curr);
	        for(char neighbor: adj.get(curr)){
	            indegree.put(neighbor, indegree.get(neighbor) - 1);
	            if(indegree.get(neighbor) == 0){
	                q.offer(neighbor);
	            }
	        }
	      }
	      if(res.length() != indegree.size()){
	        return "";
	      }

	      return res.toString();
	    }
}
