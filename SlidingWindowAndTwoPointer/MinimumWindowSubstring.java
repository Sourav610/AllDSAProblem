package SlidingWindowAndTwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*
Given two strings s and t of lengths m and n respectively, return the minimum window
 substring of s such that every character in t (including duplicates) is included in the window. 
 If there is no such substring, return the empty string "".
*/
public class MinimumWindowSubstring {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter first large string: ");
        String s = br.readLine();
        System.out.println("Enter second small string: ");
        String t = br.readLine();

        String ans;
        ans = calculateMinWindowSubstringBruteForce(s,t);
        // ans = calculateMInWindowSubStringOptimize(s, t);
        System.out.println("The minimum window substring is: "+ans);
    }

    public static String calculateMinWindowSubstringBruteForce(String s,String t){
        int minVal = Integer.MAX_VALUE;
        int startInd = 0;
        for(int i = 0; i<s.length(); i++){
            Map<Character, Integer> mp = new HashMap<>(256);
            int count = 0;
            for(int k = 0; k<t.length(); k++){
                mp.put(t.charAt(k), mp.getOrDefault(t.charAt(k), 0)+1);
            }
            for(int j = i; j<s.length(); j++){
                if(mp.getOrDefault(s.charAt(j),0) > 0){
                    count++;
                    mp.put(s.charAt(j), mp.getOrDefault(s.charAt(j),0)-1);
                }
                if(count == t.length()){
                    int len = j-i+1;
                    if(len < minVal){
                        minVal = len;
                        startInd = i;
                        break;
                    }
                }
            }
        }
        if(minVal == Integer.MAX_VALUE){
            return "";
        }
        return s.substring(startInd, startInd+minVal);
    }

    public static String calculateMInWindowSubStringOptimize(String s, String t){
        int minVal = Integer.MAX_VALUE;
        int startInd = 0;
        Map<Character, Integer> mp = new HashMap<>(256);
        int count = 0;
        for(int k = 0; k<t.length(); k++){
            mp.put(t.charAt(k), mp.getOrDefault(t.charAt(k), 0)+1);
        }
        int j = 0;
        for(int i = 0; i<s.length(); i++){
            if(mp.getOrDefault(s.charAt(i),0) > 0){
                count++;
            }
            mp.put(s.charAt(i), mp.getOrDefault(s.charAt(i),0)-1);
            while(count == t.length()){
                int len = i-j+1;
                if(len < minVal){
                    minVal = len;
                    startInd = j;
                }
                mp.put(s.charAt(j), mp.getOrDefault(s.charAt(j),0)+1);
                if(mp.getOrDefault(s.charAt(j),0) > 0){
                    count--;
                }
                j++;
            }
        }
        if(minVal == Integer.MAX_VALUE){
            return "";
        }
        return s.substring(startInd, startInd+minVal);
    }
}
