package Recursion;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CheckPalindrome {
    public static void main(String []args) throws IOException{
        String str;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter any character: ");
        str = br.readLine();

        // System.out.print(palindrome(str));

        char []arr = str.toCharArray();
        String ans = withRecursionPalindrome(arr, 0, arr.length-1);
        if(ans.equals(str)){
            System.out.println("Palindrome");
        }
        else{
            System.out.println("Not Palindrome");
        }
    }

    public static String palindrome(String str){
        String original = str;
        // System.out.println("The original string is: "+original);
        char []arr = str.toCharArray();
        int i = 0, j = arr.length-1;
        // System.out.println("The char array is : "+arr[0]+" "+arr.toString());
        while(i<j){
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] =temp;
            i++;
            j--;
        }
        // System.out.println("The string is: "+arr[0]+" "+String.valueOf(arr));
        String ans = String.valueOf(arr);
        if(original.equals(ans)){
            return "Palindrome";
        }
        return "Not Palindrome";
    }

    public static String withRecursionPalindrome(char []arr, int start, int end){
        if(start < end){
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            return withRecursionPalindrome(arr, start+1, end-1);
        }
        return String.valueOf(arr);
    }
}
