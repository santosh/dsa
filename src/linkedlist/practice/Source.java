package linkedlist.practice;

import linkedlist.DLLNode;
import linkedlist.DoublyLinkedList;
import linkedlist.ListNode;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Session4 {

    public static ListNode reverse(ListNode head){
        if(head ==null || head.getNext()==null){
            return head ;
        }

        ListNode prev = null;
        ListNode curr = head ;
        while(curr!=null){
            ListNode next = curr.getNext();
            curr.setNext(prev);
            prev = curr ;
            curr = next;
        }

        return prev;
    }


    public static ListNode mergeSecondInFirst(ListNode head1, ListNode head2){

        ListNode current = head1;

        while(current!=null && head2!=null){
            ListNode next = head2.getNext();
            head2.setNext(current.getNext());
            current.setNext(head2);
            head2 = next;
            current = current.getNext().getNext();
        }

        return head1;

    }

    public static ListNode rotate(ListNode head, int k){
        if (k == 0)
            return head;

        ListNode current = head;

        while (current.getNext() != null)
            current = current.getNext();

        current.setNext(head); // Made circular
        current = head;
        for (int i = 0; i < k - 1; i++)
            current = current.getNext();

        head = current.getNext();
        current.setNext(null);
        return head;
    }


    public static boolean isPalindrome(WrapperNode left, ListNode right){

        if (right == null) {
            return true;
        }

        if (!isPalindrome(left, right.getNext())) {
            return false;
        }

        ListNode prevLeft = left.node;

        left.node = left.node.getNext();

        return prevLeft.getData() == right.getData();
    }

    static class WrapperNode
    {
        public ListNode node;

        public WrapperNode(ListNode node) {
            this.node = node;
        }
    }



    public static ListNode reverseK(ListNode head, int k ){

        if(head == null)
            return null;
        ListNode current = head;
        ListNode next = null;
        ListNode prev = null;

        int count = 0;

        while (count < k && current != null) {
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
            count++;
        }

        if (next != null)
            head.setNext(reverseK(next, k));

        return prev;
    }
}
// Class name should be "Source",
// otherwise solution won't be accepted
public class Source {
    public static linkedlist.DLLNode split(linkedlist.DLLNode head) {
        linkedlist.DLLNode fast = head, slow = head;
        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }
        linkedlist.DLLNode temp = slow.getNext();
        slow.setNext(null);
        return temp;
    }

    public static linkedlist.DLLNode mergeSort(linkedlist.DLLNode node) {
        if (node == null || node.getNext() == null) {
            return node;
        }
        linkedlist.DLLNode second = split(node);

        node = mergeSort(node);
        second = mergeSort(second);

        return merge(node, second);
    }

    public static linkedlist.DLLNode merge(linkedlist.DLLNode first, linkedlist.DLLNode second) {
        if (first == null) {
            return second;
        }

        if (second == null) {
            return first;
        }

        if (first.getData() < second.getData()) {
            first.setNext(merge(first.getNext(), second));
            first.getNext().setPrev(first);
            first.setPrev(null);
            return first;
        } else {
            second.setNext(merge(first, second.getNext()));
            second.getNext().setPrev(second);
            second.setPrev(null);
            return second;
        }
    }
    public static void main(String[] args) {
        DLLNode node1 = new DLLNode(5);
        DLLNode node2 = new DLLNode(4);
        DLLNode node3 = new DLLNode(3);
        DLLNode node4 = new DLLNode(2);
        DLLNode node5 = new DLLNode(1);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);

        node2.setPrev(node1);
        node3.setPrev(node2);
        node4.setPrev(node3);
        node5.setPrev(node4);

        DoublyLinkedList.traverse(node1);
        System.out.println();
        DoublyLinkedList.traverse(mergeSort(node1));

    }

}