package heap;

import java.util.ArrayList;

public class Heap {
    /**
    * Visualization -> Heap (Binary Tree) <br>
    * Implementation -> Array
     * <br>
     * <b>Heap </b> -> A Heap is a complete binary tree data structure that satisfies the heap property: for every node, the value of its children is greater than or equal to its own value. Heaps are usually used to implement priority queues, where the smallest (or largest) element is always at the root of the tree.<br>
     * <b>Complete Binary Tree </b> -> CBT is a BT in which all the levels are completely filled expected possible the last one, which is filled from the left and right.<br>
     * (node) idx = i; <br>
     * left child = 2i +1; <br>
     * right child = 2i +2; <br>
    */
    ArrayList<Integer> arrayList = new ArrayList<>();

    public void add(int data){
        arrayList.add(data);

        int x = arrayList.size() -1;
        int parent = (x -1) /2; // Parent Index

        while (arrayList.get(x)< arrayList.get(parent)){

            int temp = arrayList.get(x);
            arrayList.set(x,arrayList.get(parent));
            arrayList.set(parent,temp);
            x = parent;
            parent = (x -1)/2;
        }
    }

    public int remove(){
        int data = arrayList.get(0);

        int temp = arrayList.get(0);
        arrayList.set(0,arrayList.get(arrayList.size() -1));
        arrayList.set(arrayList.size()-1,temp);

        arrayList.remove(arrayList.size() -1);

        heapify(0);

        return data;
    }

    private void heapify(int i){
        int left = 2*i+1;
        int right = 2*i+2;
        int midIdx = i;

        if (left < arrayList.size() && arrayList.get(midIdx) > arrayList.get(right)){
            midIdx = left;
        }

        if (right < arrayList.size() && arrayList.get(midIdx) > arrayList.get(right)){
            midIdx =right;
        }

        if (midIdx != 1){

            int temp = arrayList.get(i);
            arrayList.set(i, arrayList.get(midIdx));
            arrayList.set(midIdx,temp);

            heapify(midIdx);
        }
        
    }


    public static void main(String[] args) {

    }
}
