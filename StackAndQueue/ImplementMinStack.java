package StackAndQueue;
import java.util.Stack;

/*
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.



Solution: always think of pair with value x and minVal y till now
 */
public class ImplementMinStack{
    public static void main(String[]args){
        MinStack ms = new MinStack();
        ms.push(5);
        ms.push(-6);
        ms.push(8);
        ms.push(-2);
        ms.push(10);
        ms.pop();
        System.out.println("The top value is: "+ms.top());
        System.out.println("The min value is "+ms.getMin());
    }
}

class Pair{
    int x, y;
    Pair(int x,int y){
        this.x = x;
        this.y = y;
    }
}

class MinStack{
    Stack<Pair>st = new Stack();

    void push(int x){
        int min;
        if(st.empty()){
            min = x;
        }
        else{
            min = Math.min(st.peek().y, x);
        }
        st.push(new Pair(x, min));
    }

    void pop(){
        st.pop();
    }

    int top(){
        return st.peek().x;
    }

    int getMin(){
        return st.peek().y;
    }
}

