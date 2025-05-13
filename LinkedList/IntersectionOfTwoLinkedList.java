package LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


class Node {
    int data;
    Node next;
    Node(int d){
        data = d;
        next = null;
    }
}
public class IntersectionOfTwoLinkedList {
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

        System.out.println("Enter the size of an array: ");
        int m = Integer.parseInt(br.readLine());
        int arr2[]= new int[m];
        System.out.println("Enter "+m+" element: ");
        for(int i = 0; i<m; i++){
            arr2[i] = Integer.parseInt(br.readLine());
        }

        Node temp = new Node(arr[0]);
        Node head = temp;

        for(int i = 1; i<arr.length; i++){
            Node test = new Node(arr[i]);
            temp.next = test;
            temp = temp.next;
        }

        Node temp2 = new Node(arr2[0]);
        Node head1 = temp2;

        for(int i = 1; i<arr2.length; i++){
            Node test = new Node(arr2[i]);
            temp2.next = test;
            temp2 = temp2.next;
        }

        temp2.next = head;
        System.out.println("Searching intersection:");
        Node intersectingPoint = null;
        // intersectingPoint = findIntersection(head,head1);
        intersectingPoint = usingTwoPointer(head,head1);

       System.out.println("The intersecting point is "+intersectingPoint.data);
    }

    public static Node findIntersection(Node temp1,Node temp2){
        HashMap<Node,Integer>mp = new HashMap<>();
        while(temp1 != null){
            mp.put(temp1,mp.getOrDefault(temp1, 0)+1);
            temp1 = temp1.next;
        }

        while(temp2 != null){
            if(mp.containsKey(temp2)){
                return temp2;
            }
            temp2 = temp2.next;
        }
        return null;
    }

    public static Node usingTwoPointer(Node temp1, Node temp2){
        Node a = temp1;
        Node b = temp2;

        while(a != b){
            a = a == null?temp2:a.next;
            b = b == null?temp1:b.next;
        }
        return a;
    }
}
