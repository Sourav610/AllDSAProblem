package LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class Node {
    int data;
    Node prev;
    Node next;

    Node(int data){
        this.data = data;
        prev = null;
        next = null;
    }
}

public class CreatingDoubleLinkedList {
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
            test.prev = temp;
            temp.next = test;
            temp = temp.next;
        }

        while(head != null){
            System.out.println("The value is :"+head.data);
            head = head.next;
        }
    }
}
