package w2_shortest_path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj18352 {
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int distance = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            g.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            g.get(n1).add(n2);
        }

        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        int[] dist = new int[n + 1];
        int nowDistance = 0;
        Arrays.fill(dist, Integer.MAX_VALUE);
        visited[1] = true;

        while (!q.isEmpty() && nowDistance <= distance) {
            int qSize = q.size();

            for (int k = 0; k < qSize; k++) {
                int now = q.poll();
                dist[now] = dist[now] > nowDistance ? nowDistance : dist[now];

                for (int i = 0; i < g.get(now).size(); i++) {
                    int next = g.get(now).get(i);

                    if (!visited[next]) {
                        q.add(next);
                        visited[next] = true;
                    }
                }
            }
            nowDistance++;
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if(dist[i] == distance) {
                System.out.println(i);
                count++;
            }
        }

        if(count == 0)
            System.out.println("-1");
    }
}