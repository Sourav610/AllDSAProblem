
/*
 * Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.
 * 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PalindromePartition {
    public static void main(String[]args) throws IOException{
        String n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a size: ");
        n = br.readLine();
        
        ArrayList<ArrayList<String>>ans = new ArrayList<>();
        ArrayList<String>temp = new ArrayList<>();
        calPartition(0, temp, ans, n);
        for(ArrayList<String> i: ans){
            System.out.println("The subsequenc present in arr is "+i);
        }
    }

    public static void calPartition(int i, ArrayList<String>temp, ArrayList<ArrayList<String>>ans,String val){
        if(i == val.length()){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int ind = i; ind<val.length(); ind++){
            if(checkPalindrome(val,i,ind)){
                temp.add(val.substring(i, ind+1));
                calPartition(ind+1, temp, ans, val);
                temp.remove(temp.size()-1);
            }
        }
    }

    public static boolean checkPalindrome(String target, int start, int end){
        while(start<end){
            if(target.charAt(start) != target.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
