package linkedlist;

public class DoublyLinkedList<T> {
    // Doubly Linked List Implementation

    // Node Class
    public static class Node<T> {
        T data;
        Node<T> next;
        Node<T> pre;

        Node(T data) {
            this.data = data;
            this.next = null;
            this.pre = null;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    // Constructor
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Add First Method
    public void addFirst(T data) {
        Node<T> node = new Node<>(data);

        if (head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head.pre = node;
            head = node;
        }
        size++;
    }

    // Print Method
    public void print() {
        Node<T> temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Main Method
    public static void main(String[] args) {
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
        dll.addFirst(1);
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(4);

        System.out.println("Doubly Linked List:");
        dll.print();
    }
}
