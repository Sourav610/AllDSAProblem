package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class RearrangeArrayElementBySign{
    public static void main(String[]args)throws IOException{
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of array: ");
        n = Integer.parseInt(br.readLine());

        System.out.println("Enter "+n+" element: ");
        int []arr = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        // RearrangeElement(arr);
        int [] ans = OptimizedRearrangeElement(arr);

        System.out.println("Element after rearranging: ");
        for(int i = 0; i<n; i++){
            System.out.println(ans[i]);
        }
    }

    public static void RearrangeElement(int[]arr){
        ArrayList<Integer>neg = new ArrayList<>();
        ArrayList<Integer>pos = new ArrayList<>();

        for(int i = 0; i<arr.length; i++){
            if(arr[i] > 0){
                pos.add(arr[i]);
            }
            else{
                neg.add(arr[i]);
            }
        }
        int k = 0, l = 0;
        for(int i = 0; i<arr.length; i++){
            if(i%2 == 0){
                arr[i] = pos.get(k);
                k++;
            }
            else{
                arr[i] = neg.get(l);
                l++;
            }
        }
    }

    public static int[] OptimizedRearrangeElement(int []arr){
        int posInd = 0, negInd = 1;
        int ans[] = new int[arr.length];
        for(int i = 0; i<arr.length; i++){
            if(arr[i] > 0){
                ans[posInd] = arr[i];
                posInd += 2;
            }
            else{
                ans[negInd] = arr[i];
                negInd += 2;
            }
        }

        return ans;
    }

}