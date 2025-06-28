import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CombinationSum {
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
        
        ArrayList<ArrayList<Integer>>ans = new ArrayList<>();
        ArrayList<Integer>temp = new ArrayList<>();
        calCombination(0,arr,k,temp,ans,0);
        for(ArrayList<Integer> i: ans){
            System.out.println("The subsequenc present in arr is "+i);
        }
    }

    public static void calCombination(int i, int[]arr,int target, ArrayList<Integer>temp,ArrayList<ArrayList<Integer>>ans,int sum){
        if(i == arr.length || sum >= target){
            if(sum == target){
                ans.add(new ArrayList<>(temp));
            }
            return;
        }

        sum += arr[i];
        temp.add(arr[i]);
        calCombination(i,arr,target, temp,ans,sum);
        sum -= arr[i];
        temp.removeLast();
        calCombination(i+1,arr,target,temp,ans,sum);

    }
}
