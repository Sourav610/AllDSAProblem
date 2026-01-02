package SlidingWindowAndTwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinimumWindowSubsequence {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter first large string: ");
        String s = br.readLine();
        System.out.println("Enter second small string: ");
        String t = br.readLine();

        String ans;
        // ans = calculateMinWindowSubsequenceBruteForce(s,t);
        // ans = calculateMinWindowSubsequenceOptimize(s, t);
        ans = minWindow(s,t);
        System.out.println("The minimum window substring is: "+ans);
    }

    public static String calculateMinWindowSubsequenceBruteForce(String sub1, String sub2){
        int minLen = Integer.MAX_VALUE;
        String ans="";
        for(int i = 0; i<sub1.length(); i++){
            String str="";
            for(int j = i; j<sub1.length(); j++){
                str += sub1.charAt(j);
                if(isSubsequence(str,sub2)){
                    if(str.length() < minLen){
                        minLen = str.length();
                        ans = str;
                    }
                    break;
                }

            }
        }
        return ans;
    }

    //T.c - O(n*n)
    // S.c - O(1)

    public static String calculateMinWindowSubsequenceOptimize(String sub1, String sub2){
        int minLen = Integer.MAX_VALUE;
        String ans = "";
        String result = "";
        int j = 0;
        for(int i = 0; i<sub1.length(); i++){
            result = sub1.substring(j, i+1);
            while(isSubsequence(result, sub2) && j<= i){
                if(result.length() <  minLen){
                    minLen = result.length();
                    ans = result;
                }
                j++;
                result = sub1.substring(j,i+1);
            }
        }
        return ans;
    }

    public static String minWindow(String sub1, String sub2){
        int n= sub1.length();
        int m = sub2.length();
        String ans = "";
        int minLen = Integer.MAX_VALUE;

        for(int i = 0; i<n; i++){
            if(sub1.charAt(i) == sub2.charAt(0)){
                int p1 = i, p2 = 0;
                while(p1 < n && p2 < m){
                    if(sub1.charAt(p1) == sub2.charAt(p2)){
                        p2++;
                    }
                    p1++;
                }

                if(p2 == m){
                    int end = p1-1;
                    p2 = m-1;


                    while(end >= i){
                        if(sub1.charAt(end) == sub2.charAt(p2)){
                            p2--;
                        }
                        if(p2 < 0){
                            break;
                        }
                        end--;
                    }

                    int start  = end;
                    int len = p1 -start;
                    if(len < minLen){
                        minLen = len;
                        ans = sub1.substring(start,start+len);
                    }
                }
            }
        }
        return ans;
    }

    /*
    [Expected Approach] Preprocessing with Next Occurrence Table - O(n × m) Time and O(n) Time
The idea is to preprocess s1 so we can quickly jump to the next occurrence of any character, instead of scanning it repeatedly.
We create a nextPos table where nextPos[i][ch] stores the index of the next occurrence of character ch after position i in s1. 
This table is filled by traversing s1 from right to left.
Then, for each possible starting position in s1 that matches the first character of s2, we try to match all characters of s2 by
 repeatedly jumping through the nextPos table.
If we successfully match all of s2, we track the minimal window length and update the answer.

Step by Step Approach:

Build nextPos table where nextPos[i][c] stores the next occurrence of character c in s1 at or after index i.
Fill nextPos from right to left so each position knows where each letter appears next.
For each index in s1 matching the first character of s2, try to match s2 by jumping using nextPos.
If a complete match is found, record the window and update the smallest one found so far.
Return the smallest window substring containing s2 as a subsequence.




    */

    public static String minWindowExpected(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        // nextPos[i][ch] : next occurrence of character
        // ch after index i in s1
        int[][] nextPos = new int[n + 2][26];
        for (int c = 0; c < 26; c++) {
            nextPos[n][c] = -1; // initialize last row with -1
        }

        // fill table by going backwards through s1
        for (int i = n - 1; i >= 0; i--) {
            for (int c = 0; c < 26; c++) {
                nextPos[i][c] = nextPos[i + 1][c];
            }
            nextPos[i][s1.charAt(i) - 'a'] = i;
        }

        String ans = "";
        int minLen = Integer.MAX_VALUE;

        // try starting at each position in s1
        for (int start = 0; start < n; start++) {
            if (s1.charAt(start) != s2.charAt(0)) continue;

            int idx = start;
            boolean ok = true;

            // match s2 by jumping through nextPos
            for (int j = 0; j < m; j++) {
                if (idx == -1) {
                    ok = false;
                    break;
                }
                idx = nextPos[idx][s2.charAt(j) - 'a'];
                if (idx == -1) {
                    ok = false;
                    break;
                }
                // move to next index for next char
                idx++; 
            }

            if (ok) {
                int endIdx = idx - 1;
                int len = endIdx - start + 1;
                if (len < minLen) {
                    minLen = len;
                    ans = s1.substring(start, start + len);
                }
            }
        }

        return ans;
    }
    

    public static boolean isSubsequence(String str1, String str2){
        int i = 0, j = 0;
        while(i<str1.length() && j < str2.length()){
            if(str1.charAt(i) == str2.charAt(j)){
                j++;
            }
            i++;
        } 
        return j == str2.length();
    }
}
