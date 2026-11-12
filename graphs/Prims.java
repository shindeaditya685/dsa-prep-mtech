
import java.util.*;

class Codechef {

    static int prims(int V, ArrayList<ArrayList<int[]>> adj) {

        boolean[] visited = new boolean[V];

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        pq.add(new int[]{0, 0});

        int sum = 0;
        int count = 0;

        while (!pq.isEmpty()) {

            int[] curr = pq.poll();

            int weight = curr[0];
            int node = curr[1];

            if (visited[node]) {
                continue;
            }

            visited[node] = true;
            sum += weight;
            count++;

            for (int[] edge : adj.get(node)) {

                int neighbour = edge[0];
                int edgeWeight = edge[1];

                if (!visited[neighbour]) {
                    pq.add(new int[]{edgeWeight, neighbour});
                }
            }
        }

        // Check if all vertices are connected
        if (count != V) {
            return -1;
        }

        return sum;
    }

    public static void main(String[] args) throws java.lang.Exception {

        int V = 4;

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Undirected edges

        adj.get(0).add(new int[]{1, 1});
        adj.get(1).add(new int[]{0, 1});

        adj.get(0).add(new int[]{2, 3});
        adj.get(2).add(new int[]{0, 3});

        adj.get(1).add(new int[]{2, 5});
        adj.get(2).add(new int[]{1, 5});

        adj.get(1).add(new int[]{3, 2});
        adj.get(3).add(new int[]{1, 2});

        adj.get(2).add(new int[]{3, 1});
        adj.get(3).add(new int[]{2, 1});

        int sum = prims(V, adj);

        System.out.println(sum);
    }
}
