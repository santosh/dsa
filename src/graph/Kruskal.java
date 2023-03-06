package graph;

import java.util.Arrays;

class Graph {
    class Edge implements Comparable<Edge> {
        int src, dest, weight;

        public int compareTo(Edge compareEdge)  {
            return this.weight - compareEdge.weight;
        }
    }

    class subset {
        int parent, rank;
    }

    int V, E;
    Edge[] edge;

    Graph(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[E];
        for (int i = 0; i < e; i++) {
            edge[i] = new Edge();
        }
    }

    int find(subset[] subsets, int i) {
        if (subsets[i].parent != i) subsets[i].parent = find(subsets, subsets[i].parent);

        return subsets[i].parent;
    }

    void Union(subset[] subsets, int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        if (subsets[xroot].rank < subsets[yroot].rank) subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank) subsets[yroot].parent = xroot;
        else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }

    void kruskal_min_s_tree() {
        Edge[] result = new Edge[V];
        int e = 0;
        int i = 0;
        for (i = 0; i < V; ++i)
            result[i] = new Edge();

        Arrays.sort(edge);
        subset[] subsets = new subset[V];
        for (i = 0; i < V; i++)
            subsets[i] = new subset();

        for (int v = 0; v < V; ++v) {
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }

        i = 0;
        while (e < V-1) {
            Edge nextEdge = edge[i++];

            int x = find(subsets, nextEdge.src);
            int y = find(subsets, nextEdge.dest);

            if (x != y) {
                result[e++] = nextEdge;
                Union(subsets, x, y);
            }
        }

        System.out.println("The following are the edges in " + "the constructed MST");
        int minimumCost = 0;
        for (i = 0; i < e; i++) {
            System.out.println("Source: " + result[i].src +  " -- " + "Destination: " + result[i].dest +  " -- " + "Weight: "  + result[i].weight);            minimumCost += result[i].weight;
        }

        System.out.println("Minimum cost of the MST is: " + minimumCost);
    }
}
public class Kruskal {
    public static void main(String[] args) {
        int V = 4;
        int E = 5;

        Graph graph = new Graph(V, E);
        //let us create an edge between vertices 0 and 1 with cost = 20
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = 5;

        //let us create an edge between vertices 0 and 2 with cost = 12
        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 12;

        //let us create an edge between vertices 0 and 3 with cost = 10
        graph.edge[2].src = 0;
        graph.edge[2].dest = 3;
        graph.edge[2].weight = 40;

        //let us create an edge between vertices 1 and 3 with cost = 30
        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].weight = 30;

        //let us create an edge between vertices 2 and 3 with cost = 8
        graph.edge[4].src = 2;
        graph.edge[4].dest = 3;
        graph.edge[4].weight = 8;

        graph.kruskal_min_s_tree();
    }
}
