package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 * Variation 1: Given row number r and column number c. Print the element at position (r, c) in Pascal’s triangle.

Variation 2: Given the row number n. Print the n-th row of Pascal’s triangle.

Variation 3: Given the number of rows n. Print the first n rows of Pascal’s triangle.

In Pascal’s triangle, each number is the sum of the two numbers directly above it as shown in the figure below:

solution link: https://takeuforward.org/data-structure/program-to-generate-pascals-triangle/
 */
public class PascalTriangle{
    public static void main(String []args) throws IOException{
        int n; 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter number of rows you want: ");
        n = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Integer>>ans = new ArrayList<>();

        //brute force
        // ans = v3printPascalTriangle(n);


        //optimal for finding particular column value
        ans = v3printOptimalPascalTriangle(n);

        System.out.println("The pascal triangle is: ");
        for(int i = 0; i<ans.size(); i++){
            for(int j = 0; j<ans.get(i).size(); j++){
                System.out.print(ans.get(i).get(j)+" ");
            }
            System.out.println();
        }

        // v1PrintPascalTriangle(br);
        // int r;
        // System.out.println("Enter row num: ");
        // r = Integer.parseInt(br.readLine());
        // ArrayList<Integer>v2Ans = v2PrintPascalTriangle(r);

        // System.out.println("The nth row value is: ");
        // for(int i = 0; i<v2Ans.size(); i++){
        //     System.out.print(v2Ans.get(i)+" ");
        // }
    }

    public static ArrayList<ArrayList<Integer>> v3printPascalTriangle(int n){
        ArrayList<ArrayList<Integer>>ans = new ArrayList<>();
        ArrayList<Integer>temp = new ArrayList<>();
        temp.add(1);
        ans.add(temp);
        for(int i = 1; i<n; i++){
            ArrayList<Integer>init = new ArrayList<>();
            init.add(1);
            int sum = 0;
            for(int j = 1; j<i; j++){
                ArrayList<Integer>rem = ans.get(i-1);
                sum = rem.get(j-1)+rem.get(j);
                init.add(sum);
            }
            init.add(1);
            ans.add(init);
        }

        return ans;
    }

    public static ArrayList<ArrayList<Integer>> v3printOptimalPascalTriangle(int n){
        ArrayList<ArrayList<Integer>>temp = new ArrayList<>();
        for(int i = 1; i<=n; i++){
            temp.add(v2PrintPascalTriangle(i));
        }
        return temp;
    }

    public static void v1PrintPascalTriangle(BufferedReader br) throws IOException{
        int r, c;
        System.out.println("Enter row num: ");
        r = Integer.parseInt(br.readLine());
        System.out.println("Enter column no: ");
        c = Integer.parseInt(br.readLine());

        int ans = ncr(r-1,c-1);
        System.out.println("the specific column value of pascal triangle is : "+ans);
    }

    public static int ncr(int n, int r){
        long rem = 1;

        for(int i = 0; i<r; i++){
            rem *= (n-i);
            rem /= (r-i);
        }
        return (int)rem;
    }

    public static ArrayList<Integer> v2PrintPascalTriangle(int r){
        int ans = 1;
        ArrayList<Integer>temp = new ArrayList<>();
        temp.add(1);
        // System.out.print(ans+" ");
        for(int i = 1; i<r; i++){
            ans *= (r-i);
            ans /= i;
            temp.add(ans);
        }
        return temp;
    }
}