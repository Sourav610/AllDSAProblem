package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class SecondLargestAndSecondSmallest {
     public static void main(String []args) throws IOException{
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of an array: ");
        n = Integer.parseInt(br.readLine());

        System.out.print("Enter "+n+" element: ");
        int arr[] = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        // SecondLargest(arr);
        int secLar = OptimzedSecondLargest(arr, arr.length);
        int secSmall = OptimizedSecondSmallest(arr, arr.length);

        System.out.print("The secLar is: "+secLar+" and the secSmall is "+secSmall);

    }

    public static void SecondLargest(int arr[]){
        int lar = arr[0], small = Integer.MAX_VALUE, secLar = arr[0] , secSmall = Integer.MAX_VALUE;
        if(arr.length == 1){
            System.out.println(-1);
            return;
        }
        for(int i = 0; i<arr.length; i++){
            if(arr[i] > lar){
                lar = arr[i];
            }
            if(arr[i] < small){
                small = arr[i];
            }
        }

        for(int i = 0; i<arr.length; i++){
            if(arr[i] > secLar && arr[i] < lar ){
                secLar = arr[i];
            }
            if(arr[i] < secSmall && arr[i] > small){
                secSmall = arr[i];
            }
        }
        
        System.out.print(lar+" "+secLar+" "+small+" "+secSmall);
        if(secLar == -1 || secSmall == -1){
            System.out.print("Ans is: -1");
            return;
        }
        System.out.println("The second largest element is: "+secLar+" And the secSmall is "+secSmall);
    }

    public static int OptimizedSecondSmallest(int arr[],int n)
    {
        if(n<2)
            return -1;
        int small = Integer.MAX_VALUE;
        int second_small = Integer.MAX_VALUE;
        int i;
        for(i = 0; i < n; i++) 
        {
        if(arr[i] < small)
        {
            second_small = small;
            small = arr[i];
        }
        else if(arr[i] < second_small && arr[i] != small)
        {
            second_small = arr[i];
        }
        }
    return second_small;     
    }
public static int OptimzedSecondLargest(int arr[],int n)
{
	if(n<2)
	return -1;
    int large=Integer.MIN_VALUE,second_large=Integer.MIN_VALUE;
    int i;
    for (i = 0; i < n; i++) 
    {
        if (arr[i] > large) 
        {
            second_large = large;
            large = arr[i];
        }
 
        else if (arr[i] > second_large && arr[i] != large) 
        {
            second_large = arr[i];
        }
    }
    return second_large;                
}

}
