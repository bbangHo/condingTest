package w2_shortest_path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj1916 {
    static class Node {
        int idx;
        int cost;

        public Node(int n, int c) {
            idx = n;
            cost = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PriorityQueue<Node> prioQ = new PriorityQueue<>((n1, n2) -> n1.cost - n2.cost);
        List<List<Node>> graph = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            Node n1 = new Node(v2, cost);

            graph.get(v1).add(n1);
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        boolean[] visited = new boolean[n+1];
        dist[start] = 0;

        prioQ.add(new Node(start, 0));    // 시작지점 추가

        while(!prioQ.isEmpty()) {
            Node now = prioQ.poll();
            if(now.idx == end) break;

            for (int j = 0; j < graph.get(now.idx).size(); j++) {
                Node next = graph.get(now.idx).get(j);

                if (!visited[now.idx] && dist[next.idx] > (dist[now.idx] + next.cost)) { // 거리 갱신
                    dist[next.idx] = dist[now.idx] + next.cost;
//                    prioQ.add(next);      처음에 우선순위 큐에 대해서 이해를 잘못해서 이렇게 설정하고 개뻘짓함
                    prioQ.add(new Node(next.idx, dist[next.idx]));
                }
            }

            visited[now.idx] = true;
        }
        System.out.println(dist[end]);
    }
}