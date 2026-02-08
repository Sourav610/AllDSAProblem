package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AssignCookies {
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n,k;
        System.out.println("Enter the size of children array: ");
        n = Integer.parseInt(br.readLine());
        System.out.println("Enter the size of cookie array: ");
        k = Integer.parseInt(br.readLine());

        int children[] = new int[n];
        System.out.println("Enter "+n+" children: ");
        for(int i = 0; i<n; i++){
            children[i] = Integer.parseInt(br.readLine());
        }
        int cookies[] = new int[k];
        System.out.println("Enter "+k+" cookies: ");
        for(int i = 0; i<k; i++){
            cookies[i] = Integer.parseInt(br.readLine());
        }

        int ans = 0;
        ans = calculateMaxChildrenWithCookie(children,cookies);
        System.out.println("The maximum children who get the cookie are: "+ans);
    }

    public static int calculateMaxChildrenWithCookie(int[]child,int[]cookie){
        Arrays.sort(child);
        Arrays.sort(cookie);

        int children = 0;
        int cookies = 0;
        while(children < child.length && cookies < cookie.length){
            if(cookie[cookies] >= child[children]){
                children++;
            }
            cookies++;
        }
        return children;
    }
}
