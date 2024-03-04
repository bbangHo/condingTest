import java.io.*;
import java.util.*;

public class Main{
    static final int INF = 987654321;
    public static void main(String[] args) throws IOException{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int m = Integer.parseInt(bf.readLine());

        int[][] graph = new int[n+1][n+1];
        for(int i = 1; i<=n; i++){
            Arrays.fill(graph[i],INF);
            graph[i][i] = 0;
        }



        for(int i = 0; i <m; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int a= Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            int c= Integer.parseInt(st.nextToken());

            if(graph[a][b] > c)
                graph[a][b] = c;

        }

        for(int k = 1 ; k<=n; k++){
            for(int i = 1 ; i<=n;i++){
                for(int j =1; j <=n; j++){
                    if(graph[i][k] + graph[k][j] < graph[i][j]){
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }


        for(int i = 1; i <= n; i++){
            for(int j = 1; j <=n; j++){
                if(graph[i][j] == INF)
                    graph[i][j] = 0;
                System.out.print(graph[i][j]+" " );
            }
            System.out.println();
        }

    }
}