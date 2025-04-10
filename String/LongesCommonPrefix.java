package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongesCommonPrefix {
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of arr: ");
        int n = Integer.parseInt(br.readLine());
        String arr[] = new String[n];
        System.out.println("Enter the value of "+n+" string: ");
        for(int i = 0; i<n; i++){
            arr[i] = br.readLine();
        }
        String ans;
        // ans = findCommonPrefix(arr);
        ans  = optimizeFindCommonPrefix(arr);
        System.out.println("The string after removing outermost parenthesis is: "+ans);
        
    }

    public static String findCommonPrefix(String[]arr){
        if(arr.length == 0)return "";
        for(int i = 0; i<arr.length; i++){
            char ch = arr[i].charAt(i);
            for(int j = 1; j<arr.length; j++){
               if(i == arr[j].length() || arr[j].charAt(i) != ch){
                return arr[0].substring(0,i);
               }
               
            }
        }
        return arr[0];
    }

    public static String optimizeFindCommonPrefix(String[]arr){
        int minLen = Integer.MAX_VALUE;
        for(int i = 0; i<arr.length; i++){
            if(arr[i].length() < minLen){
                minLen = arr[i].length();
            }
        }

        int low = 0;
        int high = minLen;
        while(low<= high){
            int mid = (low+high)/2;
            if(isCommonPrefix(arr,mid)){
                low = mid+1;
            }
            else{
                high  = mid-1;
            }
        }

        return arr[0].substring(0,(low+high)/2);
    }

    public static boolean isCommonPrefix(String[]arr, int len){
        String str1 = arr[0].substring(0,len);
        for(int i = 1; i<arr.length; i++){
            if(!arr[i].startsWith(str1)){
                return false;
            }
        }
        return true;
    }
}
