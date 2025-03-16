package queue;

import java.nio.charset.IllegalCharsetNameException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BasicQueue {
    /** Queue -> FIFO: First in First out.
     * Create New queue and add;
        Queue<String> queue = new LinkedList<>();
        Queue<String> queue = new ArrayDeque<>();
     Queue is the interface, and we are not crating objects for interface.
     We create Object for class. That Linked List is a class.
     Deque-> Double ended Queue.
     Deque<Integer> deque = new LinkedList<>();


    */
    /*static class Queue{
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public static Boolean isEmpty(){
            return s1.isEmpty();
        }
        // Add
        public static void add(int data){
            while (!s1.isEmpty()){
                s2.add(s1.pop());
            }

            s1.push(data);

            while (!s2.isEmpty()){
                s1.add(s2.pop());
            }
        }
        // Remove
        public static int remove(){
            if (isEmpty()){
                System.err.println("Queue is empty");
                return -1;
            }
            return s1.pop();
        }

        // Peak
        public static int peak(){
            if (isEmpty()){
                System.err.println("Queue is empty");
                return -1;
            }
            return s1.peek();
        }


    }*/

    ///  Q1. Queue using LinkedList.
    ///  Q2. Queue using 2 stacks. (LIFO) to (FIFO)
    /// Q3. Stack using 2 Queues.

    public static void main(String[] args) {
        /*Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);

        while (!q.isEmpty()){
            System.out.println(q.peak());
            q.remove();
        }
        System.out.println(q.peak());*/
        Deque<Integer> deque = new LinkedList<>();

    }

    /// Q4. First non-repeating letter in a stream of character.
    public static void printNonRepeating(String string){
        int[] freq = new int[26]; // a to z
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < string.length(); i++) {

            char ch = string.charAt(i);
            queue.add(ch);
            freq[ch - 'a']++;

            while (!queue.isEmpty() && freq[queue.peek() - 'a'] > 1){
                queue.remove();
            }

            if (queue.isEmpty()){
                System.out.println(-1 + " ");
            }else {
                System.out.println(queue.peek() + " ");
            }

        }
        System.out.println();
    }
    /// Q5. Interleave 2 Halves of queue (even Length)
    public static void interLeave(Queue<Integer> q){
        Queue<Integer> firstHalf = new LinkedList<>();
        int size = q.size();
        for (int i = 0; i < size/2; i++) {
            firstHalf.add(q.remove());
        }

        while (!firstHalf.isEmpty()){
            q.add(firstHalf.remove());
            q.add(q.remove());
        }
    }

    /// Q6. Queue Reversal
    public static void reverse(Queue<Integer> q){
        Stack<Integer> stack = new Stack<>();

        while (!q.isEmpty()){
            stack.push(q.remove());
        }

        while (!stack.isEmpty()){
            q.add(stack.pop());
        }
    }
    /// Q7. Stack & Queue using Deque.



}
