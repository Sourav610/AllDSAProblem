package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharacterByFrequency {
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the value of string: ");
        String st = br.readLine();

        String ans = sortCharacter(st);
        
        System.out.println("The string after removing outermost parenthesis is: "+ans);
        
    }

    public static String sortCharacter(String st){
        Map<Character,Integer>mp = new HashMap<>();
        for(char c: st.toCharArray()){
            mp.put(c, mp.getOrDefault(c, 0)+1);
        }
        

        //priority queue bye default is min heap - to make max heap we added (a,b) -> b.getValue-a.getValue comparator
        PriorityQueue<Map.Entry<Character,Integer>>pq = new PriorityQueue<>((a,b) -> b.getValue()-a.getValue());
        pq.addAll(mp.entrySet());

        StringBuilder result = new StringBuilder();
        while(!pq.isEmpty()){
            Map.Entry<Character,Integer>entry = pq.poll();
            result.append(String.valueOf(entry.getKey()).repeat(entry.getValue()));
        }

        return result.toString();



    }
}
