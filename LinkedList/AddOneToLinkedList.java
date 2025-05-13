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
public class AddOneToLinkedList {
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
        // head = AddOne(head);
        // head = recursionAddOne(head);
        head = addOne(head);
        while(head != null){
            System.out.println("The value is :"+head.data);
            head = head.next;
        }
    }

    public static Node AddOne(Node head){
        Node prev = null;
        Node curr = head;
        while(curr != null){
            if(curr.data != 9){
                prev = curr;
            }
            curr = curr.next;
        }
        if(prev == null){
            Node node = new Node(1);
            node.next = head;
            prev = head;
            head = node;
            while(prev != null){
                prev.data = 0;
                prev = prev.next;
            }
        }
        else{
            prev.data += 1;
            prev = prev.next;
            while(prev != null){
                prev.data = 0;
                prev = prev.next;
            }
        }
        return head;
    }

    public static Node recursionAddOne(Node head){
        int carry = addCarry(head);

        if(carry != 0){
            Node node = new Node(carry);
            node.next = head;
            return node;
        }
        return head;
    }

    public static int addCarry(Node temp){
        if(temp == null){
            return 1;
        }

        int res = temp.data + addCarry(temp.next);

        temp.data = res%10;
        return res/10;
    }

    public static Node reverse(Node head)
    // this function reverses the linked list
    {
        Node prev = null;
        Node current = head;
        Node next;

        while (current != null) {
            next = current.next; // storing next node
            current.next = prev; // linking current node to previous
            prev = current;      // updating prev
            current = next;      // updating current
        }

        return prev;
    }

    public static Node addOne(Node head) {
        head = reverse(head); // reversing list to make addition easy

        Node current = head;
        int carry = 1;

        while (carry != 0) {
            current.data += 1; // adding one to current node

            if (current.data < 10) return reverse(head);
            // if no carry we can reverse back list and return it
            else
                current.data = 0;
            // else we continue with taking carry forward

            if (current.next == null) break;
            // if, end of list, we break from loop
            else
                current = current.next;
            // else we move to next node
        }

        current.next = new Node(1); // adding new node for the carried 1
        return reverse(head);
    }
}
