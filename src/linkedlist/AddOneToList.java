//package linkedlist;
//
///*
//Number is represented in linked list such that each digit corresponds to a node in linked list. Add 1 to it.
//
//For example 1999 is represented as (1-> 9-> 9 -> 9) and adding 1 to it should change it to (2->0->0->0)
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
//class Session4 {
//
//    public static ListNode reverse(ListNode head){
//        if(head ==null || head.getNext()==null){
//            return head ;
//        }
//
//        ListNode prev = null;
//        ListNode curr = head ;
//        while(curr!=null){
//            ListNode next = curr.getNext();
//            curr.setNext(prev);
//            prev = curr ;
//            curr = next;
//        }
//
//        return prev;
//    }
//}
//// Class name should be "Source",
//// otherwise solution won't be accepted
//public class AddOneToList {
//    public static ListNode addOneToTheList(ListNode head){
//
//        head = Session4.reverse(head);
//        head = addOneUtil(head);
//        return Session4.reverse(head);
//    }
//    private static ListNode addOneUtil(ListNode head){
//        ListNode res = head;
//        ListNode temp = null, prev = null;
//        int carry = 1, sum;
//        while (head != null)
//        {
//            sum = carry + head.getData();
//            carry = (sum >= 10) ? 1 : 0;
//            sum = sum % 10;
//            head.setData(sum);
//
//            temp = head;
//            head = head.getNext();
//        }
//        if (carry > 0)
//            temp.setNext(new ListNode(carry));
//        return res;
//    }
//    public static void main(String[] args) {
//        ListNode head3 = new ListNode(1);
//        head3.setNext(new ListNode(9));
//        head3.getNext().setNext(new ListNode(9));
//        head3.getNext().getNext().setNext(new ListNode(9));
//
//        TraverseLL.traverse(head3);
//
//        TraverseLL.traverse(addOneToTheList(head3));
//    }
//}