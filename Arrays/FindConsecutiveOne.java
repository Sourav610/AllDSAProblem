package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindConsecutiveOne {
     public static void main(String args[]) throws IOException{
        int n; 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of the array: ");
        n = Integer.parseInt(br.readLine());

        int arr[] = new int[n];
        System.out.print("Enter "+n+" element of 1 and 0 ");
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int maxVal = 0;
        int count = 0;
        for(int j = 0; j<n; j++){
            if(arr[j] == 1){
                count++;
            }
            else{
                if(count> maxVal){
                    maxVal = count;
                    count = 0;
                }
            }
        }
        
        if(count > maxVal){
            maxVal = count;
        }

        System.out.println("The maximum number of consecutive 1's are: "+maxVal);

    }
}
