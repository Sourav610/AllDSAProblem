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

        //for lower character only/ or upper character only
        // we can store like - character - 'a' , it will give the value like for 'f'
        //For example, if the given character is ‘f’, we will get the value as (‘f’ - ‘a’) = (102-97) = 5.
        
        //for all type of character;
        int hash[] = new int[256];
        for(int i = 0; i<n; i++){
            hash[arr[i]] += 1;
        }

        System.out.println("Enter any character you want to check: ");
        char c = br.readLine().charAt(0);
        System.out.println("The character count is: "+ hash[c]);

    }
}
