import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    static ArrayList < Integer > bfs(int[][] graph, int src) {
        ArrayList < Integer > result = new ArrayList < > ();
        int n = graph.length;

        boolean[] visited = new boolean[n];
        Queue < Integer > q = new LinkedList < > ();

        visited[src] = true;
        q.add(src);

        while (!q.isEmpty()) {
            int u = q.poll();
            result.add(u);

            for (int v = 0; v < n; v++) {
                if (graph[u][v] == 1 && !visited[v]) {
                    visited[v] = true;
                    q.add(v);
                }
            }
        }
        return result;
    }

    static ArrayList < Integer > dfs(int[][] graph, int u) {
        int n = graph.length;

        boolean[] visited = new boolean[n];
        ArrayList < Integer > result = new ArrayList < > ();

        dfsHelper(graph, u, visited, result);

        return result;
    }

    static void dfsHelper(int[][] graph, int u,
        boolean[] visited, ArrayList < Integer > result) {

        visited[u] = true;
        result.add(u);

        for (int v = 0; v < graph.length; v++) {
            if (graph[u][v] == 1 && !visited[v]) {
                dfsHelper(graph, v, visited, result);
            }
        }
    }


    public static void main(String[] args) throws java.lang.Exception
    {
        int[][] graph = {
            {
                0,
                1,
                0,
                1
            },
            {
                1,
                0,
                1,
                0
            },
            {
                0,
                1,
                0,
                1
            },
            {
                1,
                0,
                1,
                0
            }
        };
        int src = 0;
        ArrayList < Integer > result1 = bfs(graph, src);
        ArrayList < Integer > result2 = dfs(graph, src);

        System.out.println(result1);
        System.out.println(result2);

    }
}
