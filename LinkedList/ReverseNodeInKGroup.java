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
public class ReverseNodeInKGroup {
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

        System.out.println("Enter the number of group you want: ");
        int k = Integer.parseInt(br.readLine());
    
        head = reverseKGroup(head,k);
        while(head != null){
            System.out.println("The value is :"+head.data);
            head = head.next;
        }
    }

    public static Node reverseKGroup(Node head, int k){
        Node curr = head;
        Node prevLast = null;
        while(curr != null){
            Node kthNode = getKNode(curr, k);

            if(kthNode == null){
                if(prevLast != null){
                    prevLast.next = curr;
                }
                break;
            }

            Node next = kthNode.next;
            kthNode.next = null;
            reverse(curr);
            if(curr == head){
                head = kthNode;
            }
            else{
                prevLast.next = kthNode;
            }

            prevLast = curr;
            curr  = next;
        }
        return head;
    }

    public static Node getKNode(Node start, int k){
        k -= 1;

        while(start != null && k>0){
            k--;
            start = start.next;
        }
        return start;
    }

    public static Node reverse(Node temp){
        Node curr = temp;
        Node prev = null;

        while(curr != null){
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
