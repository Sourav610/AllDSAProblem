package LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountLinkedListNode {
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

        int length = findLength(head);
        System.out.println("The lenght of linked list is: "+length);

    }

    //recursive approach time complexity is O(n) and space complexity is O(n)
    public static int findLength(Node temp){
        if(temp == null){
            return 0;
        }
        return 1+ findLength(temp.next);
    }
}
