package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*

A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of 
words beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList,
 return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.
*/
public class WordLadder{
    public static void main(String[]args){
        List<String>wordList = Arrays.asList("des","der","dfr","dgt","dfs");
        String startWord = "der", targetWord = "dfs";

        int ans = countLengthToTarget(startWord,targetWord,wordList);

        System.out.println("The length to target word is: "+ans);
    }

    /*
    
     Approach:
     The problem aims to transform a startWord into a targetWord by changing one character at a time, 
     with each intermediate word present in a given wordList. The shortest sequence length is sought. We can model this problem as a graph:

        Each word is a node.
        An edge exists between two words if they differ by exactly one character.
        Breadth-First Search (BFS) ensures the shortest path is found from startWord to targetWord.
        Initialize a queue with a pair {startWord, 1} representing the word and its current transformation steps.
        Insert all words from wordList into a unordered_set for O(1) lookups.
        While the queue is not empty:
        Pop a word and its step count.
        If this word is the targetWord, return the step count.
        For each character in the word, try replacing it with all letters 'a' to 'z':
        If the new word exists in the set, erase it from the set and push it into the queue with steps + 1.
        If no transformation sequence is found, return 0.

        T.C - O(n*L*26);
        S.C - O(n*L)
    */

    public static int countLengthToTarget(String startWord, String targetWord, List<String>wordList){
        Set<String>words = new HashSet<>(wordList);
        Queue<String[]>element = new LinkedList<>();

        element.add(new String[]{startWord,"1"});

        while(!element.isEmpty()){
            String[] val = element.poll();
            String firstWord = val[0];
            int steps = Integer.parseInt(val[1]);
            // System.out.println(steps+" ");
            if(firstWord.equals(targetWord)){
                return steps;
            }

            for(int i = 0; i<firstWord.length(); i++){
                char[]arr = firstWord.toCharArray();
                char original = arr[i];
                for(char ch = 'a'; ch<='z'; ch++){
                    arr[i] = ch;
                    String newWord = new String(arr);
                    // System.out.println(newWord+" ");
                    if(words.contains(newWord)){
                        words.remove(newWord);
                        element.add(new String[]{newWord,steps+1+""});
                    }
                }
                arr[i] = original;
            }

        }
        return 0;
    }
    
}