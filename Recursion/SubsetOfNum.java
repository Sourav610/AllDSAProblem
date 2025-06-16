
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SubsetOfNum{
    private static ArrayList<ArrayList<Integer>>ans = new ArrayList<>();
    private static int length;
        public static void main(String[]args) throws NumberFormatException, IOException{
            int n;
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter a number: ");
            n = Integer.parseInt(br.readLine());
            int[]arr = new int[n];
            for(int i = 0; i<n; i++){
                arr[i] = Integer.parseInt(br.readLine());
            }
    
            // createSubset(arr,n);
            ArrayList<Integer>currCombo = new ArrayList<Integer>();
            length = n;
            subsetUsingRecursion(0,currCombo,arr);
            
             for(ArrayList<Integer> j: ans){
            for(int k = 0; k<j.size(); k++){
                System.out.print(j.get(k)+" ");
            }
            System.out.println();
        }

    }

    public static void createSubset(int[]arr, int n){
        ArrayList<ArrayList<Integer>>ans = new ArrayList<>();
        ans.add(new ArrayList<Integer>());

        for(int i = 0; i<n; i++){
            ArrayList<ArrayList<Integer>>temp = new ArrayList<>(); 
            for(ArrayList<Integer>test: ans){
                ArrayList<Integer>curr = new ArrayList(test);
                curr.add(arr[i]);
                temp.add(curr);
            }

            for(ArrayList<Integer>val:temp){
                ans.add(val);
            }
        }

        for(ArrayList<Integer> j: ans){
            for(int k = 0; k<j.size(); k++){
                System.out.print(j.get(k)+" ");
            }
            System.out.println();
        }

    }

    public static void subsetUsingRecursion(int first, ArrayList<Integer>curr, int[]nums){
        ans.add(new ArrayList(curr));

        for(int i = first; i<length; i++){
            curr.add(nums[i]);
            subsetUsingRecursion(i+1, curr, nums);
            curr.remove(curr.size()-1);
        }
    }
}