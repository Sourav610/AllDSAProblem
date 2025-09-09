package StackAndQueue;

import java.io.IOException;
import java.util.ArrayList;

/*
 * creating stack using array.
 */
public class StackUsingArray {
    static ArrayList<Integer>arr = new ArrayList<>();
    static int i = 0, j = 0;
    public static void main(String[]args)throws IOException{
        
        push(4);
        push(3);
        push(6);
        push(8);
        pop();
        System.out.println("The top value is: "+top());
        System.out.println("The size of stack is: "+size());

        //second approach
        stack st = new stack();
        System.out.println("The top value is: "+st.top());
        System.out.println("The size of stack is: "+st.size());
    }

    public static void push(int val){
        arr.add(val);
        j++;
    }

    public static void pop(){
        arr.remove(j-1);
        j--;
    }

    public static int top(){
        if(arr.isEmpty()){
            return -1;
        }
        return arr.get(j-1);
    }

    public static int size(){
        return j-i;
    }

}

class stack {
    int size = 10000;
    int arr[] = new int[size];
    int top = -1;
    void push(int x) {
        top++;
        arr[top] = x;
    }
    int pop() {
        if(top >= 0){
            int x = arr[top];
            top--;
            return x;
        }
        return -1;
        
    }
    int top() {
        if(top < 0){
            return -1;
        }
        return arr[top];
    }
    int size() {
        return top + 1;
    }
}
