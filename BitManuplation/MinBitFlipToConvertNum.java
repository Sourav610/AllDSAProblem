import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinBitFlipToConvertNum {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int start, goal;
        System.out.println("Enter first num: ");
        start = Integer.parseInt(br.readLine());
        System.out.println("Enter last num: ");
        goal = Integer.parseInt(br.readLine());

        int count = 0;
        //Brute force
        // count = calculateBits(start, goal);

        //Optimize using bit wise
        /*
         * here we take xor of two number then result we get set bit if there 
         is difference in bit else 0 if no differenct.Then we calculate the set bit result
         */
        count = calculateBitsOptimize(start, goal);

        System.out.println("The result is: "+count);
    }

    public static int calculateBits(int start, int goal){
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        while(start!= 0){
            if((start&1) == 1){
                sb.append("1");
            }
            else{
                sb.append("0");
            }
            start = start>>1;
        }

        sb.reverse();

        while(goal!= 0){
            if((goal&1) == 1){
                sb2.append("1");
            }
            else{
                sb2.append("0");
            }
            goal = goal>>1;
        }

        sb2.reverse();

         int i = sb.length()-1,j = sb2.length()-1; 
        int count = 0;
        String str1 = sb.toString();
        String str2 = sb2.toString();
        while(i>= 0 && j>= 0 ){
            if(str1.charAt(i) != str2.charAt(j)){
                count++;
            }
            i--;
            j--;
        }

        while(i>=0){
            if(str1.charAt(i) == '1'){
                count++;
            }
            i--;
        }
        while(j>=0){
            if(str2.charAt(j) == '1'){
                count++;
            }
            j--;
        }
        return count;
    }

    public static int calculateBitsOptimize(int start, int goal){
        int res = 0;
        res = start^goal;
        int count = 0; 
        while(res != 0){
            res = res&(res-1);
            count++;
        }

        return count;
    }
}
