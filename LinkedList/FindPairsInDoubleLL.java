package LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

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
public class FindPairsInDoubleLL {
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

        ArrayList<ArrayList<Integer>>ans = findPair(head,x);
        
    }

    public static ArrayList<ArrayList<Integer>> findPair(Node temp,int target){
        Node ptr1 = temp, ptr2 = temp;
        while(ptr2.next != null){
            ptr2 = ptr2.next;
        }
        ArrayList<ArrayList<Integer>>res = new ArrayList<>();

        while(ptr1 != ptr2 && ptr2.next != ptr1){

            int sum = ptr1.data+ptr2.data;

            if(sum == target){
                ArrayList<Integer>a = new ArrayList<>();
                a.add(ptr1.data);
                a.add(ptr2.data);
                res.add(a);

                ptr1 = ptr1.next;
                ptr2 = ptr2.prev;

            }
            else if(sum < target){
                ptr1 = ptr1.next;
            }
            else{
                ptr2  = ptr2.prev;
            }
        }
        return res;
    }
}
