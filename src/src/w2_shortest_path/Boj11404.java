package src.w2_shortest_path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj11404 {
    public static int INF = 100000001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] g = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            Arrays.fill(g[i], INF);
            g[i][i] = 0;
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            g[from][to] = Math.min(g[from][to], cost);
        }

        for (int middle = 1; middle <= n; middle++) {
            for (int from = 1; from <= n; from++) {
                for (int to = 1; to <= n; to++) {
                    g[from][to] = Math.min(g[from][to], g[from][middle] + g[middle][to]);
                }
            }
        }

        for (int from = 1; from <= n; from++) {
            for (int to = 1; to <= n; to++) {
                if(g[from][to] == INF) System.out.print("0 ");
                else System.out.print(g[from][to] + " ");
            }
            System.out.println();
        }
    }
}