package shortest_route;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_1916 {
    static int[][] costArray;
    static boolean[] visited;
    static int mincost = Integer.MAX_VALUE;
    static int cost = 0;

    public static void main(String[] args) throws IOException {
        int N,M, start, end;

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        M = Integer.parseInt(st.nextToken());

        costArray = new int[N + 1][N + 1];
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(bf.readLine());
            int a,b,k;
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            costArray[a][b] = costArray[b][a] = k;
        }

        st = new StringTokenizer(bf.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        dfs(start, end); //dfs로 푸니까 시간초과
        System.out.println(mincost);
    }

    private static void dfs(int start, int end) {
        visited[start] = true;

        for(int j = start + 1; j < costArray.length; j++) {
            if(costArray[start][j] != 0 && !visited[j]) {
                cost += costArray[start][j];

                if(j == end){
                    if(cost < mincost){
                        mincost = cost;
                    }
                    cost -= costArray[start][j];
                    visited[start] = false;
                    break;
                }
                dfs(j, end);
                cost -= costArray[start][j];
            }
        }
    }
}
