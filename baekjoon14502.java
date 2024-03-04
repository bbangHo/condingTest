import java.util.*;
import java.io.*;
public class Main{
    static int N;
    static int M;
    static int []dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] map;
    static int[][] virusmap;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args)throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i = 0 ; i <N; i++){
            st = new StringTokenizer(bf.readLine());
            for(int j = 0; j <M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        System.out.print(max);


    }

    static void dfs(int wallcount){
        if(wallcount == 3){
            bfs();
            return;
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j <M; j++){
                if(map[i][j] == 0){
                    map[i][j] = 1;
                    dfs(wallcount+1);
                    map[i][j] = 0;
                }


            }
        }
    }


    static void bfs(){
        Queue<int[]> q = new LinkedList<>();
        virusmap = new int[N][M] ;

        for(int i = 0; i <N; i++){
            for(int j = 0; j < M; j++){
                virusmap[i][j] = map[i][j];
                if(virusmap[i][j] == 2){
                    q.add(new int[]{i,j});
                }

            }
        }


        while(!q.isEmpty()){
            int []tmp = q.poll();
            int x = tmp[0];
            int y = tmp[1];
            for(int i = 0; i < 4; i++){
                int cx = x + dx[i], cy = y + dy[i];

                if(cx >=0  && cy >=0 && cx < N && cy <M && virusmap[cx][cy] == 0){
                    virusmap[cx][cy] = 2;
                    q.add(new int[]{cx,cy});
                }
            }
        }
        int cnt = 0;

        for(int i = 0; i <N; i++){
            for(int j =0; j < M; j++){
                if(virusmap[i][j] == 0)
                    cnt++;
            }
        }
        max = Math.max(cnt,max);

    }
}