//package linkedlist;
//
///*
//Given a singly linked list, write a function to swap elements pairwise.
//
//For example, if the linked list is 1->2->3->4->5->6->7 then the function should change it to 2->1->4->3->6->5->7, and if the linked list is 1->2->3->4->5->6 then the function should change it to 2->1->4->3->6->5
//*/
//class ListNode {
//
//    private int data;
//    private ListNode next ;
//
//    public ListNode(int data) {
//        this.data = data;
//    }
//
//    public int getData() {
//        return data;
//    }
//
//    public void setData(int data) {
//        this.data = data;
//    }
//
//    public ListNode getNext() {
//        return next;
//    }
//
//    public void setNext(ListNode next) {
//        this.next = next;
//    }
//}
//class TraverseLL {
//
//    public static void traverse(ListNode head){
//        while(head !=null){
//            System.out.print(head.getData()+ " ");
//            head= head.getNext();
//        }
//        System.out.println();
//    }
//}
//
//// Class name should be "Source",
//// otherwise solution won't be accepted
//public class PairwiseSwap {
//
//    public static ListNode pairWiseSwap(ListNode head){
//        if (head == null || head.getNext() == null) {
//            return head;
//        }
//
//        ListNode prev = head;
//        ListNode curr = head.getNext();
//
//        head = curr;
//
//        while (true) {
//            ListNode next = curr.getNext();
//            curr.setNext(prev);
//            if (next == null || next.getNext() == null) {
//                prev.setNext(next);
//                break;
//            }
//
//            prev.setNext(next.getNext());
//
//            prev = next;
//            curr = prev.getNext();
//        }
//        return head;
//    }
//    public static void main(String[] args) {
//        ListNode head4 = new ListNode(1);
//        head4.setNext(new ListNode(2));
//        head4.getNext().setNext(new ListNode(3));
//        head4.getNext().getNext().setNext(new ListNode(4));
//        head4.getNext().getNext().getNext().setNext(new ListNode(5));
//        head4.getNext().getNext().getNext().getNext().setNext(new ListNode(6));
//        head4.getNext().getNext().getNext().getNext().getNext().setNext(new ListNode(7));
//
//        TraverseLL.traverse(head4);
//        TraverseLL.traverse(pairWiseSwap(head4));
//
//    }
//}