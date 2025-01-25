package Arrays;
import java.io.*;


/*
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */
public class BestTimeToBuyAndSellStock {
    public static void main(String []args) throws IOException{
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of the array: ");
        n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];

        System.out.print("Enter "+n+" element: ");
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int val = 0;
        // val = Profit(arr);

        //optimized Approach
        // We will linearly travel the array. We can maintain a minimum from the start of the array and compare it with every element of the array, 
        //if it is greater than the minimum then take the difference and maintain it in max, otherwise update the minimum.
        val = optimizedProfit(arr);
        System.out.println("The answer is: "+val);
    }

    public static int Profit(int []arr){
        int max = 0;
        for(int j = 0; j<arr.length; j++){
            for(int i = j+1; i<arr.length; i++){
                if(arr[i] > arr[j]){
                    int cal = arr[i] - arr[j];
                    if(cal > max){
                        max = cal;
                    }
                }
            }
        }
        return max;
    }

    public static int optimizedProfit(int []arr){
        int min = arr[0], max = 0;
        for(int i = 0; i<arr.length; i++){
            if(arr[i] < min){
                min = arr[i];
            }
            int cal = arr[i] - min;
            if(cal > max){
                max = cal;
            }
        }
        return max;
    }
}
