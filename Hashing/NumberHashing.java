package Hashing;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberHashing {
    public static void main(String []args) throws IOException{
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of array: ");
        n = Integer.parseInt(br.readLine());
        System.out.print("Enter the element: ");
        int arr[] = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int ele = -1;
        for(int i = 0; i<n; i++){
            if(arr[i] > ele){
                ele = arr[i];
            }
        }

        int hash[] = new int[ele+1];
        for(int i = 0; i<n; i++){
            hash[arr[i]] +=1;
        }

        System.out.print("Enter the element you want to check: ");
        int k = Integer.parseInt(br.readLine());
        if(k> ele){
            System.out.println("the element is not present");
        }
        System.out.println("The number of times the element occur is: "+hash[k]);

    }
}
