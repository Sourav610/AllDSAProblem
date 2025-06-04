package Recursion;
import java.util.Stack;

public class ReverseStack {
    public static void sortedInsert(Stack<Integer> s, int x) {
        if (s.isEmpty()) {
            s.push(x);
            return;
        }
        int temp = s.pop();
        sortedInsert(s, x);
        s.push(temp);
    }

    public static void sort(Stack<Integer> s) {
        if (!s.isEmpty()) {
            int x = s.pop();
            sort(s);
            sortedInsert(s, x);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();

        s.push(11);
        s.push(2);
        s.push(32);
        s.push(3);
        s.push(41);

        sort(s);

        System.out.println("After reversing: ");
        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
        System.out.println();
    }
}