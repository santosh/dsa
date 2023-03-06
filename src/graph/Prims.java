package graph;

public class Prims {
    int[][] adj;
    int vert; // total number of vertices
    int[] keys; // the weights
    boolean[] visited;
    int[] parent;
    int INF = 9999;

    Prims(int[][] a, int n) {
        vert = n;
        adj = new int[n][n];
        parent = new int[n];
        keys = new int [n];
        visited = new boolean[n];
        for(int i = 0; i < n; i++)
        {
            visited[i] = false;
            keys[i] = INF;
            for (int j = 0; j < n; j++)
                adj[i][j] = a[i][j];
        }
    }

    int minKey() {
        int min = -1, minim = INF;
        for (int i = 0; i < vert; ++i)
            if(visited[i] == false && keys[i] <= minim)
            {
                min = i;
                minim = keys[i];
            }
        return min;
    }

    void mst(int vertex) {
        keys[vertex] = 0;
        for (int i = 0; i< vert-1; ++i)
        {
            int u = minKey();
            visited[u] = true;

            for (int j = 0; j < vert; ++j)
            {
                if(visited[j] == false && adj[u][j] !=0 && adj[u][j] < keys[j])
                {
                    keys[j] = adj[u][j];
                    parent[j] = u;
                }
            }
        }
    }

    void print() {
        int total = 0; //Cost of MST
        for (int i = 0; i < vert; ++i)
        {
            System.out.println("Source: " + i+ " -- " + "Destination: " + parent[i]);
            total += adj[i][parent[i]];
        }
        System.out.println("The total cost of MST is: "+total);
    }

    public static void main(String[] args) {
        int n = 5;
        int [][] a = {
                {0, 9, 75, 0, 0},
                {8, 0, 95, 19, 42},
                {75, 95, 0, 11, 66},
                {0, 10, 51, 0, 31},
                {0, 42, 66, 30, 0}
        };
        Prims p = new Prims(a, n);
        p.mst(0);
        System.out.println("The Edges of MST are: ");
        p.print();
    }
}
