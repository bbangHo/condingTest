package shortest_route;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dist;
    private static final int INF = 300001;
    static int N;
    static List<ArrayList<Integer>> list;

    public static void main(String[] args) throws IOException {
        int M, K, X;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        dist = new int[N + 1];
        Arrays.fill(dist, INF);
        for(int i=0; i<=N; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int destination = Integer.parseInt(st.nextToken());

            list.get(start).add(destination);
        }

        dijkstra(X);
        print(K);
    }

    static void dijkstra(int start) {
        PriorityQueue<Integer> que = new PriorityQueue<>();

        dist[start] = 0;
        que.offer(start);

        while( !que.isEmpty() ) {
            int q = que.poll();
            int start_nodeNum = q;

            for(int des : list.get(start_nodeNum)) {
                if(dist[des] > (dist[start_nodeNum] + 1)) {
                    dist[des] = dist[start_nodeNum] + 1;
                    que.offer(des);
                }
            }

        }
    }

    static void print(int K){
        boolean found = false;
        for (int i = 1; i <= N; i++) {
            if (dist[i] == K) {
                found = true;
                System.out.println(i);
            }
        }

        if (!found) {
            System.out.println("-1");
        }
    }
}
