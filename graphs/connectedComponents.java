
import java.util.*;

class Codechef {

    static void dfsRec(
        ArrayList<ArrayList<Integer>> adj,
        boolean[] visited,
        int node
    ) {
        visited[node] = true;

        for (int x : adj.get(node)) {
            if (!visited[x]) {
                dfsRec(adj, visited, x);
            }
        }
    }

    static int connectedComponents(ArrayList<ArrayList<Integer>> adj) {

        int V = adj.size();
        int count = 0;

        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {

            if (!visited[i]) {
                count++;
                dfsRec(adj, visited, i);
            }
        }

        return count;
    }

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        adj.add(new ArrayList<>(Arrays.asList(1)));
        adj.add(new ArrayList<>(Arrays.asList(0)));
        adj.add(new ArrayList<>(Arrays.asList(3)));
        adj.add(new ArrayList<>(Arrays.asList(2)));
        adj.add(new ArrayList<>());
        adj.add(new ArrayList<>());

        int count = connectedComponents(adj);

        System.out.println(count);
    }
}
