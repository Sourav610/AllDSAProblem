package LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class Node {
    int data;
    Node next;
    Node(int d){
        data = d;
        next = null;
    }
}

public class OddEvenLinkedList {
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

        Node ans = seperateOddEven(head);
        while(ans != null){
            System.out.println("The value is :"+ans.data);
            ans = ans.next;
        }
      
    }

    public static Node seperateOddEven(Node head){
        Node odd = head;
        Node even = head.next;
        Node evenHead = even;

        while(even != null && even.next != null){
            odd.next = odd.next.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}


