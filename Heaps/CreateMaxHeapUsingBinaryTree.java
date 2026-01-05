package Heaps;



class MaxBinaryHeap{
    // Maximum elements that can be stored in heap
  int capacity;

  // Current no of elements in heap
  int size;

  // Array for storing the keys
  int arr[];

  MaxBinaryHeap(int cap){
        // Assigning the capacity
      capacity = cap;

       // Initially size of heap is zero
      size = 0;

      arr = new int[capacity];
  }

   // Returns the parent of ith Node
  int parent(int i){
      return (i-1)/2;
  }

   // Returns the left child of ith Node
  int Left(int i){
      return i*2+1;
  }


  // Returns the right child of the ith Node
  int Right(int i){
      return i*2+2;
  }


  // Insert a new key x
  void Insert(int x){
      if(size == capacity){
          System.out.println("Binary heap overflow");
          return;
      }

      // Insert new element at end
      arr[size] = x;

        // Store the index, for checking heap property
      int k = size;
      size++;

      // Fix the max heap property
      while(k != 0 && arr[parent(k)] < arr[k]){
          int temp = arr[parent(k)];
          arr[parent(k)] = arr[k];
          arr[k] = temp;
          k = parent(k);
      }
  }

  void Heapify(int ind){
      //right child
      int ri = Right(ind);

      //left child
      int li = Left(ind);

      //initially assume violated value is minimum
      int largest = ind;

      if(li < size && arr[li] > arr[largest]){
          largest = li;
      }

      if(ri < size && arr[ri] > arr[largest]){
          largest = ri;
      }

       // If the Minimum among the three nodes is not the parent itself,
      // then swap and call Heapify recursively
      if(largest != ind){
          int temp = arr[ind];
          arr[ind] = arr[largest];
          arr[largest] = temp;
          Heapify(largest);
      }
  }

  int getMax(){
    if (size <= 0)
        throw new IllegalStateException("Heap is empty");
    return arr[0];
  }

  int ExtractMax(){
      if(size <= 0){
          return Integer.MAX_VALUE;
      }

      if(size == 1){
          size--;
          return arr[0];
      }

      int max = arr[0];

      // Copy last Node value to root Node
      arr[0] = arr[size-1];   

      size--;
      
      // Call heapify on root node
      Heapify(0);

      return max;
  }

  void IncreaseKey(int i , int val){
      //updating the new val
      arr[i] = val;

      //fixing the Min heap
      while(i !=  0 && arr[parent(i)] < arr[i]){
          int temp = arr[parent(i)];
          arr[parent(i)] = arr[i];
          arr[i] = temp;
          i = parent(i);
      }

  }

  void Delete(int i ){
      IncreaseKey(i, Integer.MAX_VALUE);
      ExtractMax();
  }

  void print() {
      for (int i = 0; i < size; i++)
        System.out.print(arr[i] + " ");
      System.out.println();
    }
}


public class CreateMaxHeapUsingBinaryTree {
    public static void main(String[]args){
        MaxBinaryHeap h = new MaxBinaryHeap(20);
        
        h.Insert(4);
        h.Insert(1);
        h.Insert(2);
        h.Insert(6);
        h.Insert(7);
        h.Insert(3);
        h.Insert(8);
        h.Insert(5);
    
        System.out.println("Max value is " + h.getMax());
    
        h.Insert(10);
        System.out.println("Max value is " + h.getMax());
    
        h.IncreaseKey(3, 12);
        System.out.println("Max value is " + h.getMax());
    
        h.ExtractMax();
        System.out.println("Max value is " + h.getMax());
    
        h.Delete(0);
        System.out.println("Max value is " + h.getMax());
    }
}
