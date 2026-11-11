
import java.util.*;

class Codechef {

    static boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        boolean[] visited = new boolean[V];
        
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                Queue<int[]> q = new LinkedList<>();
                q.add(new int[]{i, - 1});
                
                while (!q.isEmpty()) {
                    int[] curr = q.poll();
                    
                    int node = curr[0];
                    int parent = curr[1];
                    
                    for (int neighbour : adj.get(node)) {
                        if (!visited[neighbour]) {
                            visited[neighbour] = true;
                            q.add(new int[]{neighbour, node});
                        } else if (neighbour != parent) {
                            return true;
                        }
                    }
                }
            }
            
        }
        
        return false;
    }

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        adj.add(new ArrayList<>(Arrays.asList(1)));
        adj.add(new ArrayList<>(Arrays.asList(0)));
        adj.add(new ArrayList<>(Arrays.asList(3)));
        adj.add(new ArrayList<>(Arrays.asList(2)));
        adj.add(new ArrayList<>());
        adj.add(new ArrayList<>());

        boolean result = isCycle(adj);

        System.out.println(result);
    }
}
