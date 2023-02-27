//package linkedlist;
//
//import java.util.Scanner;
//
///*
//Given a linked list, swap every two adjacent nodes and return its head.
//You can consider, the length of the given linked list will always be even.
//
//Note: Do not change the value in the list nodes.
//
//First line of the input takes N (Number of nodes).
//Second line of the input takes N nodes.
//
//Input:
//4
//1 2 3 4
//
//Output:
//2
//1
//4
//3
//
//Explanation:
//Swapping 1 with 2 and 3 with 4.
//After swapping every two adjacent nodes of the given linked list we'll get 2 1 4 3 as the new or modified linked list.
//*/
////class Node {
////    int data;
////    Node next;
////
////    Node(int data) {
////        this.data = data;
////        this.next = null;
////    }
////}
//
//class LinkedList {
//    Node head;
//    Node tail;
//
//    LinkedList() {
//        this.head = null;
//        this.tail = null;
//    }
//
//    public void push(int n) {
//        Node newNode = new Node(n);
//        if(this.tail == null) {
//            this.tail = newNode;
//            this.head = newNode;
//            return;
//        }
//
//        this.tail.next = newNode;
//        this.tail = newNode;
//    }
//
//    public Node getHead() {
//        return this.head;
//    }
//}
//
//// Class name should be "Source",
//// otherwise solution won't be accepted
//public class SwapNodesInPair {
//    public static Node swapNodes(Node head) {
//        if(head == null || head.next == null) {
//            return null;
//        }
//        Node curr = head.next.next;
//        Node prev = head;
//        head = head.next;
//        head.next = prev;
//
//        while (curr != null && curr.next != null) {
//            prev.next = curr.next;
//            prev = curr;
//            Node next = curr.next.next;
//            curr.next.next = curr;
//            curr = next;
//        }
//        prev.next = curr;
//
//        return head;
//    }
//
//    public static void main(String args[] ) throws Exception {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        LinkedList list = new LinkedList();
//
//        while(n > 0) {
//            list.push(sc.nextInt());
//            n--;
//        }
//
//        Node newList = swapNodes(list.getHead());
//        while(newList != null) {
//            System.out.println(newList.data);
//            newList = newList.next;
//        }
//    }
//}