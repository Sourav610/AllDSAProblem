package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RotateString {
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the value of 2 string: ");
        String st = br.readLine();
        String t = br.readLine();

        boolean ans;
        // ans = checkRotateString(st,t);
        // ans = optimizedRotateString(st,t);
        ans = usingKMPAlgorithm(st,t);
        
        System.out.println("The string isomorphic status : "+ans);
        
    }
    public static boolean checkRotateString(String str1, String str2){
        if(str1.length() != str2.length()){
            return false;
        }
        char[]sChar = str1.toCharArray();
        int length = str1.length();
        for(int i = 0; i<length; i++){
            sChar = rotateOnce(sChar);
            if(new String(sChar).equals(str2)){
                return true;
            }
        }

        return false;
    }

    //arrayCopy method - 
        //public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
        /*
         * src − This is the source array.

srcPos − This is the starting position in the source array.

dest − This is the destination array.

destPos − This is the starting position in the destination data.

length − This is the number of array elements to be copied.
         */
    public static char[] rotateOnce(char[]arr){
        char firstChar = arr[0];
        System.arraycopy(arr, 1, arr, 0,arr.length-1);
        arr[arr.length-1] = firstChar;
        return arr;
    }

    public static boolean optimizedRotateString(String str1, String str2){
        String temp = str1+str1;
        if(str1.length() != str2.length())return false;
        return temp.contains(str2);
    }


    /*
     * Check if the lengths of strings s and goal are different:

If they are, return false (they can't be rotations).
Concatenate s with itself to create doubledString, which contains all possible rotations of s.

Call the kmpSearch function to check if goal is a substring of doubledString.

In the kmpSearch function:

Precompute the LPS (Longest Prefix Suffix) array for the pattern (which is goal).

Initialize indices textIndex and patternIndex to track positions in text and pattern, respectively.

Loop through text:

If the characters at text[textIndex] and pattern[patternIndex] match:
Increment both indices.
If patternIndex equals the length of the pattern, return true (the pattern has been found).
If there's a mismatch after some matches:
Use the LPS array to update patternIndex to skip unnecessary comparisons.
If there are no matches:
Move textIndex to the next character.
If the loop finishes without finding the pattern, return false.

In the computeLPS function:

Initialize the LPS array with zeros.

Build the LPS array to store the lengths of the longest prefix that is also a suffix for each position in the pattern:

While the index is less than the length of the pattern:
If characters match, increment the length and set the corresponding LPS value.
If there's a mismatch, update the length using the previous LPS value.
If there's no match and the length is zero, set the LPS value to zero.
Return the constructed LPS array.
     */


     /*
      * We can refine the substring search using the Knuth-Morris-Pratt (KMP) algorithm. This follows the same intuition as the concatenation approach but improves how we search for goal within the concatenated string s + s.

The KMP algorithm allows us to search for substrings in linear time by preprocessing the pattern (in this case, goal) to identify where matches might fail early. The idea is to avoid rechecking characters we’ve already confirmed don’t match.

First, we preprocess goal to create the longest prefix suffix (LPS) array. The LPS array stores the lengths of the longest proper prefix of the substring that matches a proper suffix for every prefix of goal. For example, if a mismatch occurs after matching a certain number of characters, the LPS array tells us how many characters we can skip and where to resume checking in the pattern. This way we don't need to start from the beginning of goal each time a mismatch happens.

Once the LPS array is ready, we scan through the concatenated string s + s and use the LPS array to efficiently find the goal. As we iterate through s + s, we compare characters from goal against the characters of the concatenated string. If we find a match, we continue comparing; however, if a mismatch occurs, we use the value from the LPS array to determine the next position in goal to check.
      */
     public static boolean usingKMPAlgorithm(String str1, String str2){
        if(str1.length() != str2.length())return false;
        String doubledString = str1+str1;

        return KmpSearch(doubledString,str2);
     }

    private static boolean KmpSearch(String text, String pattern){
        int[] lps = computeLPS(pattern);
        int textIndex = 0, patternIndex = 0;
        int textLength = text.length(), patternLength = pattern.length();


        while(textIndex < textLength){
            if(text.charAt(textIndex) == pattern.charAt(patternIndex)){
                textIndex++;
                patternIndex++;
                 // If we've matched the entire pattern, return true
                if(patternIndex == patternLength) return true;
            }
             // If there's a mismatch after some matches, use the LPS array to skip unnecessary comparisons
            else if(patternIndex > 0){
                patternIndex = lps[patternIndex-1];
            }
            // If no matches, move to the next character in text
            else{
                textIndex++;
            }
        }
        return false;
    }

    public static int[] computeLPS(String pattern){
        int patternLength = pattern.length();
        int[]lps = new int[patternLength];
        int length = 0, index = 1;

        while(index < patternLength){
            // If characters match, increment length and set lps value
            if(pattern.charAt(index) == pattern.charAt(length)){
                length++;
                lps[index++] = length;
            }
            // If there's a mismatch, update length using the previous LPS value
            else if (length > 0) {
                length = lps[length - 1];
            }
            // No match and length is zero
            else {
                lps[index++] = 0;
            }
        }
        return lps;
    }

}
