package StackAndQueue;

/*
 * A celebrity is a person who is known by everyone else at the party but does not know anyone
 *  in return. Given a square matrix M of size N x N where M[i][j] is 1 if person i knows person j, 
 * and 0 otherwise, determine if there is a celebrity at the party. Return the index of the celebrity or -1 if no such person exists.

Note that M[i][i] is always 0.
 */
public class CelebrityProblem {
    public static void main(String[]args){
        int[][]arr = {
            {0,1,1,0},
            {0,0,0,0},
            {1,1,0,0},
            {0,1,1,0}
        };

        int ans = -1;
        // ans = findCelebrity(arr);
        ans = findCelebrityOptimize(arr);
        System.out.println("The Celebrity is : "+ans);
    }

    /*

     Approach: here we have four person as matrix size is 4 
     so we need to create two arr of length 4 fist will contain which all person whom i know
     and second will contain which are person knows me.
     so from this every index of those two array will contain that index person knows whom and whoever knows this index person

     lastly we will traverse the array and if this index don't know anyone means(0) and everyone knows him(arr.length -1)
     * T.C - O(n*n)+O(n)
     * S.C - O(2n)
     */
    public static int findCelebrity(int[][]arr){
        int[]iknow = new int[arr.length];
        int[]knowsMe = new int[arr.length];

        for(int i = 0; i<arr.length; i++){
            for(int j = 0; j<arr.length; j++){
                if(arr[i][j] == 1){
                    iknow[i]++;
                    knowsMe[j]++;
                }
            }
        }

        for(int i = 0; i<arr.length; i++){
            if(iknow[i] == 0 && knowsMe[i] == arr.length-1){
                return i;
            }
        }
        return -1;
    }

    /*
     * Approach: we will main two pointer one at top and one at bottom and check if top is know anyone if true move top and
     * same for bottom if bottom know anyone move bottom until top < bottom. In this way we reject whoever knows any one and we
     * got the last person.
     * 
     * Now to validate we will traverse that row and that column to check if any person not know this index and this index should not know anyone.
     * 
     * logic: 
     * 
     * Initialize two pointers, one at the top (start) and one at the bottom (end) of the matrix
Compare the individuals at the top and bottom pointers
If the person at the top pointer knows the person at the bottom pointer, move the top pointer down (the top person cannot be the celebrity)
If the person at the bottom pointer knows the person at the top pointer, move the bottom pointer up (the bottom person cannot be the celebrity)
If neither knows the other, increment both pointers (neither can be the celebrity)
After the traversal, the remaining candidate at the top pointer is the potential celebrity
Check if the candidate is a valid celebrity by ensuring that everyone knows this person and this person knows no one
If the candidate is valid, return the index; otherwise, return -1 indicating no celebrity

        T.C - O(2n)+O(n);
        S.C - O(1)
     */
    public static int findCelebrityOptimize(int[][]arr){
        int top = 0, down = arr.length-1;
        while(top < down){
            if(arr[top][down] == 1){
                top++;
            }
            else if(arr[down][top] == 1){
                down--;
            }
            else{
                top++;
                down--;
            }
        }

        if(top > down) return -1;
        for(int i = 0; i<arr.length; i++){
            if(i == top) continue;
            if(arr[top][i] == 1 && arr[i][top] == 0){
                return -1;
            }
        }
        return top;
    }
}
