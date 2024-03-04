import java.io.*;
import java.util.*;


public class Main {
    static int [][]arr;
    static boolean []check;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        arr = new int[N+1][N+1];
        check = new boolean[N+1];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(bf.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        dfs(V);
        sb.append("\n");
        check = new boolean[N+1];

        bfs(V);
        System.out.println(sb);


    }

    public static void dfs(int v){
        if(v == check.length)
            return;

        check[v] = true;
        sb.append(v + " ");

        for(int i = 1; i < check.length; i++){
            if(arr[v][i] == 1 && check[i] == false){
                dfs(i);
            }
        }
    }

    public static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(v);
        check[v] = true;


        while (!queue.isEmpty()) {
            v = queue.poll();
            sb.append(v + " ");

            for (int i = 1; i < check.length; i++) {
                if (arr[v][i] == 1 && check[i] == false) {
                    queue.add(i);
                    check[i] = true;

                }

            }
        }

    }

}