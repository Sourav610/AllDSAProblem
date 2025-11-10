
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ImplementPow {
    public static void main(String []args) throws NumberFormatException, IOException{
        int n,m;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a number: ");
        n = Integer.parseInt(br.readLine());
        System.out.println("Enter the power you want to find: ");
        m = Integer.parseInt(br.readLine());

        double val = calPow(n,m);
        System.out.println("The pow of given number is: "+val);
    }

    public static double calPow(int x, int n){
        if(n == 0)return 1;
        if (n == Integer.MAX_VALUE) return (x == 1) ? 1 : (x == -1) ? -1 : 0;
        if (n == Integer.MIN_VALUE) return (x == 1 || x == -1) ? 1 : 0;
        if(n<0){
            n = Math.abs(n);
            x = 1/x;
        }
        if(n%2 == 0){
            return calPow(x*x,n/2);
        }
        else{
            return x*calPow(x,n-1);
        }
    }
}
