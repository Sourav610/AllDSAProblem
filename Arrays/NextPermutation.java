package Arrays;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class NextPermutation {
    public static void main(String []args) throws IOException{
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of array: ");
        n = Integer.parseInt(br.readLine());

        System.out.println("Enter "+n+" element: ");
        int []arr = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        //This is a bruteforce approach but it will not work correclty if duplicate value is present
    //    recursivePermutation(arr);

       //optimize approach
       /*
        * 1. Find the break-point, i: Break-point means the first index i from the back of the given array where arr[i] becomes smaller than arr[i+1].
            For example, if the given array is {2,1,5,4,3,0,0}, the break-point will be index 1(0-based indexing). Here from the back of the array, index 1 is the first index where arr[1] i.e. 1 is smaller than arr[i+1] i.e. 5.
            To find the break-point, using a loop we will traverse the array backward and store the index i where arr[i] is less than the value at index (i+1) i.e. arr[i+1].
          2. If such a break-point does not exist i.e. if the array is sorted in decreasing order, the given permutation is the last one in the sorted order of all possible permutations. So, the next permutation must be the first i.e. the permutation in increasing order.
             So, in this case, we will reverse the whole array and will return it as our answer.
          3. If a break-point exists:
            Find the smallest number i.e. > arr[i] and in the right half of index i(i.e. from index i+1 to n-1) and swap it with arr[i].
            Reverse the entire right half(i.e. from index i+1 to n-1) of index i. And finally, return the array.
        */
        optimizeNextPermutation(arr);
    }

    public static void swap(int i, int j, int []arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void recursivePermutation(int []arr){
        ArrayList<ArrayList<Integer>>ans = new ArrayList<>();
        recurPerm(arr,0,ans);
        
        Collections.sort(ans, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
                int minSize = Math.min(a.size(), b.size());
                for (int i = 0; i < minSize; i++) {
                    if (!a.get(i).equals(b.get(i))) {
                        return Integer.compare(a.get(i), b.get(i)); 
                    }
                }
                return Integer.compare(a.size(), b.size()); 
            }
        });
        System.out.println("The next permutation element is: ");
        ArrayList<Integer>temp = new ArrayList<>();
        for(int i = 0;i <arr.length; i++){
            temp.add(arr[i]);
        }
        int val = ans.indexOf(temp);

        if(val != ans.size()){
            temp = ans.get(val+1);
        }
        else{
            temp = ans.get(0);
        }

        for(int i = 0; i<temp.size(); i++){
            System.out.print(temp.get(i)+" ");
        }
        
    }

    public static void recurPerm(int[]arr, int ind , ArrayList<ArrayList<Integer>> ans){
        if(ind == arr.length){
            ArrayList<Integer>ds = new ArrayList<>();
            for(int i = 0; i<arr.length; i++){
                ds.add(arr[i]);
            }
            ans.add(ds);
            return;
        }

        for(int i = ind; i<arr.length; i++){
            swap(i, ind, arr);
            recurPerm(arr, ind+1, ans);
            swap(i, ind, arr);

        }
    }

    public static void optimizeNextPermutation(int []arr){
        int i = arr.length-1;
        while(i> 0){
            if(arr[i-1] < arr[i]){
                break;
            }
            i--;
        }
        if(i == 0){
            int k= arr.length-1;
            while(k>i){
                int temp = arr[k];
                arr[k] = arr[i];
                arr[i] = temp;
                k--;
                i++;
            }
        }
        else{
            i--;
            int breakVal = arr[i];
            int j = arr.length-1;
            while(j>i){
                if(arr[j] > arr[i]){
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                    break;
                }
                j--;
            }
            if(j == i){
            
            }
            i++;
            j = arr.length-1;

            //reversin right half because we want to get the next smallest element which is greater then current element.
            while(j>i){
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                j--;
                i++;
            }
        }

        System.out.println("The next permutation is: ");
        for(int k = 0; k<arr.length; k++){
            System.out.print(arr[k]+" ");
        }

    }
}
