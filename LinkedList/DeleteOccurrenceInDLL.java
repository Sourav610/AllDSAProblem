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

public class DeleteOccurrenceInDLL {
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

        System.out.println("Enter the value you want to delete: ");
        int x = Integer.parseInt(br.readLine());

        head = DeleteOccurrence(head,x);
        while(head != null){
            System.out.println("The value is :"+head.data);
            head = head.next;
        }
    }

    public static Node DeleteOccurrence(Node temp,int x){
        Node curr = temp;
        Node next;
        if(temp == null)return null;
        while(curr != null){
            if(curr.data == x){
                next = curr.next;
                temp = deleteEle(curr,temp);
                curr = next;
            }
            else{
                curr = curr.next;
            }
        }
        return temp;
    }

    public static Node deleteEle(Node curr, Node head){
        if(curr == null || head == null) return null;

        if(curr == head) head = curr.next;

        if(curr.next != null) curr.next.prev = curr.prev;

        if(curr.prev != null) curr.prev.next = curr.next;

        curr = null;

        return head;
    }
}
