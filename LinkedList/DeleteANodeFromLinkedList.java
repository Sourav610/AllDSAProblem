package LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}
public class DeleteANodeFromLinkedList {
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

        Node temp = new Node(arr[0]);
        Node head = temp;

        for(int i = 1; i<arr.length; i++){
            Node test = new Node(arr[i]);
            temp.next = test;
            temp = temp.next;
        }
        Node test = head.next.next;
        deleteNode(test);

        while(head != null){
            System.out.println("The value is :"+head.data);
            head = head.next;
        }
    }

    public static void deleteNode(Node test){
        while(test.next.next != null){
            test.data = test.next.data;
            test = test.next;
        }
        test.data = test.next.data;
        test.next = null;
    }
}
