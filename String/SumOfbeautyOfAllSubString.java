package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class SumOfbeautyOfAllSubString {

     public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the value of string: ");
        String st = br.readLine();

        int ans;

        ans = findSumSubstr(st);

        System.out.println("The length of substring is:"+ans);
    }

    public static int  findSumSubstr(String s){
        int ans = 0;
        for(int i = 0; i<s.length(); i++){
            HashMap<Character,Integer>mp = new HashMap<>();
            for(int j = i; j<s.length(); j++){
                int maxVal = Integer.MIN_VALUE, minVal = Integer.MAX_VALUE;
                mp.put(s.charAt(j),mp.getOrDefault(s.charAt(j), 0)+1);
                for(Map.Entry<Character,Integer> val :mp.entrySet()){
                    if(val.getValue() > maxVal){
                        maxVal = val.getValue();
                    }
                    if(val.getValue()< minVal){
                        minVal =val.getValue();
                    }
                }
                ans += maxVal - minVal;
            }
        }
        return ans;
    }
}
