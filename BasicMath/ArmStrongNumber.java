package BasicMath;
import java.io.*;

public class ArmStrongNumber {
    public static void main(String []args) throws IOException{
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter any number for checking armstrong: ");
        n = Integer.parseInt(br.readLine());

        int noOfDigit = CalculateDigit(n);

        System.out.println(checkArmstrong(noOfDigit, n));

    }

    public static int CalculateDigit(int n){
        int count = 0;
        while(n!= 0){
            count ++;
            n /= 10;
        }
        return count;
    }

    public static boolean checkArmstrong(int noOfDigit, int number){
        int res = number;
        int sum = 0;
        while(number != 0){
            int x = number%10;
            sum += Math.pow(x,noOfDigit);
            number /= 10;
        }
        if(sum == res){
            return true;
        }
        return false;
    }
}
