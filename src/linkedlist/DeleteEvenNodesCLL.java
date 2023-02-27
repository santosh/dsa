//package linkedlist;
//
//import java.util.Scanner;
//
///*
//Given a circular singly linked list of n nodes. Task is to delete even nodes from the list (Nodes having even integers).
//
//Return the head of the linked list.
//
//First line of the input takes N (Number of nodes).
//Second line of the input takes N nodes.
//
//Input:
//4
//1 2 3 4 1
//
//Output:
//1
//3
//1
//
//Explanation:
//2 and 4 are the even nodes so after removing them we'll get 1 3 1 as new circular linked list.
//
//Note: Consider that linked list will always start with odd value.
//*/
//class Node {
//    int data;
//    Node next;
//
//    Node(int data) {
//        this.data = data;
//        this.next = null;
//    }
//}
//
////class LinkedList {
////    Node head;
////    Node tail;
////
////    LinkedList() {
////        this.head = null;
////        this.tail = null;
////    }
////
////    public void push(int n) {
////        Node newNode = new Node(n);
////        if(this.tail == null) {
////            this.tail = newNode;
////            this.head = newNode;
////            return;
////        }
////
////        this.tail.next = newNode;
////        this.tail = newNode;
////        newNode.next = this.head;
////    }
////
////    public Node getHead() {
////        return this.head;
////    }
////
////    public void printList() {
////        Node temp = this.head.next;
////        if(temp == null) {
////            return;
////        }
////        System.out.println(this.head.data);
////        while(temp != this.head) {
////            System.out.println(temp.data);
////            temp = temp.next;
////        }
////    }
////}
//// Class name should be "Source",
//// otherwise solution won't be accepted
//public class DeleteEvenNodesCLL {
//
//    public static Node deleteEvenNodes(Node head){
//        if (head == null) {
//            return head;
//        }
//        Node curr = head;
//
//        do {
//            if(curr.data%2 == 0) {
//                deleteNode(head, curr);
//            }
//            curr = curr.next;
//        }  while(curr != head);
//
//        return head;
//    }
//
//    public static Node deleteNode(Node head, Node del) {
//        Node temp = head;
//
//        if (head == del) {
//            head = del.next;
//        }
//
//        while (temp.next != del) {
//            temp = temp.next;
//        }
//        temp.next = del.next;
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
//        deleteEvenNodes(list.getHead());
//        list.printList();
//    }
//}