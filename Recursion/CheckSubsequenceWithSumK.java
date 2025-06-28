import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CheckSubsequenceWithSumK{
    public static void main(String[]args) throws IOException{
        int n,k;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a size: ");
        n = Integer.parseInt(br.readLine());

        int arr[] = new int[n];
        System.out.println("Enter "+n+" element: ");
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        System.out.println("Enter a target: ");
        k = Integer.parseInt(br.readLine());

        boolean res = checkSubsequence(0,arr,k,0);
        System.out.println("The subsequenc present in arr is "+res);
    }

    public static boolean checkSubsequence(int i, int[]arr, int k, int s){
        if(i == arr.length || s > k){ /* sum > target will not go more recursion so little optimize */
            if(s == k){
                return true;
            }
            return false;
        }

        s += arr[i];
        if(checkSubsequence(i+1, arr, k, s))return true;
        s -= arr[i];
        if(checkSubsequence(i+1, arr, k, s))return true;
        return false;
    }
}