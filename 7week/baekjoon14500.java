import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static int [][]map;
    static boolean[][] visited;
    static int MAX = Integer.MIN_VALUE;

    static int []dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args)throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M =  Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(bf.readLine());
            for(int j = 0 ; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                visited[i][j] = true;
                dfs(1,j,i,map[i][j]);
                visited[i][j] = false;

                combi(0,0,j,i,map[i][j]);
            }
        }

        System.out.println(MAX);

    }

    static void combi(int cnt, int start, int x, int y, int sum){
        if(cnt == 3){
            MAX = Math.max(MAX, sum);
            return;
        }

        for(int i = start; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx<0|| nx>M-1 || ny <0 || ny >N-1)
                continue;

            combi(cnt+1,i+1,x,y,sum+map[ny][nx]);
        }
    }

    static void dfs(int cnt, int x, int y, int sum){
        if(cnt == 4){
            MAX = Math.max(MAX, sum);
            return;
        }

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx<0|| nx>M-1 || ny <0 || ny >N-1)
                continue;

            if(visited[ny][nx])
                continue;

            visited[ny][nx] = true;
            dfs(cnt+1,nx,ny,sum+map[ny][nx]);
            visited[ny][nx] = false;
        }


    }
}