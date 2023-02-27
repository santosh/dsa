//package linkedlist;
//
///*
//Given two sorted linked list l1 and l2. Merge both the linked list into a single linked list in a sorted manner and return its head.
//
//Input Format:
//- Length of the linked list l1 and the elements to be added
//- Length of the linked list l2 and the elements to be added
//
//
//Example 1:
//Input:
//3
//1->2->5
//3
//1->3->4
//
//Output:
//1-> 1-> 2-> 3-> 4-> 5
//Example 2:
//Input:
//2
//4->5
//2
//1->2
//Output:
//1->2->4->5
//
//- 0<=m<=50
//- 0<=n<=50
//*/
//
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
//class LinkedList {
//    Node head;
//    Node tail;
//
//    LinkedList() {
//        this.head = null;
//        this.tail = null;
//    }
//
//    public void add(int val) {
//        Node newNode = new Node(val);
//        if(this.tail == null) {
//            this.head = newNode;
//            this.tail = newNode;
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
//
//    public Node getTail() {
//        return this.tail;
//    }
//}
//// Class name should be "Source",
//// otherwise solution won't be accepted
//public class Merge2SortedList {
//
//    public static Node mergeSortedList(Node l1, Node l2) {
//        //Write your code here
//        Node result =new Node(0);
//        Node tail = result;
//        int count = 0;
//        while(true) {
//            if (l1 == null) {
//                tail.next = l2;
//                break;
//            } else if (l2 == null) {
//                tail.next = l1;
//                break;
//            }
//
//            if (l1.data <= l2.data) {
//                tail.next = l1;
//                l1 = l1.next;
//            } else {
//                tail.next = l2;
//                l2 = l2.next;
//            }
//            tail = tail.next;
//            count++;
//        }
//        return result.next;
//    }
//    public static void main(String args[] ) throws Exception {
//        Scanner sc = new Scanner(System.in);
//        int m = sc.nextInt();
//        LinkedList l1 = new LinkedList();
//        int i = m;
//        while(i > 0) {
//            int val = sc.nextInt();
//            l1.add(val);
//            i--;
//        }
//        Node head1 = l1.getHead();
//        int n = sc.nextInt();
//        LinkedList l2 = new LinkedList();
//        int j = n;
//        while(j > 0) {
//            int val = sc.nextInt();
//            l2.add(val);
//            j--;
//        }
//        Node head2 = l2.getHead();
//        Node head = mergeSortedList(head1, head2);
//        while(head != null) {
//            System.out.println(head.data);
//            head = head.next;
//        }
//    }
//}