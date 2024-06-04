import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class graphBFS {
    private int V;
    private LinkedList<Integer> adj[];

    graphBFS(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    public static void main(String[] args) {
        graphBFS g = new graphBFS(7);
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

        System.out.println("Breadth First Traversal " + "(starting from " + c + ")");

        g.BFS(c);
    }

    void addEdge(int src, int dest) {
        adj[src].add(dest);
    }

    void BFS(int s) {
        boolean visited[] = new boolean[V];

        LinkedList<Integer> queue = new LinkedList<>();

        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            s = queue.poll();
            System.out.print(s + " ");

            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }
}
