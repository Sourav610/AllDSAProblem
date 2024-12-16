package Hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class lowerCharacterHashing {
    public static void main(String []args) throws IOException{
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of array: ");
        n = Integer.parseInt(br.readLine());

        char []arr = new char [n];
        System.out.println("Enter any character: ");
        for(int i = 0; i<n; i++){
            arr[i] = br.readLine().charAt(0);
        }

        int hash[] = new int[256];
        for(int i = 0; i<n; i++){
            hash[arr[i]] += 1;
        }

        System.out.println("Enter any character you want to check: ");
        char c = br.readLine().charAt(0);
        System.out.println("The character count is: "+ hash[c]);

    }
}
