import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    
    static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        
        ArrayList<Integer> result = new ArrayList<>();
        
        int src = 4;
        visited[src] = true;
        queue.add(src);
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            result.add(curr);
            
            for (int node: adj.get(curr)) {
                if (!visited[node]) {
                    visited[node] = true;
                    queue.add(node);
                    
                }
            }
        }
        
        return result;
    }
    
    static void dfsRec(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int src, ArrayList<Integer> result) {
        visited[src] = true;
        result.add(src);
        
        for (int node: adj.get(src)) {
            if (!visited[node]) {
                dfsRec(adj, visited, node, result);
            }
        }
    }
    
    
    static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[adj.size()];
        ArrayList<Integer> result = new ArrayList<>();
        dfsRec(adj, visited, 0, result);
        
        return result;
    }
    
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		
		adj.add(new ArrayList<>(Arrays.asList(1, 2)));
        adj.add(new ArrayList<>(Arrays.asList(0, 2)));
        adj.add(new ArrayList<>(Arrays.asList(0, 1, 3, 4)));
        adj.add(new ArrayList<>(Arrays.asList(2)));
        adj.add(new ArrayList<>(Arrays.asList(2)));
		
		ArrayList<Integer> result1 = bfs(adj);
		ArrayList<Integer> result2 = dfs(adj);
		
		System.out.println(result1);
		System.out.println(result2);

	}
}
