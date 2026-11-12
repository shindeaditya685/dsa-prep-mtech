
import java.util.*;


class DSU {
    int[] parent;
    int[] rank;
    
    DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }
    
    int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        
        return parent[x];
    }
    
    void union(int u, int v) {
        int pu = find(u);
        int pv = find(v);
        
        if (pu == pv) {
            return;
        }
        
        if (rank[pu] < rank[pv]) {
            parent[pu] = pv;
        } else if (rank[pu] > rank[pv]) {
            parent[pv] = pu;
        } else {
            parent[pv] = pu;
            rank[pu]++;
        }
    }
}

class Codechef {
    
    static int kruskal(int V, int[][] edges) {
        Arrays.sort(edges, 
            (a, b) -> Integer.compare(a[2], b[2])
        );
        
        DSU dsu = new DSU(V);
        
        int sum = 0;
        int count = 0;
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            
            int weight = edge[2];
            
            if (dsu.find(u) != dsu.find(v)) {
                dsu.union(u, v);
                
                sum += weight;
                count++;
                
                if (count == V - 1) {
                    break;
                }
            }
        }
        
        if (count != V - 1) {
            return -1;
        }
        
        return sum;
    }

    

    public static void main(String[] args) {

        int V = 5;

        int[][] edges = {
            {0, 1, 2},
            {0, 3, 6},
            {1, 2, 3},
            {1, 3, 8},
            {1, 4, 5},
            {2, 4, 7},
            {3, 4, 9}
        };

        System.out.println(kruskal(V, edges));
    }
}
