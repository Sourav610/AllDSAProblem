package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSumProblem {
    public static void main(String[]args) throws IOException{
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of an array: ");
        n = Integer.parseInt(br.readLine());
        
        int arr[] = new int[n];
        System.out.println("Enter "+n+" element: ");
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.println("Enter a target value: ");
        int target = Integer.parseInt(br.readLine());
        List<List<Integer>>ans = new ArrayList<>();
        // ans = findQuadruple(arr,target);
        // ans = findSecondOptimizeQuadruple(arr,target);
        ans = findQuadrupleOptimalApproach(arr,target);

        for (List<Integer> it : ans) {
            System.out.print("[");
            for (Integer i : it) {
                System.out.print(i + " ");
            }
            System.out.print("] ");
        }
        System.out.println();
    }

    public static List<List<Integer>> findQuadruple(int []arr,int target){
        Set<List<Integer>>st = new HashSet<>();
        for(int i = 0; i<arr.length; i++){
            for(int j = i+1; j<arr.length; j++){
                for(int k = j+1; j<arr.length; j++){
                    for(int l = k+1; l<arr.length; l++){
                        long sum = arr[i]+arr[j]+arr[k]+arr[l];
                        if(sum == target){
                            List<Integer>temp = Arrays.asList(arr[i],arr[j],arr[k],arr[l]);
                            temp.sort(null);
                            st.add(temp);
                        }
                    }
                }
            }
        }

        List<List<Integer>>ans = new ArrayList<>(st);
        return ans;
    }

    public static List<List<Integer>> findSecondOptimizeQuadruple(int []arr,int target){
       Set<List<Integer>>st = new HashSet<>();
       for(int i = 0; i<arr.length; i++){
           for(int j = i+1; j<arr.length; j++){
             Set<Integer>hashSet = new HashSet<>();
               for(int k = j+1; k<arr.length; k++){
                   long sum = arr[i]+arr[j];
                   sum += arr[k];
                   if(sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE){
                    break;
                   }
                   int val = target-(int)sum;
                   if(hashSet.contains(val)){
                    List<Integer>temp = Arrays.asList(arr[i],arr[j],arr[k],val);
                    temp.sort(null);
                    st.add(temp);
                   }
                   hashSet.add(arr[k]);
               }
           }
       }

       List<List<Integer>>ans = new ArrayList<>(st);
       return ans;
    }


    public static List<List<Integer>> findQuadrupleOptimalApproach(int []arr,int target){
        Arrays.sort(arr);
        List<List<Integer>>ans = new ArrayList<>();
        for(int i = 0; i<arr.length; i++){
            if( i != 0 && arr[i-1] == arr[i])continue;
            for(int j = i+1; j<arr.length; j++){
                if(j != i+1 && arr[j-1] == arr[j])continue;
                int k = j+1, l = arr.length-1;
                while(k<l){
                    long sum = arr[i]+arr[j];
                    sum += arr[k]+arr[l];
                    if(sum < target){
                        k++;
                    }
                    else if(sum > target){
                        l--;
                    }
                    else{
                        List<Integer>temp = Arrays.asList(arr[i],arr[j],arr[k],arr[l]);
                        ans.add(temp);
                        k++;
                        l--;
                        while(k<l && arr[k-1] == arr[k])k++;
                        while(k<l && arr[l+1] == arr[l])l--;
                    }
                }
            }
        }
        
        return ans;
     }

}
