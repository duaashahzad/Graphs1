import java.util.ArrayList;
import java.util.List;

class EveryPath {
    private int V;
    private List<List<Integer>> adj;

    public EveryPath(int v) {
        V = v;
        adj = new ArrayList<>(V);
        for (int i = 0; i < V; ++i)
            adj.add(new ArrayList<>());
    }

    void addEdge(int u, int v) {
        adj.get(u).add(v);
    }

    private void printPathsUtil(int u, int w, int[] path, int pos, boolean[] visited) {
        visited[u] = true;
        path[pos] = u;

        if (pos == 5 && u == w) {
            for (int i = 0; i <= pos; ++i) {
                System.out.print(path[i] + " ");
            }
            System.out.println();
        } else if (pos < 5) {
            for (Integer i : adj.get(u)) {
                if (!visited[i]) {
                    printPathsUtil(i, w, path, pos + 1, visited);
                }
            }
        }

        visited[u] = false;
    }

    void printPaths(int u, int w) {
        boolean[] visited = new boolean[V];
        int[] path = new int[6];
        printPathsUtil(u, w, path, 0, visited);
    }


    public static void main(String[] args) {
        EveryPath graph = new EveryPath(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);

        int u = 0;
        int w = 5;
        System.out.println("Paths from " + u + " to " + w + " with length 5:");
        graph.printPaths(u, w);
    }
}

