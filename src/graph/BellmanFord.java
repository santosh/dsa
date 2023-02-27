package graph;

import java.util.ArrayList;
import java.util.List;

class BellmanGraph {
    // vertices of graph
    private int V;
    // edges in the graph
    private List<BellmanEdge> edges;

    public BellmanGraph() {
        edges = new ArrayList<BellmanEdge>();
    }

    public int getV() {
        return V;
    }

    public void setV(int v) {
        V = v;
    }

    public List<BellmanEdge> getEdges() {
        return edges;
    }

    public void setEdges(List<BellmanEdge> edges) {
        this.edges = edges;
    }

    public void addEdge(int u, int v, int w) {
        BellmanEdge e = new BellmanEdge(u, v, w);
        edges.add(e);
    }
}

class BellmanEdge {
    private int u; // source vertex
    private int v; // destination vertex
    private int w; // edge weight

    public void setU(int u) {
        this.u = u;
    }

    public void setV(int v) {
        this.v = v;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getU() {
        return u;
    }

    public int getV() {
        return v;
    }

    public int getW() {
        return w;
    }

    public BellmanEdge(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }
}

public class BellmanFord {
    public static void main(String args[]) {
        BellmanGraph g = createGraph();
        int[] distance = new int[g.getV()];
        boolean hasNegativeCycle = getShortestPaths(g, 1, distance);
        if (!hasNegativeCycle) {
            System.out.println("Vertex \t: Distance");
            for (int i = 1; i < distance.length; i++)
                System.out.println("\t" + i + " " + "\t\t" + (distance[i] == Integer.MAX_VALUE ? "-" : distance[i]));
        } else {
            System.out.println("Negative cycle exists in the graph, no solution found!!!");
        }
    }

    private static BellmanGraph createGraph() {
        int v = 7;
        //creating a graph having 7 vertices
        BellmanGraph g = new BellmanGraph(v);
        //adding edges to the graph
        g.addEdge(1, 2, 4);
        g.addEdge(1, 4, 9);
        g.addEdge(2, 3, 4);
        g.addEdge(3, 6, 3);
        g.addEdge(4, 3, -2);
        g.addEdge(4, 5, 6);
        g.addEdge(5, 6, 0);
        //returns graph
        return g;
    }

    //Bellman-Ford logic
    public static boolean getShortestPaths(BellmanGraph g, int source, int[] distance) {
        int V = g.getV();
        //initializing distances from source to other vertices
        for(int i = 1; i < V; i++)
        {
            distance[i] = Integer.MAX_VALUE; //infinity
        }
        //source vertex initialize to 0
        distance[source] = 0;
        //relaxing edges
        for (int i = 1; i<V; i++)
        {
            //iterate over edges
            for (BellmanEdge e: g.getEdges())
            {
                int u = e.getU(), v = e.getV(), w = e.getW();
                if(distance[u] !=Integer.MAX_VALUE && distance[v] > distance[u] + w)
                {
                    //compute the distance
                    distance[v] = distance[u] + w;
                }
            }
        }
        //check if there exists negative edge cycle in graph G
        for (BellmanEdge e: g.getEdges())
        {
            int u = e.getU(), v=e.getV(), w=e.getW();
            if(distance[u] !=Integer.MAX_VALUE && distance[v] > distance[u] + w)
            {
                return true;
            }
        }
        return false;
    }
}
