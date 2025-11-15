package StackAndQueue;
import java.util.*;


/*
 * Design an algorithm that collects daily price quotes for some stock and returns the span of that stock's price for the current day.

The span of the stock's price in one day is the maximum number of consecutive days (starting from that day and going backward) 
for which the stock price was less than or equal to the price of that day.

For example, if the prices of the stock in the last four days is [7,2,1,2] and the price of the stock today is 2,
 then the span of today is 4 because starting from today, the price of the stock was less than or equal 2 for 4 consecutive days.
Also, if the prices of the stock in the last four days is [7,34,1,2] and the price of the stock today is 8, 
then the span of today is 3 because starting from today, the price of the stock was less than or equal 8 for 3 consecutive days.
Implement the StockSpanner class:

StockSpanner() Initializes the object of the class.
int next(int price) Returns the span of the stock's price given that today's price is price
 */
/*
 * Brute force Approach:
 * T.C - O(n*n)
 * S.C - O(n)
 */
class Solution{
    public int [] stockspan(int[]arr,int n){
        int []ans = new int[n];
        for(int i = 0; i<n; i++){
            int count = 0;
            for(int j = i; j>= 0; j--){
                if(arr[j] <= arr[i]){
                    count++;
                }
                else{
                    break;
                }
            }
            ans[i] = count;
        }
        return ans;
    }

    /*
     * T.C - O(n)
     * S.C - O(n)
     */
    public int[] optimizeStockSpan(int[]arr, int n){   
        int []ans = new int[n];
        Stack<Integer>st = new Stack<Integer>();
        for(int i = 0; i<n; i++){
            int currEle = arr[i];
            while(!st.isEmpty() && arr[st.peek()] <= currEle){
                st.pop();
            }

            if(st.isEmpty()){
                ans[i] = -1;
            }
            else{
                ans[i] = st.peek();
            }

            st.push(i);
        }
        return ans;
    }

    public int[] findEle(int[]arr,int n){
        int[]res = optimizeStockSpan(arr,n);
        int[]temp = new int[n];

        for(int i = 0; i<n; i++){
            temp[i] = i - res[i];
        }
        return temp;
    }
}

public class OnlineStockSpan {
    public static void main(String[] args) {
        int n = 6; // Number of days
        int[] arr = {100,80, 60, 70, 60, 75}; // Stock prices for each day
        
        // Create an instance of Solution class
        Solution sol = new Solution(); 
        
        // Call the function to find the stock span for each day
        int[] ans;
        // ans = sol.stockspan(arr, n);
        ans = sol.findEle(arr,n);
        
        // Print the span of stock prices
        System.out.print("The span of stock prices is: ");
        for(int i = 0; i < n; i++) {
            System.out.print(ans[i] + " ");
        }
    }

}


