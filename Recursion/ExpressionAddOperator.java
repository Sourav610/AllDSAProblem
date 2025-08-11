import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Solution {
  
    public static void recurse(
        int index, long previousOperand, long currentOperand, long value, ArrayList<String> ops,String nums,int target,List<String> result) {
          
              // Done processing all the digits in num
              if (index == nums.length()) {
          
                // If the final value == target expected AND
                // no operand is left unprocessed
                if (value == target && currentOperand == 0) {
                  StringBuilder sb = new StringBuilder();
                  ops.subList(1, ops.size()).forEach(v -> sb.append(v));
                  result.add(sb.toString());
                }
                return;
              }
          
              // Extending the current operand by one digit
              currentOperand = currentOperand * 10 + Character.getNumericValue(nums.charAt(index));
              String current_val_rep = Long.toString(currentOperand);
          
              // To avoid cases where we have 1 + 05 or 1 * 05 since 05 won't be a
              // valid operand. Hence this check
              if (currentOperand > 0) {
          
                // NO OP recursion
                recurse(index + 1, previousOperand, currentOperand, value, ops,nums,target,result);
              }
          
              // ADDITION
              ops.add("+");
              ops.add(current_val_rep);
              recurse(index + 1, currentOperand, 0, value + currentOperand, ops,nums,target,result);
              ops.remove(ops.size() - 1);
              ops.remove(ops.size() - 1);
          
              if (ops.size() > 0) {
          
                // SUBTRACTION
                ops.add("-");
                ops.add(current_val_rep);
                recurse(index + 1, -currentOperand, 0, value - currentOperand, ops,nums,target,result);
                ops.remove(ops.size() - 1);
                ops.remove(ops.size() - 1);
          
                // MULTIPLICATION
                ops.add("*");
                ops.add(current_val_rep);
                recurse(
                    index + 1,
                    currentOperand * previousOperand,
                    0,
                    value - previousOperand + (currentOperand * previousOperand),
                    ops,
                    nums,target,result);
        ops.remove(ops.size() - 1);
        ops.remove(ops.size() - 1);
      }
    }
  
    public static void addOperators(String num, int target,List<String>result) {
      
        if (num.length() == 0) {
        return ;
      }      
       recurse(0, 0, 0, 0, new ArrayList<String>(),num,target, result);
    }
    
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a number: ");
        String num = br.readLine();
        System.out.println("Enter a target value: ");
        int target = Integer.parseInt(br.readLine());
        ArrayList<String>result = new ArrayList<>();
        addOperators(num,target,result);
        
        System.out.println("The result is : ");
        for(int i = 0; i<result.size(); i++){
            System.out.println(result.get(i));
        }
    }   
        
}