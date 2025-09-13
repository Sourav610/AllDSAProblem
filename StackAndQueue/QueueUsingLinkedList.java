package StackAndQueue;

public class QueueUsingLinkedList {
    public static void main(String[]args){
        Queue temp = new Queue();
        temp.push(5);
        temp.push(7);
        temp.push(8);
        temp.push(9);
        System.out.println("The top element is: "+temp.peek());
        temp.pop();
        System.out.println("The top element is after poping: "+temp.peek());
        System.out.println("The size of queue is: "+temp.size());
    }
}

class Queue{
    private class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    Node start;
    Node head = null;
    int size = 0;

    void push(int x){
        Node newElement = new Node(x);
        if(head == null){
            head = newElement;
            start = newElement;
        }
        else{
            start.next = newElement;
            start = start.next;
        }
        size++;
    }

    void pop(){
        if(head != null){
            head = head.next;
        }
        else{
            System.out.println("Queue is empty");
        }
        size--;
    }

    int peek(){
        if(head == null){
            return -1;
        }
        return head.data;
    }

    boolean empty(){
        if(size == 0){
            return true;
        }
        return false;
    }

    int size(){
        return size;
    }


}
