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

public class PalindromeLinkedList {
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

        boolean ans = checkPalindrome(head);
        System.out.println("The given linked list is palindrome:"+ans);
    }

    public static boolean checkPalindrome(Node head){
        Node slow =head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        Node prev = slow;
        Node temp = null;
        while(slow != null){
            Node curr = slow;
            slow = slow.next;
            curr.next = temp;
            temp = curr;
        }

        Node first = head;
        while(first != prev && temp != null){
            if(first.data != temp.data){
                return false;
            }
            first = first.next;
            temp = temp.next;
        }
        return true;
    }
}


