package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NthRootUsingBinarySearch {
    public static void main(String args[]) throws IOException{
        int n; 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of the array: ");
        n = Integer.parseInt(br.readLine());
        int ans = 1;
        System.out.println("Enter the nth value: ");
        int m = Integer.parseInt(br.readLine());
        
        //for searching this type of problem, always check its previous and next element;
        ans = nthRoot(m,n);
        
        System.out.println("The ans is: "+ans);
    }

    public static int nthRoot(int exp, int val){
        int ans = -1;
        int low = 1, high = val;
        while(low<=high){
            int mid = (low+high)/2;
            int temp = mid;
            for(int i = 1; i<exp; i++){
                temp *= mid;
            }
            if(temp == val){
                return mid;
            }
            else if(temp > val){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }

}
