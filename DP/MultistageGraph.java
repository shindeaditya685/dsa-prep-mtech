
import java.util.*;

class Codechef {

    static final long INF = Long.MAX_VALUE / 4;

    public static void main(String[] args) {

        int V = 8;

        long[][] graph = new long[V][V];

        for (int i = 0; i < V; i++) {
            Arrays.fill(graph[i], INF);
        }

        // Add directed weighted edges
        graph[0][1] = 2;
        graph[0][2] = 1;
        graph[0][3] = 3;

        graph[1][4] = 2;
        graph[1][5] = 3;

        graph[2][4] = 6;
        graph[2][5] = 7;
        graph[2][6] = 4;

        graph[3][5] = 2;
        graph[3][6] = 5;

        graph[4][7] = 6;
        graph[5][7] = 1;
        graph[6][7] = 2;

        long[] cost = new long[V];
        int[] next = new int[V];

        // Initialize DP arrays
        Arrays.fill(cost, INF);
        Arrays.fill(next, -1);

        // Base condition
        cost[V - 1] = 0;

        // DP: Calculate costs backwards
        for (int i = V - 2; i >= 0; i--) {

            for (int j = i + 1; j < V; j++) {

                if (graph[i][j] != INF && cost[j] != INF) {

                    long currentCost = graph[i][j] + cost[j];

                    if (currentCost < cost[i]) {
                        cost[i] = currentCost;
                        next[i] = j;
                    }
                }
            }
        }

        System.out.println("Minimum Cost: " + cost[0]);

        // Reconstruct path
        System.out.print("Path: ");

        int current = 0;

        while (current != -1) {

            System.out.print(current);

            if (current == V - 1) {
                break;
            }

            System.out.print(" -> ");

            current = next[current];
        }
    }
}
