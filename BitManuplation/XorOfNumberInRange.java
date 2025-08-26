import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Given two integers L and R. Find the XOR of the elements in the range [L , R].
 */
public class XorOfNumberInRange {
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Start and end Number: ");
        int start = Integer.parseInt(br.readLine());
        int end = Integer.parseInt(br.readLine());

        //Brute force approach
        //T.C - O(end-start+1), S.C - O(1)
        int ans = 0;
        for(int i = start; i<= end; i++){
            ans ^= i;
        }

        ans = solveXor(start,end);

        System.out.println("The ans is : "+ans);
    }

    /*
     * intiuation:
     * N = 1         xor till 2= 1
     * N = 2         xor till 2= 3
     * N = 3         xor till 3 = 0
     * N = 4         xor till 4 = 4
     * N= 5          xor till 5  = 1
     * N = 6         xor till 6 = 7
     * N = 7         xor till 7 = 0
     * N = 8         xor till 8 = 8
     * N = 9         xor till 9 = 1
     * 
     * for this we got 
     * N%4 == 1  ans = 1
     * N%4 == 2 ans = N+1;
     * N%4 == 3 ans = 0
     * N%4 == 0 ans = N
     * we are taking module with 4 because at every 4th step we got same value as of N 
     * This work when the question asking xor till last element and no first element is given
     * 
     * if start number is given it will be fail so for this below approcha we will use:
     * 
     * 
     * first we will calculate from 1 to start and 1 to end then we will take the xor of two result
     * then we will get the final as shown below.
     * 
     * start = 3  so 1 - (3-1) = 1^2        - res1
     * end =  7   so 1-7 = 1^2^3^4^5^6^7  -res2
     * res1^res2 == 3^4^5^6^7 will be result
     * 
     * 
     */
    public static int findXor(int end){
        if(end%4 == 1) return 1;
        else if(end%4 == 2) return end+1;
        else if(end%4 == 3) return 0;
        else return end;
    }

    public static int solveXor(int start,int end){
        int res1 = findXor(start-1);
        int res2 = findXor(end);
        return res1^res2;
    }
    
}
