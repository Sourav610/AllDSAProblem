import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SingleNum3 {
    public static void main(String[]agrs) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of the array: ");
        int n= Integer.parseInt(br.readLine());
        int[]arr = new int[n];
        System.out.println("Enter "+n+" element: ");
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        List<Integer> ans = new ArrayList<Integer>(); 
        ans = findUniqueNum(arr);
        ans = findOptimizeNum(arr);
        System.out.println("The answer is: "+ans);
    }

    /*
        -- Brute Force
     * T.C - nLog(m) +m  value of m = n/2 +1
     * S.C = O(m)
     * 
     */
    public static List<Integer> findUniqueNum(int[]arr){
        List<Integer>ans = new ArrayList<Integer>();
        Map<Integer,Integer> mp = new HashMap<>();

        for(int i = 0; i<arr.length; i++){
            if(mp.containsKey(arr[i])){
                int val = mp.get(arr[i]);
                mp.put(arr[i],val+1);
            }
            else{
                mp.put(arr[i],1);
            }
        }

        for(Map.Entry<Integer,Integer> temp:mp.entrySet()){
            if(temp.getValue() == 1){
                ans.add(temp.getKey());
            }
        }
        return ans;
    }

    /*
     * Optimize approach
     * - here we will take xor of all number so we will get the xor of two unique as result
     * -- then we will check first difference bit from both unique number as shown below
     * -      (res&(res-1))^res -- this will give me the first different bit
     * -- now using that we will sort all number in two bucket b1 and b2 which
     * will give me two unique num.
     * 
     */

    public static List<Integer> findOptimizeNum(int []arr){
        List<Integer>ans = new ArrayList<Integer>();
        long res = 0; 

        for(int i = 0; i<arr.length; i++){
            res ^= arr[i];
        }

        long rightMostBit = (res&(res-1))^res;

        int b1 = 0, b2 = 0; 
        for(int i = 0; i<arr.length; i++){
            if((arr[i]&rightMostBit) != 0){
                b1 ^= arr[i];
            }
            else{
                b2 ^= arr[i];
            }
        }

        ans.addAll(Arrays.asList(b1,b2));

        return ans;
    }

    
}
