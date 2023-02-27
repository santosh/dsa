package linkedlist;

import java.util.Scanner;

/*
Write a Java program to create a Doubly Circular linked list of ‘n’ nodes and corresponding ‘n’ data values. After creating, traverse your list in forward and backward direction and print output of traversal in both directions.

Input Format:

First line represents the number of nodes in linked list to be created
Second line represents the data values corresponding to each of the node

Output Format:

First line prints the linked list in forward direction from first element to last element
Second line prints the linked list in backward direction from last element to first element

Sample input 1:
6
1 2 3 4 5 6

Sample Output 1:
1 2 3 4 5 6
6 5 4 3 2 1

Explanation 1:
The doubly circular linked list when read in forward direction would be: 1 2 3 4 5 6.
And, when read backwards, would be: 6 5 4 3 2 1.

Sample input 2:
0
Sample Output 2:

Explanation 2:
The linked list is empty and thus, the output gets printed accordingly.

Sample input 3:
1
33

Sample Output 3:
33
33

Explanation 3:
The doubly circular linked list has only one element, thus read forward or backward, it reads the same.
*/
class DoublyCLL {
    Node head;
    // Creating structure for nodes
    class Node {
        //write your code here
        int data;
        Node next;
        Node prev;
        Node(int i) {
            data = i;
            next = null;
            prev = null;
        }
    }

    // This method will push the input data at the end of the list
    void push(int data) {
        //write your code here
        Node temp = head;
        if(head == null) {
            Node newNode = new Node(data);
            newNode.next = newNode.prev = newNode;
            head = newNode;
        }
        Node last = head.prev;
        Node newNode = new Node(data);

        newNode.next = head;
        head.prev = newNode;

        last.next = newNode;
        newNode.prev = last;
    }

    void print() {
        //write your code here
        if (head == null) {
            return;
        }

        Node current = head.next;

        while (current != null && current != head) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();

        current = head.prev;

        while (current != null && current != head) {
            System.out.print(current.data + " ");
            current = current.prev;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        DoublyCLL obj = new DoublyCLL();
        for (int i = 0; i < n; i++) {
            obj.push(in.nextInt());
        }
        obj.print();
    }
}