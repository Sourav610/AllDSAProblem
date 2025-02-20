package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSortedArray {
     public static void main(String []args) throws IOException{
        int n,m;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of array: ");
        n = Integer.parseInt(br.readLine());

        System.out.println("Enter "+n+" element: ");
        int []arr1 = new int[n];
        for(int i = 0; i<n; i++){
           arr1[i] = Integer.parseInt(br.readLine());
        }

        System.out.println("Enter the size of 2nd array: ");
        m = Integer.parseInt(br.readLine());
        System.out.println("Enter "+m+" element: ");
        int []arr2 = new int[m];
        for(int i = 0; i<m; i++){
           arr2[i] = Integer.parseInt(br.readLine());
        }
        
        List<Integer>ans = new ArrayList<>();
        //if need to merge in a single array
        // ans = mergeSortedArray(arr1,arr2);

        //if small element contain in first array and large element in second then use below function
        // MergeSortedArraysType2(arr1,arr2);
        MergeSortedArraysType3(arr1,arr2);

        System.out.println("The array after mergin element: ");
        for(int i = 0; i<ans.size(); i++){
            System.out.print(ans.get(i)+" ");
        }
    }

    public static List<Integer> mergeSortedArray(int []arr1, int []arr2){
        int i = 0, j = 0, n = arr1.length, m = arr2.length;
        List<Integer>ans = new ArrayList<>();
        while(i<n && j<m){
            if(arr1[i] < arr2[j]){
                ans.add(arr1[i]);
                i++;
            }
            else{
                ans.add(arr2[j]);
                j++;
            }
        }

        while(i<n){
            ans.add(arr1[i]);
            i++;
        }
        while(j<m){
            ans.add(arr2[j]);
            j++;
        }
        return ans;
    }
    
    public static void MergeSortedArraysType2(int[]arr1, int[]arr2){
        int i= arr1.length-1, j = 0;
        while(i>= 0 && j<arr2.length){
            if(arr1[i] > arr2[j]){
                int temp = arr1[i];
                arr1[i] = arr2[j];
                arr2[j] = temp;
                i--;
                j++;
            }
            else{
                break;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        for(int k = 0; k<arr1.length; k++){
            System.out.print(arr1[k]+" ");
        }

        for(int l = 0; l<arr2.length; l++){
            System.out.print(arr2[l]+" ");
        }
    }

    public static void MergeSortedArraysType3(int[]arr1, int[]arr2){
        int len = arr1.length+arr2.length;
        int gap = (len/2) + (len%2);

        while(gap > 0){
            int left = 0, right = left+gap;
            while(right < len){
                if(left < arr1.length && right >= arr1.length){
                    sortIfDiff(arr1, arr2, left, right-arr1.length);
                }
                else if(left >= arr1.length){
                    sortIfDiff(arr2, arr2, left-arr1.length, right-arr1.length);
                }
                else{
                    sortIfDiff(arr1, arr1, left, right);
                }
                left++;
                right++;
            }
            if(gap == 1) break;
            gap = (gap/2) + (gap%2);
        }
        for(int k = 0; k<arr1.length; k++){
            System.out.print(arr1[k]+" ");
        }

        for(int l = 0; l<arr2.length; l++){
            System.out.print(arr2[l]+" ");
        }
    }

    static void sortIfDiff(int[]arr1, int[]arr2, int ind1, int ind2){
        if(arr1[ind1] > arr2[ind2]){
            int temp = arr1[ind1];
            arr1[ind1] = arr2[ind2];
            arr2[ind2] = temp;
        }
    }
}
