package LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        next = null;
    }
}

public class InsertElementAtEndOfLinkedList {
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

        System.out.println("Enter key to be added: ");
        int k = Integer.parseInt(br.readLine());

        Node temp = new Node(arr[0]);
        Node head = temp;

        for(int i = 1; i<arr.length; i++){
            Node test = new Node(arr[i]);
            temp.next = test;
            temp = temp.next;
        }

        Node ans = insertAtLast(head,k);

        while(ans != null){
            System.out.println("The value is :"+ans.data);
            ans = ans.next;
        }

    }

    public static Node insertAtLast(Node temp, int k){
        if(temp == null){
            return new Node(k);
        }

        Node test = temp;
        while(test.next != null){
            test = test.next;
        }
        Node last = new Node(k);
        test.next = last;
        return temp;
    }
}
