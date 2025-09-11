package StackAndQueue;

import java.util.Stack;

class QueueUsingStack {
    public static void main(String[]args){
        QueueClass qt = new QueueClass();
        qt.push(3);
        qt.push(4);
        qt.push(2);
        System.out.println("The first element is: "+qt.peek());
        System.out.println("Deleting first element:"+qt.pop());
        System.out.println("The size of queue is: "+qt.size());
    }
}

class QueueClass{
    Stack<Integer>st1 = new Stack<>();
    Stack<Integer>st2 = new Stack<>();
    int first = 0;

    void push(int x){
        if(st1.empty()){
            first = x;
        }
        st1.push(x);
    }

    /*storing first stack data to second stack in reverse order so the top of second stack will be
     * first element in queue.
     */
    int pop(){
        if(st2.empty()){
            while(!st1.empty()){
                int val = st1.pop();
                st2.push(val);
            }
        }

        return st2.pop();
    }

    int peek(){
        if(!st2.empty()){
            return st2.peek();
        }
        return first;
    }

    int size(){
        if(st2.empty() && st1.empty()){
            return 0;
        }
        if(st2.empty()){
            return st1.size();
        }
        return st2.size();
    }

    boolean empty(){
        if(st2.empty() && st1.empty()){
            return true;
        }
        return false;
    }


}