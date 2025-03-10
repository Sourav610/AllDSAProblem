package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SquareRootUsingBinarySearch {
    public static void main(String args[]) throws IOException{
        int n; 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of the array: ");
        n = Integer.parseInt(br.readLine());
        int ans = 1;
        
        //for searching this type of problem, always check its previous and next element;
        int low = 1, high = n;
        while(low<=high){
            int mid = (low+high)/2;
            if(mid*mid <= n){
                ans = mid;
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        
        System.out.println("The ans is: "+ans);
    }
}
