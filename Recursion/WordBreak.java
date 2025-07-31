import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.
 */

class TrieNode{
    boolean isWord;
    Map<Character,TrieNode>children;

    TrieNode(){
        this.children = new HashMap<>();
    }
}

public class WordBreak{
    public static void main(String[] args) throws IOException{
        String str;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a string: ");
        str = br.readLine();

        int n;
        System.out.println("Enter the size of a dict: ");
        n = Integer.parseInt(br.readLine());
        String ele[] = new String[n];
        System.out.println("Enter "+n+" words: ");
        for(int i = 0; i<n; i++){
            ele[i] = br.readLine();
        }

        Boolean result = false;
        // result = checkWord(str,ele);
        // result = checkWordTopDown(str,ele);
        // result = checkWordBottomUp(str,ele);
        // result = checkWordTrieApproach(str,ele);
        result = checkWordWithAnotherDp(str,ele);
        System.out.println("The answer is : "+result);

    }

    public static Boolean checkWord(String str, String[] ele){
        Set<String>wordDict = new HashSet<>();
        for(int i = 0;  i<ele.length; i++){
            wordDict.add(ele[i]);
        }

        Queue<Integer>queue = new LinkedList<>();
        queue.add(0);
        boolean[]seen = new boolean[str.length()+1];

        while(!queue.isEmpty()){
             int start = queue.remove();
            if(start == str.length()){
                return true;
            }

            for(int end = start+1; end <= str.length(); end++){
                if(seen[end]){
                    continue;
                }

                if(wordDict.contains(str.substring(start,end))){
                    queue.add(end);
                    seen[end] = true;
                }
            }
        }
        return false;
    }

    /*Top Down Approach */ 
    /*
     * Time complexity: O(n⋅m⋅k)

        There are n states of dp(i). Because of memoization, we only calculate each state once. To calculate a state, we iterate over m words, and for each word perform some substring operations which costs O(k). Therefore, calculating a state costs O(m⋅k), and we need to calculate O(n) states.

        Space complexity: O(n)

        The data structure we use for memoization and the recursion call stack can use up to O(n) space.
     */
    public static boolean checkWordTopDown(String str, String[]word){
        int memo[] = new int[str.length()];
        Arrays.fill(memo ,-1);

        return checkDp(str.length()-1, memo,str,word);

    }

    public static boolean checkDp(int i,int memo[],String str, String[]word){
        if(i < 0){
            return true;
        }

        if(memo[i] != -1){
            return memo[i] == 1;
        }

        for(String w: word){
            if(i-w.length()+1 < 0){
                continue;
            }

            if(str.substring(i-w.length()+1, i+1).equals(w) && checkDp(i-w.length(),memo,str,word)){
                memo[i] = 1;
                return true;
            }
        }

        memo[i] = 0;
        return false;

    }

    /*Bottom up approach */
    /*
     * TC - O(n*m*k)
     * The logic behind the time complexity is identical to the previous approach. It costs us O(m⋅k) to calculate each state, and we calculate O(n) states in total.
     * 
     * SC - O(n)
     * We use an array dp of length n.
     */
    public static boolean checkWordBottomUp(String str, String[]word){
        boolean[]dp = new boolean[str.length()];
        for(int i = 0; i<str.length(); i++){
            for(String w:word){
                if(i<w.length()-1){
                    continue;
                }

                if(i == w.length()-1 || dp[i-w.length()]){
                    if(str.substring(i-w.length()+1,i+1).equals(w)){
                        dp[i] = true;
                        break;
                    }
                }
            }
        }

        return dp[str.length()-1];
    }

    /*Tri approach */
    /*TC - O(n^2+m*k)
    Building the trie involves iterating over all characters of all words. This costs O(m⋅k).

Once we build the trie, we calculate dp. For each i, we iterate over all the indices after i. We have a basic nested for loop which costs O(n 
2
 ) to handle all dp[i].

     * SC - O(n+m*k)
     * 
     * The dp array takes O(n) space. The trie can have up to m⋅k nodes in it.
     */
    public static boolean checkWordTrieApproach(String s, String[]word){
        TrieNode root = new TrieNode();
        for(String w: word){
            TrieNode curr = root;
            for(char c: w.toCharArray()){
                if(!curr.children.containsKey(c)){
                    curr.children.put(c,new TrieNode());
                }

                curr = curr.children.get(c);
            }
            curr.isWord=true;
        }

        boolean[] dp = new boolean[s.length()];

        for(int i = 0; i<s.length(); i++){
            if(i == 0 || dp[i-1]){
                TrieNode curr = root;
                for(int j = i; j<s.length(); j++){
                    char c = s.charAt(j);
                    if(!curr.children.containsKey(c)){
                        break;
                    }

                    curr = curr.children.get(c);
                    if(curr.isWord){
                        dp[j] = true;
                    }
                }
            }
        }

        return dp[s.length()-1];
    }

    /*Another dp approach */
    public static boolean checkWordWithAnotherDp(String str, String[]words){
        Set<String>st= new HashSet<>(words);
        int n = str.length();
        boolean[]dp = new boolean[n+1];
        dp[0] = true;

        for(int i = 0; i<n; i++){
            for(int j = 0; j<i; j++){
                if(dp[j] && st.contains(str.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }

}