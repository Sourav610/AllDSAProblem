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
public class AddTwoLinkedList {
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

        System.out.println("Enter the size of an array: ");
        int m = Integer.parseInt(br.readLine());
    
        int arr2[] = new int[m];
        System.out.println("Enter "+m+" element: ");
        for(int i = 0; i<m; i++){
            arr2[i] = Integer.parseInt(br.readLine());
        }

        Node temp2 = new Node(arr2[0]);
        Node head2 = temp2;

        for(int i = 1; i<arr2.length; i++){
            Node test = new Node(arr2[i]);
            temp2.next = test;
            temp2 = temp2.next;
        }
        // head = AddTwo(head,head2);
        head = simplerAddTwo(head,head2);
        while(head != null){
            System.out.println("The value is :"+head.data);
            head = head.next;
        }
    }

    public static Node AddTwo(Node head1,Node head2){
        Node num1 = head1;
        Node num2 = head2;
        Node dummy = new Node(0);
        Node prev = dummy;

        int carry = 0;
        while(num1 != null && num2 != null){
           int val = (num1.data+num2.data + carry)%10;
            Node newNode = new Node(val);
            carry  = (num1.data+num2.data+carry)/10;
            prev.next = newNode;
            prev = prev.next;
            num1 = num1.next;
            num2 = num2.next;
        }

       if(num1 != null){
         prev.next = num1;
         while(num1 != null){
            int val = (num1.data+carry)%10;
            carry = (num1.data+carry)/10;
            num1.data = val;
            prev = num1;
            num1 = num1.next;
         }
       }

       if(num2 != null){
         prev.next = num2;
         while(num2 != null){
            int val = (num2.data+carry)%10;
            carry = (num2.data+carry)/10;
            num2.data = val;
            prev = num2;
            num2 = num2.next;
         }
       }

       if(carry != 0){
        Node newNode = new Node(carry);
        prev.next = newNode;
       }
        return dummy.next;
    }

    public static Node simplerAddTwo(Node temp1, Node temp2){
        Node dummy = new Node(0);
        Node curr = dummy;
        int carry = 0;

        while(temp1 != null || temp2 != null || carry != 0){
            int x = temp1 != null?temp1.data:0;
            int y = temp2 != null?temp2.data:0;

            int sum = x+y+carry;
            carry = sum/10;
            curr.next = new Node(sum%10);
            curr = curr.next;

            temp1 = temp1 !=null?temp1.next:null;
            temp2 = temp2 != null? temp2.next:null;
        }
        return dummy.next;
        
    }

}
