package Heaps;

import java.util.PriorityQueue;
import java.util.Collections;

public class MedianFromDataStream {

    PriorityQueue<Integer>minHeap;
    PriorityQueue<Integer>maxHeap;

    public MedianFromDataStream(){
        minHeap = new PriorityQueue<Integer>();
        maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
    }

    public void addNum(int num){
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());

        if(minHeap.size() > maxHeap.size()){
            maxHeap.offer(minHeap.poll());
        }

    }

    public double findMeadian(){
        if(minHeap.size() == maxHeap.size()){
            return (minHeap.peek()+maxHeap.peek())/2.0;
        }
        return maxHeap.peek();
    }

    public static void main(String[]args){
        MedianFromDataStream md = new MedianFromDataStream();
        md.addNum(1);
        md.addNum(2);
        md.addNum(3);
        
        System.out.println(md.findMeadian());
    }

    
}
