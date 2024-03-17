package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_14500 {
    static int n, m, max = Integer.MIN_VALUE;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        map = new int[n][m];
        visited = new boolean[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(br.readLine());
            }
        }

        // dfs
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                visited[i][j] = true;
                solve(i,j,map[i][j],1);
                visited[i][j] = false;
            }
        }

        System.out.println(max);
    }

    static void solve(int row, int col, int sum, int count) {

        // 테트로미노 완성 시 수들의 합 계산
        if(count == 4) {
            max = Math.max(max, sum);
            return;
        }

        // 상하좌우 탐색
        for(int i = 0; i < 4; i++) {
            int curRow = row + dx[i];
            int curCol = col + dy[i];

            // 범위 벗어나면 예외 처리
            if(curRow < 0 || curRow >= n || curCol < 0 || curCol >= m) {
                continue;
            }

            // 아직 방문하지 않은 곳이라면
            if(!visited[curRow][curCol]) {
                // 보라색(ㅗ) 테트로미노 만들기 위해 2번째 칸에서 탐색 한번 더 진행(3번째 칸에서 다시 2번째 칸 갔다가 한 칸 더 이동)
                if(count == 2) {
                    visited[curRow][curCol] = true;
                    solve(row, col, sum + map[curRow][curCol], count + 1);
                    visited[curRow][curCol] = false;
                }

                visited[curRow][curCol] = true;
                solve(curRow, curCol, sum + map[curRow][curCol], count + 1);
                visited[curRow][curCol] = false;
            }
        }
    }
}
