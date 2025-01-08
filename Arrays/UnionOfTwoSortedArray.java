package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class UnionOfTwoSortedArray {
    public static void main(String []args) throws IOException{
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of an array: ");
        n = Integer.parseInt(br.readLine());

        int arr1[] = new int[n];

        System.out.println("Enter "+n+" element for first array: ");
        for(int i = 0; i<n; i++){
            arr1[i] = Integer.parseInt(br.readLine());
        }

        System.out.println("Enter the size of 2nd array: ");
        int n2 = Integer.parseInt(br.readLine());
        int arr2[] = new int[n2];

        System.out.println("Enter "+n2+" element for 2nd array: ");
        for(int i = 0; i<n2; i++){
            arr2[i] = Integer.parseInt(br.readLine());
        }

        ArrayList<Integer> ans = Union(arr1, arr2);

        System.out.println("Array after mergin is: ");
        for(int i = 0; i<ans.size(); i++){
            System.out.print(ans.get(i)+" ");
        }
    }

    public static ArrayList<Integer> Union(int []arr1, int []arr2){
        System.out.println("Merging two array: ");
        ArrayList<Integer> ans = new ArrayList<>();

        int i  = 0, j = 0;  
        while(i< arr1.length && j< arr2.length){
            if(arr1[i] <= arr2[j]){
                if(ans.size() == 0 || ans.get(ans.size()-1) != arr1[i]){
                    ans.add(arr1[i]);
                }
                i++;
                
            }
            else{
                if(ans.size() == 0 || ans.get(ans.size()-1) != arr2[j]){
                    ans.add(arr2[j]);
                }
                j++;
            }
        }

        while(i<arr1.length){
            if(ans.get(ans.size()-1) != arr1[i]){
                ans.add(arr1[i]);
            }
            i++;
        }

        while(j<arr2.length){
            if(ans.get(ans.size()-1) != arr2[j]){
                ans.add(arr2[j]);
            }
            j++;
        }
        return ans;

    }
}
