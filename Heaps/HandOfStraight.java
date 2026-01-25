package Heaps;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;


/*

Alice has some number of cards and she wants to rearrange the cards into groups so that each group is
 of size groupSize, and consists of groupSize consecutive cards.

Given an integer array hand where hand[i] is the value written on the ith card and an integer
 groupSize, return true if she can rearrange the cards, or false otherwise.
 */
public class HandOfStraight {
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n,k;
        System.out.println("Enter the size of arr: ");
        n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        System.out.println("Enter "+n+" element: ");
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.println("Enter the value of k: ");
        k = Integer.parseInt(br.readLine());

        boolean ans = false;
        ans = checkHand(arr,k);
        System.out.println("The ans is: "+ans);
    }

    /*
    
    To determine whether a hand of cards can be rearranged into groups of size `groupSize`,
     we can sort the cards and always try to build a group starting from the smallest available card.
      We greedily check if the next `groupSize - 1` consecutive cards exist and reduce their count.
       A `TreeMap` (in C++ or Java) or a sorted map can help maintain keys in sorted order while efficiently
        accessing and updating the card counts.

    Check if total number of cards is divisible by groupSize; if not, return false.
    Store the frequency of each card in a sorted data structure.
    Iterate over the sorted keys (card values) from smallest to largest.
    For each key, try to form a group of groupSize starting from that key.
    If there are not enough cards to build a group, return false.
    Decrement the counts for each card used in the group.
    If all groups are successfully formed, return true.
*/

    public static boolean checkHand(int[]arr, int groupSize){
        if(arr.length%groupSize != 0) return false;
        TreeMap<Integer,Integer>mp = new TreeMap<>();
        for(int i= 0; i<arr.length; i++){
            mp.put(arr[i],mp.getOrDefault(arr[i], 0)+1);
        }

        while(!mp.isEmpty()){
            int val = mp.firstKey();
            int count= mp.get(val);
            for(int j = 0; j<groupSize; j++){
                int k = val+j;
                if(!mp.containsKey(k) || mp.get(k) < count){
                    return false;
                }
                if(mp.get(k) == count){
                    mp.remove(k);
                }
                else{
                    mp.put(k,mp.get(k)-count);
                }
            }
        }
        return true;
    }
}
