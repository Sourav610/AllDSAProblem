package StackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * We are given an array asteroids of integers representing asteroids in a row. The indices
 *  of the asteriod in the array represent their relative position in space.

For each asteroid, the absolute value represents its size, and the sign represents its direction 
(positive meaning right, negative meaning left). Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions. If two asteroids meet, 
the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
 */

public class AsteroidsCollision {
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of array: ");
        int n= Integer.parseInt(br.readLine());
        System.out.println("Enter "+n+" element: ");
        int[]arr = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[]ans = {};
        ans = findAsteroidCollision(n,arr);
        for(int i = 0; i<ans.length; i++){
            System.out.println("The ans is: "+ans[i]+" ");
        }
    }

    /*
     * 
     * his is based on Python code. Other might be different a bit.

Initialize an empty list called res to store the final result.

Iterate through each element a in the asteroids list.

Check the current asteroid a and the last asteroid in the res list (if it exists) to determine whether there will be a collision or not.

The while loop while res and a < 0 < res[-1]: checks if the res list is not empty and if the current asteroid a is negative (moving left) while the last asteroid in res (res[-1]) is positive (moving right). This condition represents the potential for a collision.

If there's a potential collision, we need to resolve it:

If the magnitude of the current asteroid a is greater than the last asteroid's magnitude in res (-a > res[-1]), then the current asteroid will destroy the last asteroid in res. So, we pop the last asteroid from res using res.pop().

If the magnitude of the current asteroid a is equal to the last asteroid's magnitude in res (-a == res[-1]), both asteroids will collide and destroy each other. So, we pop the last asteroid from res using res.pop().

If neither of the above conditions is met, it means the current asteroid a will pass safely without any collision, and we break out of the while loop.

If the while loop finishes without encountering a collision, i.e., the current asteroid a is not destroyed by any other asteroid in res, we add the current asteroid a to the res list using res.append(a).

Continue the iteration until all asteroids have been processed.

Finally, return the res list, which contains the asteroids that survived the collisions.
     */

    public static int[] findAsteroidCollision(int n, int[]arr){
        Stack<Integer>st = new Stack();
        for(int i = 0; i<n; i++){
            if(arr[i] > 0){
                st.push(arr[i]);
            }
            else{
                while(!st.empty() && st.peek() > 0 && st.peek() < Math.abs(arr[i])){
                    st.pop();
                }

                if(st.empty() || st.peek() < 0){
                    st.push(arr[i]);
                }
                if(!st.empty() && st.peek() == Math.abs(arr[i])){
                    st.pop();
                }
            }
        }

        int[]ans = new int[st.size()];
        int j = st.size()-1;
        while(!st.empty()){
            ans[j--] = st.pop();
        }
        return ans;
    } 
}
