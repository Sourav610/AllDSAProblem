import java.util.Scanner;

public class SquarePattern{
    public static void main(String args[]){
        int n;
        System.out.print("Enter number of rows you want to print: ");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        sc.close();
    }
}