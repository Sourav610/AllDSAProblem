package Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class printNTimesUsingRecursion {
    public static void main(String []args) throws IOException{
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter number of times you want to print your number: ");
        n = Integer.parseInt(br.readLine());
        System.out.print("Enter your name: ");
        String name = br.readLine();

        printNTimes(1,n, name);
    }

    public static void printNTimes(int start, int end,String name){
        if(start > end){
            return;
        }
        System.out.println(name);
        start++;
        printNTimes(start, end, name);
    }
}
