# Word Ladder

**Category:** Graphs (NeetCode)  
**Difficulty:** Hard  
**Time Complexity:** O(m^2 * n)  
**Space Complexity:** O(m^2 * n);

## Problem Description
You are given two strings, `beginWord` and `endWord`, and a list of words.  
Return the **length of the shortest transformation sequence** from `beginWord` to `endWord`, where:

* Only **one letter** can change at a time.
* Each transformed word must exist in the given word list.

If no sequence exists, return 0.

## Approach
* Use **BFS** since this is an unweighted shortest-path problem.  
* Preprocess the word list to create **generic patterns** (e.g., `h\*t`, `\*ot`, `ho\*`) → each pattern maps to all words that match it.
* Push `beginWord` into a BFS queue with level = 1.
* For each word popped from the queue:
  - Generate all possible patterns.
  - Retrieve all neighbors (words differing by one letter).
  - Push unvisited neighbors into the queue.
* Once `endWord` is discovered, return its BFS level.
* Use a visited set to prevent cycles.

## Example
**Input:**  
beginWord = "hit"  
endWord = "cog"  
wordList = ["hot","dot","dog","lot","log","cog"]

**Output:**  
`5`

**Explanation:**  
`"hit" → "hot" → "dot" → "dog" → "cog"` is the shortest sequence.

##Java Code
```Java
public class WordLadder {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord) || beginWord.equals(endWord)){
            return 0;
        }
        Set <String> words = new HashSet<>(wordList);
        int res = 0;
        Queue <String> q = new LinkedList<>();
        q.add(beginWord);

        while(!q.isEmpty()){
            res++;
            for(int i = q.size(); i > 0; i--){
                String current = q.poll();
                if(current.equals(endWord)){
                    return res;
                }
                for(int j = 0; j < current.length(); j++){
                    char[] array = current.toCharArray();
                    for(char c = 'a'; c <= 'z'; c++){
                        if(c == array[j]){
                            continue;
                        }
                        array[j] = c;
                        String neighbor = new String(array);
                            if(words.contains(neighbor)){
                                q.add(neighbor);
                                words.remove(neighbor);
                            }
                        }
                    }
                }
            }
            return 0;
        }
}
