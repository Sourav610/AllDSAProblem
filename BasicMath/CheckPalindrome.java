package BasicMath;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CheckPalindrome {
    public static void main(String []args) throws IOException{
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter any number: ");
        n = Integer.parseInt(br.readLine());

        checkPalindrome(n);
    }

    public static void checkPalindrome(int n){
        int ans = n;
        int res = 0;
        while(n != 0){
            int val = n%10;
            res = res*10 + val;
            n = n/10;
        }

        if(ans == res){
            System.out.println("Palindrome number");
        }
        else{
            System.out.println("Not palindrome number");
        }
    }
}
