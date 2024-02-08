package w2_shortest_path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj10159 {
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

        int[] comparableNum = new int[n + 1];
        Arrays.fill(comparableNum, n - 1);

        for (int i = 1; i <= n; i++) {
            boolean[] visited = new boolean[n + 1];
            for (int j = 1; j <= n; j++) {
                if (!visited[j] && i != j) {
                    if (g[i][j] == HEAVY)
                        comparableNum[i] -= dfs(g, n, j, HEAVY, visited);

                    if (g[i][j] == LIGHT)
                        comparableNum[i] -= dfs(g, n, j, LIGHT, visited);
                }
            }
        }
        for (int i = 1; i <= n; i++)
            System.out.println(comparableNum[i]);

    }

    public static int dfs(int[][] g, int n, int start, int heavyOrLight, boolean[] visited) {
        if (visited[start]) return 0;
        visited[start] = true;
        int count = 1;
        for (int i = 1; i <= n; i++) {
            if (g[start][i] == heavyOrLight) {
                count += dfs(g, n, i, heavyOrLight, visited);
            }
        }
        return count;
    }

}