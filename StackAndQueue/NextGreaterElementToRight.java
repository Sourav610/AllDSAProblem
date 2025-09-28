package StackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NextGreaterElementToRight {
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of first array: ");
        int n = Integer.parseInt(br.readLine());
        System.out.println("Enter "+n+" element: ");
        int[] arr1 = new int[n];
        for(int i = 0; i<n; i++){
            arr1[i] = Integer.parseInt(br.readLine());
        }
        System.out.println("Enter the size of second array: ");
        int m = Integer.parseInt(br.readLine());
        System.out.println("Enter "+m+" element index: ");
        int[] arr2 = new int[m];
        for(int i = 0; i<m; i++){
            arr2[i] = Integer.parseInt(br.readLine());
        }

        int []ans = {};
        // ans = findIndexCount(arr1,arr2);
        ans = findOptimizeElementCount(arr1,arr2);
        System.out.println("The ans is: ");
        for(int i = 0; i<ans.length; i++){
            System.out.print(ans[i]+" ");
        }
    }

    /*
     * Brute force approach
     * T.C - O(n*n);
     * S.C - O(1)
     */
    public static int[] findIndexCount(int[]arr1,int[]arr2){
        int[]ans = new int[arr2.length];
        int k = 0;
        for(int i = 0; i<arr2.length; i++){
            int j = arr2[i];
            int curr = arr1[j];
            int count= 0;
            while(j<arr1.length){
                if(arr1[j] > curr){
                    count++;
                }
                j++;
            }
            ans[k] = count;
            k++;
            count = 0;
        }
        return ans;

    }

    public static int[] findOptimizeElementCount(int[]arr1,int[]arr2){
        int n = arr1.length;
        int[]sorted = arr1.clone();
        Arrays.sort(sorted);
        Map<Integer,Integer>rankMap  = new HashMap<>();
        int rank = 1;
        for(int val :sorted){
            if(!rankMap.containsKey(val)){
                rankMap.put(val,rank++);
            }
        }

        FenwicTree bit = new FenwicTree(rankMap.size());
        int[]greaterCount = new int[n];
        int totalSeen = 0;

        for(int i = n-1; i>=0; i--){
            int r = rankMap.get(arr1[i]);
            int lessOrEqual = bit.query(r);
            greaterCount[i] =  totalSeen -lessOrEqual;
            bit.update(r,1);
            totalSeen++;
        }

        int[]result = new int[arr2.length];
        for(int j = 0; j< arr2.length; j++){
            result[j] = greaterCount[arr2[j]];
        }
        return result;
    }

    public static class FenwicTree{
        int[]bit;
        int size;
    
        FenwicTree(int n){
            size = n;
            bit = new int[n+1];
        }

        void update(int ind, int val){
            while(ind <= size){
                bit[ind] += val;
                ind += ind & -ind;
            }
        }

        int query(int ind){
            int sum = 0;
            while(ind> 0){
                sum += bit[ind];
                ind -= ind & -ind;
            }
            return sum;
        }


    }
}


