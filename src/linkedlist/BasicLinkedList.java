package linkedlist;

import java.util.LinkedList;

public class BasicLinkedList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {

    }
    ///  21. Merge Two Sorted Lists.
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode sorted = new ListNode(-1);
        ListNode temp = sorted;

        while (list1 != null && list2 != null){
            if (list1.val <= list2.val){
                temp.next = list1;
                list1 = list1.next;
                temp= temp.next;
            }else {
                temp.next = list2;
                list2 = list2.next;
                temp = temp.next;
            }
        }

        while (list1 != null){
            temp.next = list1;
            list1 = list1.next;
            temp= temp.next;
        }
        while (list2 != null){
            temp.next = list2;
            list2 = list2.next;
            temp = temp.next;
        }
        return sorted.next;
    }

    /// 19. Remove Nth Node From End of List

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = head;
        int size = 0;
        while (dummy != null){
            size++;
            dummy = dummy.next;
        }
        if (size == n){
            return head.next;
        }
        int i = 1;
        size = size - n;
        ListNode pre = head;
        while (i < size){
            pre = pre.next;
            i++;
        }
        pre.next = pre.next.next;
        return head;
    }
    /// 24. Swap Nodes in Pairs.
    public ListNode swapPairs(ListNode head) {
        // Dummy node to handle edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while (head != null && head.next != null) {
            ListNode first = head;
            ListNode second = head.next;

            // Swapping nodes
            first.next = second.next;
            second.next = first;
            prev.next = second;

            // Move pointers for next iteration
            prev = first;
            head = first.next;
        }
        return dummy.next;
    }

    /// 61. Rotate List.
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        // Step 1: Find length and make it circular
        ListNode last = head;
        int length = 1;
        while (last.next != null) {
            last = last.next;
            length++;
        }
        last.next = head; // Make it circular

        // Step 2: Find the new head
        k = k % length;
        for (int i = 0; i < length - k; i++) {
            last = last.next;
        }

        // Step 3: Break the cycle and return the new head
        head = last.next;
        last.next = null;
        return head;
    }

    ///  82. Remove Duplicates from Sorted List II.
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;
        while (head != null){

            if (head.next != null && head.val == head.next.val){
                while (head.next != null && head.val == head.next.val){
                    head = head.next;
                }
                pre.next = head.next;
            } else {
                pre = pre.next;
            }
            head = head.next;
        }
        return dummy.next;
    }

}
