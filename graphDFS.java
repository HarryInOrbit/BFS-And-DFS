import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class graphDFS {
    private LinkedList<Integer> adj[];
    private boolean visited[];

    graphDFS(int v) {
        adj = new LinkedList[v];
        visited = new boolean[v];

        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }

    public static void main(String[] args) {
        graphDFS g = new graphDFS(7);  // Size

        System.out.println("Pick a point (0 to 4): ");
        Scanner user = new Scanner(System.in);
        int c = user.nextInt();
        user.close();
        g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);

        System.out.println("Following is Breadth First Traversal " + "(starting from " + c + ")");

        g.DFS(c);
    }

    void addEdge(int src, int dest) {
        adj[src].add(dest);
    }

    void DFS(int v) {
        visited[v] = true;
        System.out.print(v + " ");

        Iterator<Integer> ite = adj[v].listIterator();
        while (ite.hasNext()) {
            int adj = ite.next();
            if (!visited[adj]) {
                DFS(adj);
            }
        }
    }
}