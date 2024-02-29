import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[]args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());

        int [][]graph = new int[N+1][N+1];
        for(int i = 0 ; i< M; i++){
            StringTokenizer st= new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = 1;
            graph[b][a] = -1;
        }

        for(int k = 1; k <=N; k++){
            for(int i = 1; i <=N; i++){
                for(int j = 1; j <=N; j++){
                    if(graph[i][k] == 1 && graph[k][j] == 1){
                        graph[i][j] = 1;
                        graph[j][i] = -1;

                    }
                }
            }
        }

        for(int i = 1; i <=N;i++){
            int count =-1;
            for(int j = 1; j <=N; j++){
                if(graph[i][j] == 0){
                    count ++;
                }
            }
            System.out.println(count);
        }



    }

}