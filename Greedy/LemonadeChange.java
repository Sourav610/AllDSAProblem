package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
At a lemonade stand, each lemonade costs $5. Customers are standing in a queue to buy from you
 and order one at a time (in the order specified by bills). Each customer will only buy one lemonade
  and pay with either a $5, $10, or $20 bill. You must provide the correct change to each customer 
  so that the net transaction is that the customer pays $5.

Note that you do not have any change in hand at first.

Given an integer array bills where bills[i] is the bill the ith customer pays,
 return true if you can provide every customer with the correct change, or false otherwise.
*/
public class LemonadeChange {
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of bills array: ");
        int n = Integer.parseInt(br.readLine());
        int[]bills = new int[n];
        System.out.println("Enter "+n+" value: ");
        for(int i = 0; i<n; i++){
            bills[i] = Integer.parseInt(br.readLine());
        }

        boolean ans = calculateChangePossible(bills);
        System.out.println("The seller can give change: "+ans);

    }

    public static boolean calculateChangePossible(int[]bills){
        int fiveDollarBill = 0;
        int tenDollarBill = 0;

        for(int i: bills){
            if(i == 5){
                fiveDollarBill++;
            }
            else if (i == 10){
                if(fiveDollarBill > 0){
                    fiveDollarBill--;
                    tenDollarBill++;
                }
                else{
                    return false;
                }
            }
            else{
                if(tenDollarBill > 0 && fiveDollarBill > 0){
                    tenDollarBill--;
                    fiveDollarBill--;
                }
                else if(fiveDollarBill > 2){
                    fiveDollarBill -= 3;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}
