package LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SortLinkedListZeroOneTwo{
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
        // head = sortList(head);
        head = sortUsingThreePointer(head);

        while(head != null){
            System.out.println("The value is :"+head.data);
            head = head.next;
        }
    }

    public static Node sortList(Node temp){
        if(temp == null || temp.next == null){
            return temp;
        }

        int[] cnt = new int[3];
        Node ptr = temp;

        while(ptr != null){
            cnt[ptr.data]++;
            ptr = ptr.next;
        }

        int idx = 0;
        ptr = temp;

        while(ptr != null){
            if(cnt[idx] == 0){
                idx++;
            }
            else{
                ptr.data = idx;
                cnt[idx]--;
                ptr = ptr.next;
            }
        }

        return temp;
    }

    public static Node sortUsingThreePointer(Node head){
        Node zeroD = new Node(0);
        Node oneD = new Node(0);
        Node twoD = new Node(0);
        Node zero = zeroD;
        Node one = oneD;
        Node two = twoD;
        Node temp = head;
        while(temp != null){
            if(temp.data == 0){
                zero.next = temp;
                zero = zero.next;
            }
            else if(temp.data == 1){
                one.next = temp;
                one = one.next;
            }
            else{
                two.next = temp;
                two = two.next;
            }
            Node prev = temp;
            temp = temp.next;
            prev.next = null;
        }
        if(oneD.next != null){
            zero.next = oneD.next;
        }
        else{
            zero.next = twoD.next;
        }
        one.next = twoD.next;
        head = zeroD.next;
        return head;
    }

} 
