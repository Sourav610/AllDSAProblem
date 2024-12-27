package Sorting;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class MergeSort {
    public static void main(String[] args) throws IOException {
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the size of an array: ");
        n = Integer.parseInt(br.readLine());

        int arr[] = new int[n];
        System.out.print("Enter "+n+" element: ");
        for(int i = 0; i<n; i++){
            arr[i]  = Integer.parseInt(br.readLine());
        }

        int low = 0, high = n-1;

        //first recursively divide and concure then merge (for diving thing how you divide in binary search)
        //for mergin think how to merge two sorted array same way just need to creat two temp array with the index and 
        //final value will be store in original array.
    
        MergeSort(arr,low, high);

        System.out.print("Element after sorting are: ");

        for(int i = 0; i<n; i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void MergeSort(int arr[], int low, int high){
        int mid = low + (high-low)/2;
        if(low >= high){
            return;
        }                                   // 7 5 4 3   low = 0 high = 3
        MergeSort(arr, low, mid);
        MergeSort(arr, mid+1, high);
        Merge(arr, low, mid, high);
    }

    public static void Merge(int[] arr, int low, int mid, int high){
        int n1 = mid - low+1;
        int n2 = high-mid;

        int temp1[] = new int[n1];
        int temp2[] = new int[n2];

        for(int i = 0; i<n1; i++){
            temp1[i] = arr[low+i];
        }

        for(int j = 0; j<n2; j++){
            temp2[j] = arr[mid+j+1];
        }

        int i = 0, j = 0, k = low;
        while(i<n1 && j <n2){
            if(temp1[i] < temp2[j]){
                arr[k] = temp1[i];
                i++;
            }
            else{
                arr[k]= temp2[j];
                j++;
            }
            k++;
        }

        while(i<n1){
            arr[k] = temp1[i];
            i++;
            k++;
        }
        while(j<n2){
            arr[k] = temp2[j];
            j++;
            k++;
        }
    }

    //More optimized way of merging(in c++)
    // void merge1(vector<int>&arr, int left, int mid, int right){
    //     int n1 = left;
    //     int n2 = mid+1;
        
    //     vector<int>temp;
    //     while(n1 <= mid && n2<= right){
    //         if(arr[n1] < arr[n2]){
    //             temp.push_back(arr[n1]);
    //             n1++;
    //         }
    //         else{
    //             temp.push_back(arr[n2]);
    //             n2++;
    //         }
    //     }
        
    //     while(n1<=mid){
    //         temp.push_back(arr[n1]);
    //         n1++;
    //     }
        
    //     while(n2<=right){
    //         temp.push_back(arr[n2]);
    //         n2++;
    //     }
        
    //     for(int i = left; i<= right; i++){
    //         arr[i] = temp[i-left];
    //     }
    // }
}
