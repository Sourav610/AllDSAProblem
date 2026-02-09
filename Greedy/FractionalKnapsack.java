package Greedy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Pair{
    double a;
    int b;

    // Pair(){

    // }

    Pair(double v,int c){
        a = v;
        b = c;
    }

    int getValue(){
        return b;
    }

    double getKey(){
        return a;
    }
    
}

public class FractionalKnapsack {

    static class ItemComparator implements Comparator<Pair> {
        public int compare(Pair a, Pair b) {
            double r1 = a.getKey();
            double r2 = b.getKey();
            return Double.compare(r2, r1);  // Return comparison based on value/weight ratio
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of wt arr: ");
        int wt, val, cap;
        wt = Integer.parseInt(br.readLine());
        int weight[] = new int[wt];
        System.out.println("Enter "+wt+" element: ");
        for(int i = 0; i<wt; i++){
            weight[i] = Integer.parseInt(br.readLine());
        }
        System.out.println("Enter the size of value arr: ");
        val = Integer.parseInt(br.readLine());
        int value[] = new int[val];
        System.out.println("Enter "+val+" element: ");
        for(int i = 0; i<val; i++){
            value[i] = Integer.parseInt(br.readLine());
        }

        System.out.println("Enter the capacity of the bag: ");
        cap = Integer.parseInt(br.readLine());

        double ans = 0;
        ans = calculateMaxValue(value,weight,cap);
        System.out.println("The maximum value of product we can buy is: "+ans);
    }


    /*
     T.C - O(nlogn+n);
     S.C - O(1);

     approach: calculate the ration of val/wt and sort in desc order then take one by one until all capacity fill.
    */
    public static double calculateMaxValue(int[]val,int[]wt, int cap){
        List<Pair>ratio =new ArrayList<Pair>();
        for(int i = 0; i<val.length; i++){
            double calRation = (double)val[i]/wt[i];
            ratio.add(new Pair(calRation,wt[i]));
        }
        Collections.sort(ratio,new ItemComparator());
        double ans = 0;
        for(Pair i: ratio){
            if(i.getValue() <= cap){
                ans += i.getKey()*i.getValue();
                cap -= i.getValue();
            }
            else{
                ans += i.getKey()*cap;
                break;
            }
        }
        return ans;
    }
}
