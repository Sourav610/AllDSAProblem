package LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SearchInLinkedList {
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

        System.out.println("Enter the key value: ");
        int k = Integer.parseInt(br.readLine());

        boolean ans = findKey(head,k);
        System.out.println("The key is found in linked list: "+ans);

    }

    //recursive approach time complexity is O(n) and space complexity is O(n)
    public static boolean findKey(Node temp, int key){
        if(temp == null){
            return false;
        }
        if(temp.data == key){
            return true;
        }
        return findKey(temp.next,key);
    }
}
