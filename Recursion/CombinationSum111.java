
/*
 * Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

Only numbers 1 through 9 are used.
Each number is used at most once.
Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CombinationSum111 {
     public static void main(String[]args) throws IOException{
        int n,k;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a size: ");
        n = Integer.parseInt(br.readLine());

        System.out.println("Enter a target: ");
        k = Integer.parseInt(br.readLine());
        
        ArrayList<ArrayList<Integer>>ans = new ArrayList<>();
        ArrayList<Integer>temp = new ArrayList<>();
        // calCombination(0,k,temp,ans,0,n);
        calCombination2(0, k, temp, ans, 0, n);
        for(ArrayList<Integer> i: ans){
            System.out.println("The subsequenc present in arr is "+i);
        }
    }

    public static void calCombination(int i,int target, ArrayList<Integer>temp,ArrayList<ArrayList<Integer>>ans,int sum,int length){
        if(i > 9){
            if(temp.size() == length && sum == target){
                ans.add(new ArrayList<>(temp));
            }
            return;
        }

        sum += i+1;
        temp.add(i+1);
        calCombination(i+1,target, temp,ans,sum,length);
        sum -= i+1;
        temp.removeLast();
        calCombination(i+1,target,temp,ans,sum,length);

    }

    public static void calCombination2(int i,int target, ArrayList<Integer>temp,ArrayList<ArrayList<Integer>>ans,int sum,int length){
        if(length == temp.size()){
            if(sum == target){
                ans.add(new ArrayList<>(temp));
            }
            return;
        }

        for(int ind = i; ind < 9; ind++){
            if(sum > target)return;
            temp.add(ind+1);
            calCombination2(ind+1,target,temp,ans,sum+ind+1,length);
            temp.remove(temp.size()-1);
        }
    }
}
