package linkedlist;

public class MyLinkedList {
    /** A LinkedList is a linear data structure where elements (nodes) are connected using pointers. Unlike arrays, linked lists don’t require contiguous memory allocation, making insertions and deletions efficient. */
    static Node head; // First Node of a linked list.
    static Node tail; // Last Node of a linked list.
    static int size; // Get Size of a linked list;

    private static class Node {
        int data; // Store Data of Node.
        Node next; // Pointer to the next node in the linkedList

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void add(int idx, int data) {
        if (idx == 0) {
            addFirst(data);
            return;
        }
        Node node = new Node(data);
        size++;
        Node temp = head;
        int index = 0;
        // Check idx previous value;
        while (index < idx - 1) {
            // Now idx Previous value Store in Temp.
            temp = temp.next;
            index++;
        }
        // In this line new Node next value assign as temp next node value.
        node.next = temp.next;
        // Link new node at position of temp node.
        temp.next = node;
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public int removeFirst() {
        if (size == 0) {
            System.out.println("LinkedList is Empty.");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast() {
        if (size == 0) {
            System.out.println("LinkedList is Empty.");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = tail.data;
            head = tail = null;
            size = 0;
            return val;
        }

        Node pre = head;
        for (int i = 0; i < size - 2; i++) {
            pre = pre.next;
        }
        int val = pre.next.data;
        pre.next = null;
        tail = pre;
        size--;
        return val;
    }

    public void printLinkedList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("Null");
    }

    public static void main(String[] args) {
        MyLinkedList ll = new MyLinkedList();
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(3);
        ll.addLast(4);
        ll.add(1, 0);
        System.out.println(ll.size); // ✅ Use instance variable

        ll.printLinkedList(); // ✅ Call using an instance
    }

    public static void removeNthLastNode(int n){
        int sz = 0;
        Node temp = head;

        while (temp != null){
            temp = temp.next;
            sz++;
        }
        // last to n means First Node.
        if (sz == n){
            head = head.next; // removeFirst
            return;
        }

        int i = 1;
        int idx = sz - n;
        Node pre = head;
        while (i < idx){
            pre = pre.next;
            i++;
        }
        pre.next = pre.next.next;
        return;
    }

    /// Slow-Fast Approach (Turtle and Rabbit)
    static Node findMid(Node node){
        Node slow = head;
        Node fast = head;
        while (slow != null && fast != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    static Boolean isPalindrome(){
        if (head == null || head.next == null){
            return true;
        }
        // Step 1: Find Mid.
        Node mid = findMid(head);

        // Step 2: Reverse 2nd Half.
        Node pre = null;
        Node curr = mid;
        Node next;

        while (curr != null){
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }

        // Step 3: Check 1st and 2nd.
        Node right  = pre;
        Node left = head;
        while (right != null){
            if (right.data != left.data){
                return false;
            }
            right = right.next;
            left = left.next;
        }
        return true;

    }
    ///  Floyd's Cycle Finding Algorithm. Q. Find/Detect Cycle in the LinkedList.
    public static Boolean isCycle(){
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                return true;
            }
        }
        return false;
    }

    static int searchLinkedList(MyLinkedList ll, int key) {
        /* // TODO: All code is good we solve by using recursion.
        int index = 0;
        MyLinkedList.Node team = ll.head;
        while (team != null) {
            if (team.data == key) {
                return index;
            }
            team = team.next;
            index++;
        }
        return -1;*/
        return helper(ll.head,key);

    }
    public static int helper(Node head, int key){
        // Base case
        if (head == null){
            return -1;
        }
        if (key == head.data){
            return 0;
        }
        int idx = helper(head.next, key);
        if (idx == -1) return -1;
        return idx +1;
    }

    static MyLinkedList.Node getMid(MyLinkedList.Node head){
        MyLinkedList.Node slow = head;
        MyLinkedList.Node fast = head.next;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    static MyLinkedList.Node merge(MyLinkedList.Node head1, MyLinkedList.Node head2){
        MyLinkedList.Node merged = new MyLinkedList.Node(-1);
        MyLinkedList.Node temp  = merged;

        while (head1 != null && head2 != null){
            if (head1.data <= head2.data){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }

        while (head1 != null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while (head2 != null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return merged.next;
    }
    static MyLinkedList.Node mergeSortOnLinkedList(MyLinkedList.Node head){
        if (head == null || head.next == null){
            return head;
        }
        // Find Mid
        MyLinkedList.Node mid = getMid(head);

        // Split into two parts.
        MyLinkedList.Node rightHead = mid.next;
        mid.next = null;
        MyLinkedList.Node newLeft = mergeSortOnLinkedList(head);
        MyLinkedList.Node newRight = mergeSortOnLinkedList(rightHead);
        // sort
        return merge(newLeft, newRight);
    }


}
