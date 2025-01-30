package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class LeadersInArray {
     public static void main(String []args) throws IOException{
        int n; 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of the array: ");
        n = Integer.parseInt(br.readLine());

        int arr[] = new int[n];
        System.out.print("Enter "+n+" element: ");
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int []ans = Leader(arr);
        System.out.println("The leaders are: ");
        for(int i = 0; i<ans.length; i++){
            System.out.print(ans[i]+" ");
        }
    }

    public static int[] Leader(int []arr){
        int i = arr.length-2;
        ArrayList<Integer>ans = new ArrayList<>();
        int maxVal = arr[i+1];
        ans.add(arr[i+1]);

        while(i>= 0){
            if(arr[i] >= maxVal){
                maxVal = arr[i];
                ans.add(arr[i]);
            }
            i--;
        }
        int []val = ans.stream().mapToInt(k ->k).toArray();
        return val;
    }
}
