import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    
    static ArrayList<Integer> topologicalSortUsingBFS(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        
        int[] incoming = new int[V];
        
        for (int i = 0; i < V; i++) {
            for (int node: adj.get(i)) {
                incoming[node]++;
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < V; i++) {
            if (incoming[i] == 0) {
                queue.add(i);
            }
        }
        
        
        ArrayList<Integer> result = new ArrayList<>();
        
        while (!queue.isEmpty()) {
            int top = queue.poll();
            result.add(top);
            
            for (int node: adj.get(top)) {
                incoming[node]--;
                if (incoming[node] == 0) {
                    queue.add(node);
                }
            }
        }
        
        return result;
        
        
    }
    
    
    static void dfsRec(int src, boolean[] visited, ArrayList<ArrayList<Integer>> adj, Stack<Integer> stack) {
        visited[src] = true;
        
        for (int node: adj.get(src)) {
            if (!visited[node]) {
                dfsRec(node, visited, adj, stack);
            }
        }
        
        stack.push(src);
    }
    
    
    static ArrayList<Integer> topologicalSortUsingDFS(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        Stack<Integer> stack = new Stack<>();
        
        boolean[] visited = new boolean[V];
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfsRec(i, visited, adj, stack);
            }
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        
        return result;
    }
    
    
	public static void main (String[] args) throws java.lang.Exception
	{

		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		
		adj.add(new ArrayList<>(Arrays.asList(1)));
        adj.add(new ArrayList<>(Arrays.asList(2)));
        adj.add(new ArrayList<>(Arrays.asList()));
        adj.add(new ArrayList<>(Arrays.asList(2, 4)));
        adj.add(new ArrayList<>(Arrays.asList()));
		
		ArrayList<Integer> result1 = topologicalSortUsingBFS(adj); // Kahn's Algorithm
		
		ArrayList<Integer> result2 = topologicalSortUsingDFS(adj);
		
		System.out.println(result1);
		System.out.println(result2);

	}
}
