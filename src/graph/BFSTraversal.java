package graph;

import java.util.LinkedList;
import java.util.Queue;

public class BFSTraversal {
    private int node;
    private LinkedList<Integer> adj[]; // adjacent list
    private Queue<Integer> que;

    BFSTraversal(int v) {
        node = v;
        adj = new LinkedList[node];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }

        que = new LinkedList<Integer>();
    }

    void insertEdge(int v, int w) {
        adj[v].add(w);
    }

    void BFS(int n) {
        boolean[] nodes = new boolean[node];  // initialize boolean array for  holding the data
        int a = 0;
        nodes[n] = true;
        que.add(n);  // root node is added to the top of the queue

        while (que.size() != 0) {
            n = que.poll();  // remove  the top / first element
            System.out.print(n + " ");  // print the first/top element of the queue
            for (int i = 0; i < adj[n].size(); i++) {  // iterate through the linked list and push all the neighbours
                a = adj[n].get(i);
                if (!nodes[a]) {// only insert nodes into queue if they have not been inserted
                    nodes[a] = true;
                    que.add(a);
                }
            }
        }
    }

    public static void main(String[] args) {
        BFSTraversal graph = new BFSTraversal(6);
        graph.insertEdge(0, 1);
        graph.insertEdge(0, 3);
        graph.insertEdge(0, 4);
        graph.insertEdge(4, 5);
        graph.insertEdge(3, 5);
        graph.insertEdge(1, 2);
        graph.insertEdge(1, 0);
        graph.insertEdge(2, 1);
        graph.insertEdge(4, 1);
        graph.insertEdge(3, 1);
        graph.insertEdge(5, 4);
        graph.insertEdge(5, 3);
        System.out.println("BFS of the graph is ...");
        graph.BFS(0);
    }
}
