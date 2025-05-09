package LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SortLinkedList{
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
        head = sortList(head);

        while(head != null){
            System.out.println("The value is :"+head.data);
            head = head.next;
        }
    }

    public static Node sortList(Node temp){
        if(temp == null || temp.next == null){
            return temp;
        }

        Node fast = temp;
        Node slow = temp;
        Node prev = null;

        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        Node l1 = sortList(temp);
        Node l2 = sortList(slow);
        return merge(l1,l2);
    }

    public static Node merge(Node l1, Node l2){
        Node prev = new Node(0);
        Node curr = prev;

        while(l1 != null && l2 != null){
            if(l1.data < l2.data){
                curr.next = l1;
                l1 = l1.next;
            }
            else{
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        if(l1 != null){
            curr.next = l1;
        }
        if(l2 != null){
            curr.next = l2;
        }

        return prev.next;
    }
}