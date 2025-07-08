
/*
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class LetterCombinationOfPhoneNumber {
    public static void main(String[]args) throws IOException{
        String n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a number: ");
        n = br.readLine();
        
        HashMap<Character,String>mp = new HashMap<>();
        mp.put('2',"abc");
        mp.put('3',"def");
        mp.put('4',"ghi");
        mp.put('5',"jkl");
        mp.put('6',"mno");
        mp.put('7',"pqrs");
        mp.put('8',"tuv");
        mp.put('9',"wxyz");
        
        ArrayList<String>temp = new ArrayList<>();
        calCombination(0, temp, mp, "",n);

        for(String i: temp){
            System.out.println("The subsequenc present in arr is "+i);
        }
    }

    public static void calCombination(int i, ArrayList<String>temp,HashMap<Character,String>mp,String res,String digit){
        if(digit.length() == 0){
            return;
        }
        if(res.length() == digit.length()){
            temp.add(res);
            return;
        }

        String charArray = mp.get(digit.charAt(i));
        for(int ind = 0; ind < charArray.length(); ind++){
            calCombination(i+1,temp,mp, res+charArray.charAt(ind),digit);
        }
    }
}
