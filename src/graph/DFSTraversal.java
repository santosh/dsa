package graph;

import java.util.ArrayList;
import java.util.List;

public class DFSTraversal {
    private int node;  // no. of vertices
    private List<List<Integer>> adj; // adjacent list

    DFSTraversal(int v) {
        node = v;
        adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

    }

    void insertEdge(int u, int v) {
        // adding edge from u to v
        adj.get(u).add(v);
        // adding edge from v to u
        adj.get(v).add(u);
    }

    // helper function for DFS
    void DFSHelper(int u, boolean visited[]) {
        // mark u as visited
        visited[u] = true;
        System.out.print(u + " ");

        // check for all the nodes adjacent to u
        for (int v: adj.get(u)) {
            if (!visited[v]) {
                DFSHelper(v, visited);
            }
        }
    }

    void DFS(int u) {
        // declare a boolean visited array of size len(nodes)
        boolean[] visited = new boolean[node];
        DFSHelper(u, visited);
    }

    public static void main(String[] args) {
        DFSTraversal graph = new DFSTraversal(7);
        graph.insertEdge(0, 1);
        graph.insertEdge(0, 3);
        graph.insertEdge(1, 4);
        graph.insertEdge(1, 2);
        graph.insertEdge(2, 3);
        graph.insertEdge(4, 5);
        graph.insertEdge(4, 6);
        graph.insertEdge(5, 6);
        System.out.println("DFS of the graph is ...");
        graph.DFS(0);
    }
}
