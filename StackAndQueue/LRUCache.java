package StackAndQueue;
/*
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. Otherwise, 
add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
The functions get and put must each run in O(1) average time complexity.

 

Example 1:

Input
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, null, -1, 3, 4]



Approach:
we using linked list to store the element and when new element came or get any element we store it after the head and put the key and its addres
in map so when getting an element with key we can directly search the address and get the value. when taking least recently used element it 
will be always before the tail

T.C - O(n)
S.C - O(1)

 */

import java.util.HashMap;
import java.util.Map;

class Node{
    int key;
    int val;
    Node next;
    Node prev;

    Node(int key1,int val1){
        key = key1;
        val = val1;
    }
}

public class LRUCache {

    Node head = new Node(-1,-1);
    Node tail = new Node(-1,-1);
    int size = 0;
    Map<Integer,Node>mp = new HashMap();
    

    void addNode(Node newNode){
        Node temp = head.next;
        newNode.next = temp;
        newNode.prev = head;
        temp.prev = newNode;
        head.next = newNode;
        mp.put(newNode.key, newNode); 
    }

    void delNode(Node newNode){
        mp.remove(newNode.key);
        Node delNodeNext = newNode.next;
        Node delNodePrev = newNode.prev;
        delNodeNext.prev = delNodePrev;
        delNodePrev.next = delNodeNext;
    }

    public LRUCache(int _capacity) {
        size = _capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key){
        if(mp.containsKey(key)){
            Node temp = mp.get(key);
            delNode(temp);
            addNode(temp);
            return temp.val;
        }
        return -1;
    }

    public void put(int key, int val){
        if(mp.containsKey(key)){
            delNode(mp.get(key));
        }
        if(mp.size() == size){
            delNode(tail.prev);
        }
        addNode(new Node(key, val));
    }

    public static void main(String[]args){
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2,2);
        System.out.println("The value is : "+cache.get(1));
        cache.put(3,3);
        System.out.println("The value is : "+cache.get(2));
        cache.put(4,4);
        System.out.println("The value is : "+cache.get(1));
        System.out.println("The value is : "+cache.get(3));
        System.out.println("The value is : "+cache.get(4));      

    }
}
