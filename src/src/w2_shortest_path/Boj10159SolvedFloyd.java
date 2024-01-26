    package src.w2_shortest_path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj10159SolvedFloyd {
    public static int HEAVY = 1;
    public static int LIGHT = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] g = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            g[n1][n2] = HEAVY;    // 무거운 경우
            g[n2][n1] = LIGHT;    // 가벼운 경우
        }

        for (int middle = 1; middle <= n; middle++) {
            for (int start = 1; start <= n; start++) {
                for (int end = 1; end <= n; end++) {
                    if (g[start][middle] == HEAVY && g[middle][end] == HEAVY)
                        g[start][end] = HEAVY;
                    if (g[start][middle] == LIGHT && g[middle][end] == LIGHT)
                        g[start][end] = LIGHT;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= n; j++) {
                count += g[i][j] == 0 ? 1 : 0;
            }
                System.out.println(count - 1);  // 자기 거 제외
        }
    }
}