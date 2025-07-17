import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once
 */
public class wordSearch {
    public static void main(String[]args) throws IOException{
        char [][] arr = {
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        };
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a string to search: ");
        String str = br.readLine();

        boolean result = exist(arr,str);
        System.out.println("The word in arr exist: "+result);
    }
        
    public static boolean exist(char[][]arr,String str){
        boolean[][] visited = {
            {false,false,false,false},
            {false,false,false,false},
            {false,false,false,false}
        };
        
        int ind = 0;
        for(int i = 0; i<3; i++){
            for(int j = 0; j<4; j++){
                if(arr[i][j] == str.charAt(ind)){
                    if(search(arr,str,visited,i,j,ind)){
                        return true;
                    }
                }
            }
        }
        return false;

    }

    public static boolean search(char[][]arr, String str, boolean[][]visited,int r,int c, int ind){
        if(ind == str.length()){
            return true;
        }

        if(r<0 || c < 0 || r == arr.length || c == arr[0].length || visited[r][c] == true || arr[r][c] != str.charAt(ind)){
            return false;
        }

        visited[r][c] = true;
        boolean top = search(arr,str,visited,r-1,c,ind+1);
        boolean right = search(arr,str,visited,r,c+1,ind+1);
        boolean bottom = search(arr,str,visited,r+1,c,ind+1);
        boolean left = search(arr,str,visited,r,c-1,ind+1);

        visited[r][c] = false;
        return top || right || bottom || left;

    }
}
