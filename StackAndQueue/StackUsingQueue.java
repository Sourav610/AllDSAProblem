package StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    public static void main(String[]args){
        stack st = new stack();
        st.push(5);
        st.push(7);
        st.push(8);
        st.push(0);
        st.pop();
        System.out.println("The top element is : "+st.top());
        System.out.println("The size of stack is : "+st.size());
    }
}

class stack{
    Queue<Integer>qu = new LinkedList<>();
    int top = -1;

    void push(int x){
        qu.offer(x);
        top++;
    }

    int pop(){
        if(qu.isEmpty()){
            return -1;
        }
        int val = 0;
        int i = 0; 
        while(i<top){
            i++;
            val = qu.poll();
            qu.offer(val);
        }
        val = qu.poll();
        top--;
        return val;
    }

    int top(){
        if(qu.isEmpty()){
            return -1;
        }
        int val = 0;
        int i = 0; 
        while(i<top){
            i++;
            val = qu.poll();
            qu.offer(val);
        }
        val = qu.poll();
        qu.offer(val);
        return val;
    }

    int size(){
        return qu.size();
    }
}
