package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MissingAndRepeating {
     public static void main(String []args) throws IOException{
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of array: ");
        n = Integer.parseInt(br.readLine());

        System.out.println("Enter "+n+" element: ");
        int []arr1 = new int[n];
        for(int i = 0; i<n; i++){
           arr1[i] = Integer.parseInt(br.readLine());
        }
        
        List<Integer>ans = new ArrayList<>();
        //using array as hash
        // ans = missingAndRepatingNum(arr1);

        /*using math of sum of n natural num and sum of sq of n natural num then creating two equation
        sum of all num in array - sum of n natural num = x(repeating num) - y(missing number);
        sum of square of all num in array - sum of square of n natural num = sq of x(repeating num) - sq of y(missing number);
        two equation we can solve.
        */
        // ans=  missingAndRepeatingNum2(arr1);

        /*
         * using xor operator
         * For the first step, we will run a loop and calculate the XOR of all the array elements and the numbers between 1 to N. Let’s call this value xr.
In order to find the position of the first set bit from the right, we can either use a loop or we can perform AND of the xr and negation of (xr-1) i.e. (xr & ~(xr-1)).
Now, we will take two variables i.e. zero and one. Now, we will check the bit of that position for every element (array elements as well as numbers between 1 to N).
If the bit is 1: We will XOR that element with variable one.
If the bit is 0: We will XOR that element with variable zero.
Finally, we have two variables i.e. two numbers zero and one. Among them, one is repeating and the other is missing. It’s time to identify them. 
We will traverse the entire array and check how many times variable zero appears. 
If it appears twice, it will be the repeating number, otherwise, it will be the missing. Now, based on variable zero’s identity, we can easily identify in which category, variable one belongs.
         */
        ans = missingAndRepeatingNum2(arr1);

        System.out.println("The array after mergin element: ");
        for(int i = 0; i<ans.size(); i++){
            System.out.print(ans.get(i)+" ");
        }
    }

    public static List<Integer> missingAndRepatingNum(int[]arr1){
        int[]temp = new int[arr1.length+1];
        int a = 0, b = 0;
        for(int i = 0; i<arr1.length; i++){
            if(temp[arr1[i]] != 0){
                a = arr1[i];
            }
            temp[arr1[i]]++;
        }

        for(int i = 1; i< temp.length; i++){
            if(temp[i] == 0){
                b = i;
            }
        }

        return Arrays.asList(a,b);
    }

    public static List<Integer> missingAndRepeatingNum2(int[]arr1){
        long n = arr1.length;
        long sn = (n*(n+1))/2;
        long ston = (n*(n+1)*(2*n+1))/6;

        long sx = 0;
        long stox = 0;
        for(int i = 0; i<n; i++){
            sx += arr1[i];
            stox += (long)arr1[i]* (long)arr1[i];
        }

        long val1 = sx-sn;
        long val2 = stox - ston;
        val2 = val2/val1;

        long a = (val1 + val2)/2;
        long b = a - val1;

        return Arrays.asList((int)a, (int)b);

    }

    public static List<Integer> missingAndRepeatingNum3(int[]arr1){
        int n = arr1.length;
        int xr = 0;
        ////Step 1: Find XOR of all elements: it will give me final xor of repeating and missing element;
        for(int i = 0; i<n; i++){
            xr ^= arr1[i];
            xr ^= (i+1);
        }

         //Step 2: Find the differentiating bit number:
        int number = (xr & -(xr-1));
        //we can use above or below to find bit no.
        // int bitNo = 0;
        // while(true){
        //     if((xr & (1<<bitNo)) != 0){
        //         break;
        //     }
        //     bitNo++;
        // }

        int zero = 0;
        int one = 0;
        for (int i = 0; i < n; i++) {
            //part of 1 group:
            if ((arr1[i] & number) != 0) {
                one = one ^ arr1[i];
            }
            //part of 0 group:
            else {
                zero = zero ^ arr1[i];
            }
        }

        for (int i = 1; i <= n; i++) {
            //part of 1 group:
            if ((i & number) != 0) {
                one = one ^ i;
            }
            //part of 0 group:
            else {
                zero = zero ^ i;
            }
        }

        // Last step: Identify the numbers:
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (arr1[i] == zero) cnt++;
        }

        if (cnt == 2) return Arrays.asList(zero,one);
        return Arrays.asList(one,zero);


    }
        
}
