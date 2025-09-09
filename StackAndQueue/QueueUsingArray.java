package StackAndQueue;


public class QueueUsingArray {
    public static void main(String[]args){
        queue qt = new queue();
        qt.push(4);
       qt.push(14);
       qt.push(24);
       qt.push(34);
       System.out.println("The top element is : "+qt.top());
       System.out.println("The size of the queue is : "+qt.size());
       qt.pop();
    }
}

class queue{
    int size = 10000;
    int[] arr = new int[size];
    int first = 0, last = 0;

    public void push(int val){
        arr[last] = val;
        last++;
    }

    public int top(){
        if(last < 0){
            return -1;
        }
        return arr[last-1];
    }

    public void pop(){
        if(first < 0){
            return;
        }
        first++;
    }

    public int size(){
        return last-first;
    }
}