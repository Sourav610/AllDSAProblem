package LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DeleteNodeInDoubleLL {
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

        Node temp = new Node(arr[0]);
        Node head = temp;

        for(int i = 1; i<arr.length; i++){
            Node test = new Node(arr[i]);
            test.prev = temp;
            temp.next = test;
            temp = temp.next;
        }

        head =  deleteNode(head,pos);

        while(head != null){
            System.out.println("The value is :"+head.data);
            head = head.next;
        }
    }
    public static Node deleteNode(Node head, int x) {
        // Initializing del node with head.
        Node del = head;
        x = x - 1;

        // Iterating till the position given in parameter.
        while (x-- > 0) {
            del = del.next;
        }

        /* Base case */
        // If head or del is null, return null.
        if (head == null || del == null) {
            return null;
        }

        /* If Node to be deleted is head Node */
        // If del is equal to head, update head to next node.
        if (head == del) {
            head = del.next;
        }

        /* Change next only if Node to be deleted is NOT the last Node */
        // If del next is not null, update previous node of del next to del previous.
        if (del.next != null) {
            del.next.prev = del.prev;
        }

        /* Change prev only if Node to be deleted is NOT the first Node */
        // If del previous is not null, update next node of del previous to del next.
        if (del.prev != null) {
            del.prev.next = del.next;
        }

        // Return updated head.
        return head;
    }
}
