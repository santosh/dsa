//package linkedlist;
//
///*
//Given two numbers represented by linked lists, write a function that returns the multiplication of these two linked lists.
//
//Examples:
//Input : 8->5->7
//        7->5
//Output : 64275
//
//Input : 3->2->1
//        1->2
//Output : 3852
//*/
//
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
//class TraverseDLL {
//
//    public static void traverse(DLLNode head){
//
//        while(head !=null){
//            System.out.print(head.getData() + " ");
//            head = head.getNext();
//        }
//        System.out.println();
//    }
//
//}
//// Class name should be "Source",
//// otherwise solution won't be accepted
//public class Multiply2LL {
//    public static long multiplyTwoLL(ListNode head1, ListNode head2){
//        long bigNum = 1000000000; //Take very bif number
//        long num1 = 0, num2 = 0;
//
//        while (head1 != null || head2 !=  null){
//
//            if(head1 != null){
//                num1 = ((num1)*10)%bigNum + head1.getData();
//                head1 = head1.getNext();
//            }
//
//            if(head2 != null)
//            {
//                num2 = ((num2)*10)%bigNum + head2.getData();
//                head2 = head2.getNext();
//            }
//
//        }
//        return ((num1%bigNum)*(num2%bigNum))%bigNum;
//    }
//    public static void main(String[] args) {
//
//        ListNode head1 = new ListNode(9);
//        head1.setNext(new ListNode(4));
//        head1.getNext().setNext(new ListNode(6));
//
//        ListNode head2 = new ListNode(8);
//        head2.setNext(new ListNode(4));
//
//
//        System.out.println(multiplyTwoLL(head1, head2));
//
//    }
//}