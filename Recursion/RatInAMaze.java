import java.util.ArrayList;

public class RatInAMaze {
    public static void main(String []args){
        int[][]arr = {
            {1,0,0,0},
            {0,1,0,1},
            {1,1,0,0},
            {0,1,1,1}
        };

        ArrayList<String>ans = new ArrayList<>();
        boolean[][]vis = new boolean[4][4];
        solveMaze(0,0,arr,ans,vis,"");
        for(String i:ans){
            System.out.println(i+"");
        }
    }

    public static void solveMaze(int row, int col,int[][]arr,ArrayList<String>ans,boolean[][]vis,String s){
        if(row == arr.length-1 && col == arr.length-1){
            ans.add(s);
            return;
        }
        

        if(row < 0 || col < 0 || row >= arr.length || col >= arr.length || vis[row][col] == true || arr[row][col] == 0){
            return;
        }

        vis[row][col] = true;
        solveMaze(row-1, col,arr,ans,vis,s+"U");
        solveMaze(row, col+1,arr,ans,vis,s+"R");
        solveMaze(row+1, col,arr,ans,vis,s+"D");
        solveMaze(row, col-1,arr,ans,vis,s+"L");
        vis[row][col] = false;
    }
}
