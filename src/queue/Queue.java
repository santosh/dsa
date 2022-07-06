package queue;

import linkedlist.ListNode;

class QueueWithArray {
    private int[] arr;
    private int front;
    private int rear;

    public QueueWithArray(int size) {
        this.arr = new int[size];
        this.front = -1;
        this.rear = -1;
    }

    public boolean isEmpty() {
        return front == -1 && rear == -1;
    }

    public boolean isFull() {
        return (front+1)%arr.length == rear;
    }

    public void enqueue(int data) {
        if (isFull()) {
            throw new RuntimeException("Queue overflow exception");
        }

        front = (front+1)%arr.length;
        this.arr[front] = data;
        if (rear == -1) {
            rear = front;
        }

//        for (int i = rear; i <= front; i++) {
//            System.out.printf("%d", arr[i]);
//        }
//        System.out.println();
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue underflow exception");
        }

        int data =  this.arr[rear];

        if (rear == front) {
            rear = -1;
            front = -1;
        } else {
            rear = (rear+1)%arr.length;
        }

        return data;
    }


    public static void main(String[] args) {
        QueueWithArray qwa = new QueueWithArray(4);
        System.out.println(qwa.isFull());

        qwa.enqueue(1);
        qwa.enqueue(2);
        qwa.enqueue(5);
        qwa.enqueue(8);

        System.out.println(qwa.isFull());
        // qwa.enqueue(3);
    }
}

class QueueWithLinkedList {
    private ListNode frontNode;  // enQueue
    private ListNode rearNode;  // deQueue

    public boolean isEmpty() {
        return frontNode == null && rearNode == null;
    }

    public void enQueue(int data){
        //It should happen at frontNode
        if(isEmpty()){
            frontNode = new ListNode(data);
            rearNode = frontNode;
        }else{
            frontNode.setNext(new ListNode(data));
            frontNode= frontNode.getNext();
        }
    }

    public int deQueue(){
        if(isEmpty()){
            throw new RuntimeException("Queue underflow exception");
        }
        int data = rearNode.getData();
        rearNode = rearNode.getNext();
        return data;
    }

    public static void main(String[] args) {

    }
}
