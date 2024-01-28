package shortest_route;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_11404 {
    public static int n;
    public static int[][] distance;
    public static final int INF = 1000000001;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        n = Integer.parseInt(br.readLine());

        int m = Integer.parseInt(br.readLine());

        distance = new int[n +1][n +1];

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(i == j)
                    continue;
                distance[i][j] = INF;
            }
        }

       for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            distance[start][end] = Math.min(distance[start][end], time);
        }

        floydWarshall();
        print();
    }

    public static void floydWarshall() {
        // 기준이 되는 거쳐가는 노드 K
        for(int k = 1; k <= n; k++) {
            // 출발하는 노드 i
            for(int i = 1; i <= n; i++) {
                // 도착하는 노드 j
                for(int j = 1; j <= n; j++) {
                    //i에서 k를 거쳤다가 k에서 j 까지 가는 거리와 i에서 j 까지 가는 거리를 비교해서 작은 값이 최소거리
                    distance[i][j] = Math.min(distance[i][k] + distance[k][j], distance[i][j]);
                }
            }
        }
    }

    public static void print() {
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(distance[i][j] >= INF)
                    sb.append("0 ");
                else
                    sb.append(distance[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}

