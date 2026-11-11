
import java.util.*;

class Codechef {

    static boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        int[] incoming = new int[V];
        
        for (int i = 0; i < V; i++) {
            for (int node: adj.get(i)) {
                incoming[node]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 0; i < V; i++) {
            if (incoming[i] == 0) {
                q.add(i);
            }
        }
        
        int count = 0;
        while (!q.isEmpty()) {
            int top = q.poll();
            count++;
            
            
            for (int node: adj.get(top)) {
                incoming[node]--;
                if (incoming[node] == 0) {
                    q.add(node);
                }
            }
        }
        return count == V;
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
