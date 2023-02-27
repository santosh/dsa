package linkedlist;

import java.util.Scanner;

/*
Given a circular linked list having ‘n’ nodes along with data values in each of them. You have to split the list into two halves. If ‘n’ is odd, then the first half linked list should have one more node than the second half of the given linked list.

Note :
1. the input list contains 0 element print blank linked list
2. In case the input list contains 1 element print “ NA”
3. The output of your code should print both of the lists separately as shown below.

Input Format:
The first line represents the number of nodes in the circular linked list.
The second line represents the data values corresponding to each of the nodes.
Output Format:

Print both the lists after splitting them to two halves.


Sample Input 1:
8
1 2 3 4 5 6 7 8

Sample Output 1:
1 2 3 4
5 6 7 8

Explanation 1:
The list consists of even number of elements and thus, gets split into equal halves.

Sample Input 2:
0
Sample Output 2:

Explanation 2:
The list consists of no elements and thus, a blank linked list gets printed.

Sample Input 3:
1
5

Sample Output 3:
NA

Explanation 3:

The list consists of only one element and thus, NA gets printed.

Sample Input 4:
5
5 3 7 8 9

Sample Output 4:
5 3 7
8 9

Explanation 4:
The list consists of odd number of elements and thus, gets split in such a way that first list has one extra node when compared to the second list.
*/
class SplitCLL {
    static Node head;
    static Node h1,h2;

    static class Node {
        int data;
        Node next, prev;

        Node(int d) {
            data = d;
            next = prev = null;
        }
    }
    void divide() {
        //write your code here
        //write your code here
        //if list is null, print blank
        if (head == null) {
            System.out.print(" ");
            return;
        }
        //if list has 1 element. print NA
        if (head.next == head) {
            System.out.print("NA");
            return;
        }
        //fast and slow ptrs to find mid node of the list.
        Node slow = head;
        Node fast = head;
        while (fast.next != head && fast.next.next != head) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //for case of even nodes
        if (fast.next.next == head) {
            fast = fast.next;
        }
        // setting start ptrs for two linked lists
        h1 = head;
        h2 = slow.next;

        //make the two two LLs circular & print
        fast.next = h2;
        h2.prev = fast;

        slow.next = h1;
        h1.prev = slow;
    }
    //Method to add nodes at the end of the list
    public void push(int new_data) {
        Node temp = head;
        Node new_node = new Node(new_data);
        if (head == null) {
            head = new_node;
            new_node.next=head;
        } else {
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = new_node;
            new_node.next = head;
        }
    }


    //Method to print data value of nodes of the linked list
    void print(Node temp) {
        Node node = temp;
        if (temp != null) {
            do {
                System.out.print(node.data + " ");
                node = node.next;
            } while (node != temp);
        }
    }

    public static void main(String[] args) {
        SplitCLL list = new SplitCLL();
        Scanner in= new Scanner(System.in);
        int n=in.nextInt();
        for(int i=0; i<n; i++) {
            list.push(in.nextInt());
        }
        list.divide();
        System.out.println("");
        list.print(h1);
        System.out.println("");
        list.print(h2);
    }
}