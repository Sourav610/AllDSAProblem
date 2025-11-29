package StackAndQueue;

import java.util.HashMap;
import java.util.Map;

/*
Approach:


Initialize the cache with a specified capacity
Create dummy head and tail nodes for each frequency list to simplify edge case handling
For updating frequency, when a node is accessed or updated:
Remove the node from its current frequency list
If this was the only node in the minimum frequency list, increment the minimum frequency
Increment the node's frequency and add it to the front of the list corresponding to the new frequency
Update both hash maps (keyNode and freqNode) to reflect the changes
For the "get" operation, check if the key exists in the keyNode map:
If present, retrieve the node, update its frequency, and return its value
If not present, return -1
For the "put" operation:
If the key already exists in keyNode, update its value, update its frequency, and return
If not present, check if the cache is at capacity
If at capacity, remove the least frequently used node (node with the minimum frequency and least recent usage)
Create a new node for the key-value pair, set its frequency to 1, and add it to the front of the frequency list for nodes with frequency 1
Update both hash maps to reflect the addition of the new node
*/


class Node{
    int key, value, cnt;
    Node next;
    Node prev;

    Node(int _key, int _val){
        key = _key;
        value = _val;
        cnt = 1;
    }
}

class List{
    int size;
    Node head;
    Node tail;


    List(){
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;

        size = 0;
    }

    void addFront(Node node){
        Node temp = head.next;
        node.next = temp;
        node.prev= head;
        head.next = node;
        temp.prev = node;
        size++;
    }

    void removeNode(Node delNode){
        Node prevNode = delNode.prev;
        Node nextNode = delNode.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        size--;
    }

}

class TestLFU{
    private Map<Integer,Node>keyNode;
    private Map<Integer,List>freqlistMap;
    private int maxSizeCache;
    private int minFreq;
    private int curSize;

    public TestLFU(int capacity){
        maxSizeCache = capacity;
        minFreq = 0;
        curSize = 0;
        keyNode = new HashMap<>();
        freqlistMap = new HashMap();
    }

    private void updateFreqListMap(Node node){
        keyNode.remove(node.key);
        freqlistMap.get(node.cnt).removeNode(node);

        if(node.cnt == minFreq && freqlistMap.get(node.cnt).size ==  0){
            minFreq++;
        }

        List nextHigherFreqList = new List();

        if(freqlistMap.containsKey(node.cnt+1)){
            nextHigherFreqList = freqlistMap.get(node.cnt+1);
        }
        node.cnt += 1;
        nextHigherFreqList.addFront(node);
        freqlistMap.put(node.cnt,nextHigherFreqList);
        keyNode.put(node.key, node);
    }

    public int getKey(int key){
        if(keyNode.containsKey(key)){
            Node node = keyNode.get(key);
            int val = node.value;
            updateFreqListMap(node);
            return val;
        }
        return -1;
    }

    public void put(int key, int value){
        if(maxSizeCache == 0){
            return;
        }

        if(keyNode.containsKey(key)){
            Node node = keyNode.get(key);
            node.value = value;
            updateFreqListMap(node);
        }
        else{
            if(curSize == maxSizeCache){
                List list = freqlistMap.get(minFreq);
                keyNode.remove(list.tail.prev.key);

                freqlistMap.get(minFreq).removeNode(list.tail.prev);

                curSize--;
            }
            curSize++;
            minFreq = 1;
            List listFreq = new List();

            if(freqlistMap.containsKey(minFreq)){
                listFreq = freqlistMap.get(minFreq);
            }
            Node node = new Node(key, value);
            listFreq.addFront(node);
            keyNode.put(key,node);
            freqlistMap.put(minFreq,listFreq);
        }
    }
}
public class LFUCache {
    public static void main(String[] args) {
        // LFU Cache
        TestLFU cache = new TestLFU(2);
        
        // Queries
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.print(cache.getKey(1) + " ");
        cache.put(3, 3);
        System.out.print(cache.getKey(2) + " ");
        System.out.print(cache.getKey(3) + " ");
        cache.put(4, 4);
        System.out.print(cache.getKey(1) + " ");
        System.out.print(cache.getKey(3) + " ");
        System.out.print(cache.getKey(4) + " ");
    }
}
