package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SubstringWithKDistinct{
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the value of string: ");
        String st = br.readLine();

        System.out.println("Enter the key: ");
        int k = Integer.parseInt(br.readLine());
        int ans;
        ans = findSubstring(st,k);

        System.out.println("The length of substring is:"+ans);
    }

    //using sliding window technique to find atMostKcharacter sub string


    /*
     * To find the count of substrings with exactly k distinct characters, call the atMostK functions, first as atMostK(s, k) and second atMostK(s, k-1) and substract the answer return by fist function call with the answer of second function call and return it as our final answer.
Lets see what does atMostK function does
If k is less than 0 then we return 0.
Initialize variables i and j to represent the window boundaries, cnt to 0 (to count distinct characters), and res to 0 (to store the result).
Initialize an array m of size 26 to keep track of character frequencies.
Iterate through the string s from left to right using the j pointer.
Increment the frequency of the character s[j] in the m array.
If the frequency becomes 1 (indicating a new distinct character), increment cnt.
Check if cnt exceeds k. If so, move the i pointer to the right and decrement the frequency of s[i] in the m array. If the frequency becomes 0, decrement cnt.
Add (j - i + 1) to res for each valid window.
Increment the j pointer to extend the window.
Return res as the count of substrings with at most k distinct characters.
     */
    public static int findSubstring(String s, int k){
        return atMostK(s,k)-atMostK(s,k-1);
    }

    public static int atMostK(String s, int k){
        if(k<0){
            return 0;
        }

        int i = 0, j = 0, count = 0, res = 0;
        int[]arr = new int[26];
        while(j<s.length()){
            arr[s.charAt(j) - 'a']++;
            if(arr[s.charAt(j) - 'a'] == 1){
                count++;
            }

            while(count > k){
                arr[s.charAt(i) - 'a']--;
                if(arr[s.charAt(i) -'a'] == 0){
                    count--;
                }
                i++;
            }

            res += (j-i+1);
            j++;

        }
        return res;
    }
}