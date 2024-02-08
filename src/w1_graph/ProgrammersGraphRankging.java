package w1_graph;

import java.util.Arrays;

public class ProgrammersGraphRankging {
    public static int[][] wg;
    public static int[][] lg;
    public static boolean[] visited;

    public int solution(int n, int[][] results) {
        wg = new int[n+1][n+1]; // 이기는 그래프
        lg = new int[n+1][n+1]; // 지는
        visited = new boolean[n+1];

        for (int[] result : results) {
            wg[result[0]][result[1]] = 1;
            lg[result[1]][result[0]] = 1;
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            Arrays.fill(visited, false);
            int t1 = dfs(i, n, wg);
            Arrays.fill(visited, false);
            int t2 = dfs(i, n, lg);

            if((t1 + t2) == n-1)
                count++;
        }

        return count;
    }

    public static int dfs(int start, int n, int[][] g) {
        if(visited[start])
            return 0;
        visited[start] = true;

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if(g[start][i] == 1 && !visited[i]) {
                count += dfs(i, n, g) + 1;
            }
        }
        return count;
    }

}