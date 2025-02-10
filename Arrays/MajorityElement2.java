package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;


/*
 * Questions:
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 */
public class MajorityElement2 {
    public static void main(String []args) throws IOException{
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of array: ");
        n = Integer.parseInt(br.readLine());

        System.out.println("Enter "+n+" element: ");
        int []arr = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        ArrayList<Integer>ans = new ArrayList<>();
        // ans = findMajor(arr);
        ans = optimizeFindMajor(arr);

        System.out.println("The majority element by n/3 are: ");
        for(int i = 0; i<ans.size(); i++){
            System.out.print(ans.get(i)+" ");
        }

    }

    public static ArrayList<Integer> findMajor(int[]arr){
        HashMap<Integer,Integer>mp = new HashMap<>();
        ArrayList<Integer>ans = new ArrayList<>();
        int range = (int)(arr.length/3) +1;
        for(int i = 0; i<arr.length; i++){
           int val = mp.getOrDefault(arr[i], 0);
           mp.put(arr[i],val+1);

           if(mp.get(arr[i]) == range){
            ans.add(arr[i]);
           }

           if(ans.size() == 2)break; // we are stopping here because we know that n/3 will not give more than two ans from an array of n.
           
        }
        return ans;
    }

    //optimal approach
    /*
     * Optimal Approach (Extended Boyer Moore’s Voting Algorithm): 
Approach: 
    Initialize 4 variables:
    cnt1 & cnt2 –  for tracking the counts of elements
    el1 & el2 – for storing the majority of elements.
    Traverse through the given array.
    If cnt1 is 0 and the current element is not el2 then store the current element of the array as el1 along with increasing the cnt1 value by 1.
    If cnt2 is 0 and the current element is not el1 then store the current element of the array as el2 along with increasing the cnt2 value by 1.
    If the current element and el1 are the same increase the cnt1 by 1.
    If the current element and el2 are the same increase the cnt2 by 1.
    Other than all the above cases: decrease cnt1 and cnt2 by 1.
    The integers present in el1 & el2 should be the result we are expecting. So, using another loop, we will manually check their counts if they are greater than the floor(N/3).
    Intuition: If the array contains the majority of elements, their occurrence must be greater than the floor(N/3). Now, we can say that the count of minority elements and majority elements is equal up to a certain point in the array. So when we traverse through the array we try to keep track of the counts of elements and the elements themselves for which we are tracking the counts. 

    After traversing the whole array, we will check the elements stored in the variables. Then we need to check if the stored elements are the majority elements or not by manually checking their counts.
     */

     public static ArrayList<Integer> optimizeFindMajor(int[]arr){
        int cnt1 = 0, cnt2 = 0, ele1 = 0, ele2 = 0;

        for(int i = 0; i<arr.length; i++){
            if(cnt1 == 0 && ele2 != arr[i]){
                ele1 = arr[i];
                cnt1 = 1;
            }
            else if(cnt2 == 0 && ele1 != arr[i]){
                ele2 = arr[i];
                cnt2 = 1;
            }
            else if(ele1 == arr[i]){
                cnt1++;
            }
            else if(ele2 == arr[i]){
                cnt2++;
            }
            else{
                cnt1--;
                cnt2--;
            }
        }

        cnt1 = 0;
         cnt2 = 0;
        System.out.println("ele1: "+ele1+" ele2: "+ele2);
        for(int i = 0; i<arr.length; i++){
            if(ele1 == arr[i])cnt1++;
            if(ele2 == arr[i])cnt2++;
        }
        int mini = (int)(arr.length/3) +1;
        ArrayList<Integer>ans = new ArrayList<>();
        if(cnt1 >= mini)ans.add(ele1);
        if(cnt2 >= mini)ans.add(ele2);

        
        return ans;
     }
}
