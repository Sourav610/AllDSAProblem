package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MedianOfTwoSortedArray {
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
        double ans=-1;
        // ans = findMedian(arr1,arr2,n,m);
        // ans = OptimizedfindMedian(arr1, arr2, n, m);
        ans = median(arr1, arr2);
        System.out.println("The ans is: "+ans);
    }

    public static double findMedian(int[]arr1, int[]arr2, int n, int m){
        int i = 0, j = 0; 
        List<Integer>temp = new ArrayList<>();
        while(i<n && j<m){
            if(arr1[i] <arr2[j]){
                temp.add(arr1[i]);
                i++;
            }
            else{
                temp.add(arr2[j]);
                j++;
            }
        }

        while(i<n){
            temp.add(arr1[i]);
            i++;
        }
        
        while(j<m){
            temp.add(arr2[j]);
            j++;
        }

        int high = temp.size();
        if(high%2 == 1){
            return (double)temp.get(high/2);
        }

        double val = ((double)temp.get(high/2) + (double)temp.get((high/2)-1))/2;
        return val;
    }


    public static double OptimizedfindMedian(int[]arr1, int[]arr2, int n, int m){
        int i = 0, j = 0; 
        int totalLength = n+m;
        int ind1 = totalLength/2;
        int ind2 = ind1-1;
        int cnt=0;
        int ele1 = 0, ele2 = 0;
        while(i<n && j<m){
            if(arr1[i] <arr2[j]){
                if(cnt==ind1)ele1 = arr1[i];
                if(cnt==ind2)ele2 = arr1[i];
                cnt++;
                i++;
            }
            else{
                if(cnt==ind1)ele1 = arr2[j];
                if(cnt==ind2)ele2 = arr2[j];
                cnt++;
                j++;
            }
        }

        while(i<n){
            if(cnt==ind1)ele1 = arr1[i];
            if(cnt==ind2)ele2 = arr1[i];
            cnt++;
            i++;
        }
        
        while(j<m){
            if(cnt==ind1)ele1 = arr2[j];
            if(cnt==ind2)ele2 = arr2[j];
            cnt++;
            j++;
        }

        
        if(totalLength%2 == 1){
            return ele1;
        }

        double val = (ele1+ele2)/2;
        return val;
    }

    public static double median(int[] a, int[] b) {
        int n1 = a.length, n2 = b.length;
        //if n1 is bigger swap the arrays:
        if (n1 > n2) return median(b, a);

        int n = n1 + n2; //total length
        int left = (n1 + n2 + 1) / 2; //length of left half
        //apply binary search:
        int low = 0, high = n1;
        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = left - mid1;
            //calculate l1, l2, r1 and r2;
            int l1 = (mid1 > 0) ? a[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = (mid2 > 0) ? b[mid2 - 1] : Integer.MIN_VALUE;
            int r1 = (mid1 < n1) ? a[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < n2) ? b[mid2] : Integer.MAX_VALUE;

            if (l1 <= r2 && l2 <= r1) {
                if (n % 2 == 1) return Math.max(l1, l2);
                else return ((double) (Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
            } else if (l1 > r2) high = mid1 - 1;
            else low = mid1 + 1;
        }
        return 0; //dummy statement
    }
}
