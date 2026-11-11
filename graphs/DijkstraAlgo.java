import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    static ArrayList<Integer> dijkstra(ArrayList<ArrayList<ArrayList<Integer>>> adj, int src) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );
        
        int V = adj.size();
        
        ArrayList<Integer> dist = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            dist.add(Integer.MAX_VALUE);
        }
        
        dist.set(src, 0);
        pq.offer(new int[]{0, src});
        
        
        while (!pq.isEmpty()) {
            int d = pq.peek()[0];
            int u = pq.peek()[1];
            pq.poll();
            
            if (d > dist.get(u)) {
                continue;
            }
            
            for (ArrayList<Integer> x: adj.get(u)) {
                int v = x.get(0);
                int weight = x.get(1);
                
                if (dist.get(v) > d + weight) {
                    dist.set(v, d + weight);
                    pq.offer(new int[]{dist.get(v), v});
                }
            }
        }
        return dist;
        
    }
    
    
    public static void main(String[] args) throws java.lang.Exception
    {
        ArrayList < ArrayList < ArrayList < Integer >>> adj =
            new ArrayList < > ();

        adj.add(new ArrayList < > (Arrays.asList(
            new ArrayList < > (Arrays.asList(1, 4)),
            new ArrayList < > (Arrays.asList(2, 8))
        )));

        adj.add(new ArrayList < > (Arrays.asList(
            new ArrayList < > (Arrays.asList(0, 4)),
            new ArrayList < > (Arrays.asList(4, 6)),
            new ArrayList < > (Arrays.asList(2, 3))
        )));

        adj.add(new ArrayList < > (Arrays.asList(
            new ArrayList < > (Arrays.asList(0, 8)),
            new ArrayList < > (Arrays.asList(3, 2)),
            new ArrayList < > (Arrays.asList(1, 3))
        )));

        adj.add(new ArrayList < > (Arrays.asList(
            new ArrayList < > (Arrays.asList(2, 2)),
            new ArrayList < > (Arrays.asList(4, 10))
        )));

        adj.add(new ArrayList < > (Arrays.asList(
            new ArrayList < > (Arrays.asList(1, 6)),
            new ArrayList < > (Arrays.asList(3, 10))
        )));

        int src = 0;
        
        ArrayList<Integer> result = dijkstra(adj, src);
        System.out.println(result);
    }
}
