package w1_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj1260 {
    public static boolean[] visited;
    public static Queue<Integer> queue;
    public static List<List<Integer>> g;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Integer n = Integer.parseInt(st.nextToken());
        Integer v = Integer.parseInt(st.nextToken());
        Integer start = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];
        queue = new LinkedList<>();

        g = new ArrayList<>();

        for(int i = 0; i <= n; i++) {
            g.add(new ArrayList<>());
        }

        for(int i = 1; i <= v; i++) {
            st = new StringTokenizer(br.readLine());

            Integer v1 = Integer.parseInt(st.nextToken());
            Integer v2 = Integer.parseInt(st.nextToken());

            g.get(v1).add(v2);
            g.get(v2).add(v1);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(g.get(i));
        }

        dfs(start);
        visited = new boolean[n + 1];
        System.out.println();
        bfs(start);

    }
    public static void dfs(int start) {
        if(visited[start])
            return;

        System.out.print(start + " ");
        visited[start] = true;

        for (int i = 0; i < g.get(start).size(); i++) {
            dfs(g.get(start).get(i));
        }
    }

    public static void bfs(int start) {
        queue.add(start);

        while(!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");
            visited[node] = true;

            for (int i = 0; i < g.get(node).size(); i++) {
                int next = g.get(node).get(i);

                if(!visited[next] && node != next) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
    }
}

