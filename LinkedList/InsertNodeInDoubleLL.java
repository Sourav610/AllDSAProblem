package LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Node{
    int data;
    Node next;
    Node prev=null;

    Node(int val){
        data = val;
        next = null;
        prev = null;
    }
}

public class InsertNodeInDoubleLL {
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

        System.out.println("enter the position you want to enter element: ");
        int pos = Integer.parseInt(br.readLine());

        System.out.println("Enter the value: ");
        int val = Integer.parseInt(br.readLine());
        Node temp = new Node(arr[0]);
        Node head = temp;

        for(int i = 1; i<arr.length; i++){
            Node test = new Node(arr[i]);
            test.prev = temp;
            temp.next = test;
            temp = temp.next;
        }

        head = insertNode(head,pos,val);

        while(head != null){
            System.out.println("The value is :"+head.data);
            head = head.next;
        }
    }

    public static Node insertNode(Node head, int x, int val){

        Node temp = head;
        Node prev = null;
        while(x != 1){
            prev = temp;
            temp = temp.next;
            x--;
        }

        if(temp == head){
            Node node = new Node(val);
            node.next = head;
            head.prev = node;
        }

        if(temp.next != null){
            Node node  = new Node(val);
            prev.next = node;
            node.next = temp;
            node.prev = prev;
            temp.prev = node;
        }

        if(temp.next == null){
            Node node =new Node(val);
            temp.next = node;
            node.prev = temp;
        }

        return head;  
    }
}
