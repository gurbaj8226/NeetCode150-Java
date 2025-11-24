package Graphs.WordLadder;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

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
