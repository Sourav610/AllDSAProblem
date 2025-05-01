package LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Node{
    int data;
    Node next;

    Node(int val){
        data = val;
        next = null;
    }
}
public class MiddleOfTheLinkedList {
    public static void main(String[]args) throws IOException{
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of an array: ");
        n = Integer.parseInt(br.readLine());
        
        int arr[] = new int[n];

        System.out.println("Enter "+n+" element: ");
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Node head = new Node(arr[0]);
        Node temp = head;
        for(int i = 1; i<arr.length; i++){
            Node test = new Node(arr[i]);
            temp.next = test;
            temp = temp.next;
        }
        //using slow and fast pointer to find middle
        head = returnMiddle(head);

        while(head != null){
            System.out.println("The value is :"+head.data);
            head = head.next;
        }
    }

    public static Node returnMiddle(Node temp){
        Node slow = temp;
        Node fast = temp;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
