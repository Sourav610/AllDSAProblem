
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ReverseAGivenArray {
    public static void main(String []args) throws IOException{
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the size of an array: ");
        n = Integer.parseInt(br.readLine());
        Scanner sc = new Scanner(System.in);
        int []arr = new int[n];
        System.out.print("Enter the element: ");
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(sc.nextLine());
        }
        int []ans = new int[n];
        // ReverseArray(arr,ans,0);
        
       //using two pointer approach
        OptimizeReverseArray(arr, 0, arr.length-1);
        for(int i = 0; i<n; i++){
            System.out.print(arr[i]+" ");
        }

        
    }

    public static void ReverseArray(int [] arr,int []ans, int i){
        if(i == arr.length){
            return;
        }
        ans[arr.length-i-1] = arr[i];
        ReverseArray(arr, ans, i+1);
    }

    public static void OptimizeReverseArray(int []arr, int start, int end){
        if(start < end){
            int temp = arr[end];
            arr[end]  = arr[start];
            arr[start] = temp;
            OptimizeReverseArray(arr, start+1, end-1);
        }
    }
}
