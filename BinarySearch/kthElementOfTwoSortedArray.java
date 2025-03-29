package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class kthElementOfTwoSortedArray {
    public static void main(String args[]) throws IOException{
        int n,m; 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of the array: ");
        n = Integer.parseInt(br.readLine());

        int arr1[] = new int[n];
        System.out.println("Enter "+n+" element: ");
        for(int i = 0; i<n; i++){
            arr1[i] = Integer.parseInt(br.readLine());
        }

        System.out.println("Enter the 2n size of the array: ");
        m= Integer.parseInt(br.readLine());


        int arr2[] = new int[n];
        System.out.println("Enter "+n+" element: ");
        for(int i = 0; i<m; i++){
            arr2[i] = Integer.parseInt(br.readLine());
        }

        System.out.println("Enter the key element you want to find: ");
        int k= Integer.parseInt(br.readLine());

        int ans=-1;
        // ans = findKthElement(arr1, arr2, k);
        ans = optimizeKthElement(arr1, arr2,k);
        System.out.println("The ans is: "+ans);
    }

    public static int findKthElement(int[]a, int[]b, int k){
        int i = 0, j = 0;
        int n1 = a.length, n2 = b.length;
        int cnt = 1;
        while(i<n1 && j<n2){
            if(a[i] < b[j]){
                if(cnt == k) return a[i];
                cnt++;
                i++;
            }
            else{
                if(cnt == k)return b[j];
                cnt++;
                j++;
            }
        }
        
        while(i<n1){
            if(cnt== k) return a[i];
            cnt++;
            i++;
        }
        
        while(j<n2){
            if(cnt == k)return b[j];
            cnt++;
            j++;
        }
        
        return -1;
    }

    public static int optimizeKthElement(int[] a, int[] b, int k) {
        int n1 = a.length, n2 = b.length;
        //if n1 is bigger swap the arrays:
        if (n1 > n2) return optimizeKthElement(b, a,k);

        int left = k;//length of left half
        //apply binary search:
        int low = Math.max(0,k-n2), high = Math.min(k,n1);
        while (low <= high) {
            int mid1 = (low + high)>>1;
            int mid2 = left - mid1;
            //calculate l1, l2, r1 and r2;
            int l1 = (mid1-1 >= 0) ? a[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = (mid2-1 >- 0) ? b[mid2 - 1] : Integer.MIN_VALUE;
            int r1 = (mid1 < n1) ? a[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < n2) ? b[mid2] : Integer.MAX_VALUE;

            if (l1 <= r2 && l2 <= r1) {
               return Math.max(l1,l2);
            } else if (l1 > r2) high = mid1 - 1;
            else low = mid1 + 1;
        }
        return 0; //dummy statement
    }
}
