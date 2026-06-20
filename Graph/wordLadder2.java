package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
A transformation sequence from word beginWord to word endWord using a dictionary 
wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return all the shortest
 transformation sequences from beginWord to endWord, or an empty list if no such sequence exists.
  Each sequence should be returned as a list of the words [beginWord, s1, s2, ..., sk].
*/
public class wordLadder2 {
    public static void main(String[]args){
        List<String> wordList = Arrays.asList("des", "der", "dfr", "dgt", "dfs");
        String startWord = "der", targetWord = "dfs";

        List<List<String>>ans = null;

        ans = findAllShortestPath(wordList,startWord,targetWord);

        if (ans.isEmpty()) {
            System.out.println(-1);
        } else {
            ans.sort((a, b) -> String.join("", a).compareTo(String.join("", b)));
            for (List<String> sequence : ans) {
                System.out.println(String.join(" ", sequence));
            }
        }
    }

    /*
    
    This problem is an extension of the Word Ladder I problem. Here, instead of finding the 
    length of the shortest transformation sequence, we need to find all shortest sequences that transform 
    beginWord to endWord using words from the wordList.

    Insert all words from wordList into an unordered_set for O(1) lookups.
    Use a queue of vectors to store sequences of words leading from beginWord to the current word.
    Perform BFS:
    At each level, maintain a usedOnLevel vector of words used in that level and erase them from the set at the start of the next level.
    For each word at the end of a sequence, try changing every character to 'a'-'z'. If the resulting word exists in the set:
    Create a new sequence with this word appended.
    Push the new sequence to the queue.
    If a sequence reaches the endWord, store it. Only sequences with minimal length are stored.
    Return all sequences of minimal length after BFS ends.

    Time Complexity: O(N × L × 26 + S × L) → dominated by generating all transformations (N = words, L = word length, S = number of shortest sequences).

    Space Complexity: O(N × L + S × L) → for queue storing paths, set for unused words, and final sequences.
    */

    public static List<List<String>> findAllShortestPath(List<String>wordList,String startWord, String endWord){
        Queue<List<String>>q = new LinkedList();
        Set<String>st = new HashSet<>(wordList);
        List<String>usedWord = new ArrayList<>();

        q.add(new ArrayList<String>(Arrays.asList(startWord)));
        usedWord.add(startWord);

        List<List<String>>ans = new ArrayList<>();
        int level = 0;

        while(!q.isEmpty()){
            List<String>lis = q.poll();

            if(lis.size() > level){
                level++;
                for(String str: usedWord){
                    st.remove(str);
                }
            }


            String word = lis.get(lis.size()-1);
            if(word.equals(endWord)){
                if(ans.isEmpty()){
                    ans.add(new ArrayList<>(lis));
                }
                else if(ans.get(0).size() == lis.size()){
                    ans.add(new ArrayList<>(lis));
                }
            }
            char[] arrWord = word.toCharArray();
            for(int i = 0; i<arrWord.length; i++){
                char original = arrWord[i];
                for(char ch = 'a'; ch<= 'z'; ch++){
                    arrWord[i]= ch;
                    String val = new String(arrWord);
                    if(st.contains(val)){
                        lis.add(val);
                        q.add(new ArrayList<>(lis));
                        usedWord.add(val);
                        lis.remove(lis.size()-1);
                    }
                }
                arrWord[i] = original;
            }

        }

        return ans;

    }
}
