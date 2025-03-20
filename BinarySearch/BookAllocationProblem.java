package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class BookAllocationProblem {
     public static void main(String args[]) throws IOException{
        int n; 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of the array: ");
        n = Integer.parseInt(br.readLine());
        int ans = 1;
        int[]arr = new int[n];
        System.out.println("Enter the value of array: ");
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        System.out.println("Enter the maximum student: ");
        int student =  Integer.parseInt(br.readLine());
        //for this problem we need to check for pages
        //so we will take pages from max value of arry to high which is sum of all pages of array  and check if it is possible to check 
        //how many student can take that much pages

        // ans = assingPage(arr,student);
        ans = optimizeAssingPage(arr, student);
        
        System.out.println("The ans is: "+ans);
    }

    public static int assingPage(int[]arr, int student){
        if(arr.length<student)return -1;
        List<Integer>ans = findMaxAndSum(arr);
        int low = ans.get(0);
        int high = ans.get(1);
        for(int i = low; i<=high; i++){
            if(checkArrangement(arr, i) == student){
                return i;
            }
        }
        return low;
    }

    public static int checkArrangement(int[]temp, int page){
        int n = temp.length;
        int count = 0;
        int student = 1;
        for(int i = 0; i<n; i++){
            if(count+temp[i] <= page){
                count += temp[i];
            }
            else{
                student++;
                count = temp[i];
            }
        }
        return student;
    }


    public static int optimizeAssingPage(int[]arr, int student){
        if(arr.length<student)return -1;
        List<Integer>ans = findMaxAndSum(arr);
        int low = ans.get(0),high = ans.get(1);
        while(low<= high){
            int mid = (low+high)/2;
            if(checkArrangement(arr, mid) > student){
               low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return low;
    }

    public static List<Integer>findMaxAndSum(int[]arr){
        int max = -1, sum = 0;
        for(int i = 0; i<arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
            sum += arr[i];
        }
        return Arrays.asList(max,sum);
    }
}
