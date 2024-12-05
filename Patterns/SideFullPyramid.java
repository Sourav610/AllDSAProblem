
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class SideFullPyramid {
    public static void main(String []args) throws IOException{
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter no of rows you want to print: ");
        n = Integer.parseInt(br.readLine());


        // for(int i = 0; i<n; i++){
        //     for(int j = 0; j<= i; j++){
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }

        // for(int i = 0; i<n-1; i++){
        //     for(int j = n-i-1; j> 0; j--){
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }

        //Optimize approach
        doPattern(n);

    }
    public static void doPattern(int size){
        for(int i = 1; i<2*size; i++){
            int stars = i;
            if(i>size){
                stars = 2*size - i;
            }
    
            for(int j = 0; j<stars; j++){
                System.out.print("*");
            }
            System.out.println();
    
        }
    }
}
