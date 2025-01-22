package Arrays;
import java.io.*;
import java.util.HashMap;
import java.util.Map;


public class MajorityElement {
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
        int res = -1;
        //using hashing
        // res= findMajorElement(arr);
        

        //using moore's algorithm  - if array contains majority element
        /*
         * Initialize 2 variables:
            Count –  for tracking the count of element
            Element – for which element we are counting
            Traverse through the given array.
            If Count is 0 then store the current element of the array as Element.
            If the current element and Element are the same increase the Count by 1.
            If they are different decrease the Count by 1.

            if it is not confirm that array contains majority element again we need to traverse one more and check
            the element we got is the major one or not. 
         */
        res = major(arr);
        
        System.out.println("The majority element is: "+res);


    }

    public static int major(int []arr){
        int count = 0, element = 0;

        for(int i = 0; i< arr.length; i++){
            if(count == 0){
                count++;
                element = arr[i];
            }
            else if(element == arr[i]){
                count++;
            }
            else{
                count--;
            }
        }

        int cnt = 0;
        for(int i = 0; i<arr.length; i++){
            if(element == arr[i]){
                cnt++;
            }
        }

        if(cnt > (arr.length/2)){
            return element;
        }

        return -1;
    }

    public static int findMajorElement(int []arr){
        int n= arr.length/2;
        HashMap<Integer,Integer>mp = new HashMap<>();
        for(int i = 0; i< arr.length; i++){
            int val = mp.getOrDefault(arr[i], 0);
            mp.put(arr[i], val+1);
        }
        

        for(Map.Entry<Integer,Integer> val : mp.entrySet()){
            if(val.getValue() > n){
                return val.getKey();    
            }
        }

        return -1;
    }
}
