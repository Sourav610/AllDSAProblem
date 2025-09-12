package StackAndQueue;

public class StackUsingLinkedList {
    public static void main(String[]args){
        Stack val = new Stack();
        val.stackPush(5);
        val.stackPush(2);
        val.stackPush(1);
        val.stackPush(4);
        val.stackPop();
        System.out.println("The top element is: "+val.stackTop());
        System.out.println("The Size of stack is: "+val.stackSize());
    }
}

class Stack{
    private class Node{
        int data;
        Node next;
        Node(int x){
            data = x;
            next = null;
        }
    }

    Node top;
    int size;
    void Node(){
        this.top = null;
        this.size = 0;
    }

    public void stackPush(int x){
        Node ele = new Node(x);
        ele.next = top;
        top = ele;
        System.out.println("Element pushed");
        size++;
    }

    public int stackPop(){
        if(top == null) return -1;
        int topData = top.data;
        top = top.next;
        size--;
        return topData;
    }
    
    public int stackSize(){
        return size;
    }

    public boolean isEmpty(){
        return top == null;
    }

    public int stackTop(){
        return top.data;
    }

}
