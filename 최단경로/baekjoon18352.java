import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[]args) throws IOException{
        List<List<Integer>> graph = new ArrayList<>();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());


        for(int i = 0 ; i <=N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i <M; i++){
            st = new StringTokenizer(bf.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph.get(A).add(B);
        }

        bfs(graph, X, K);

    }

    public static void bfs(List<List<Integer>> graph, int X, int K){
        Queue<Integer> q = new LinkedList<>();
        int[] distances = new int[graph.size()];
        Arrays.fill(distances, -1);
        q.add(X);
        distances[X] = 0;



        while(!q.isEmpty()){
            int current = q.poll();

            for(int near: graph.get(current)){
                if(distances[near] == -1){
                    q.add(near);
                    distances[near] = distances[current] + 1;
                }
            }
        }
        boolean found = false;
        for(int i = 1; i <distances.length; i++){
            if(distances[i] == K){
                System.out.println(i);
                found = true;
            }
        }

        if(!found)
            System.out.print(-1);
    }
}