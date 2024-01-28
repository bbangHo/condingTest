package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Question3 {

    static boolean[] visited;
    static  int[][] edge;
    static int[] distance;
    static int dist = 0;
    static int answer = 0;

    public static void main(String[] args) {
        int n;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();

        edge = new int[n + 1][n + 1];
        visited = new boolean[n + 1];
        distance = new int[n + 1];

        for(int i = 0; i < n + 1; i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            edge[a][b] = edge[b][a] = 1;
        }

        bfs(1);
        Arrays.sort(distance);
        for(int i = n; i > 0; i--){
           if(distance[i] == distance[i-1])
               answer++;
           else
               break;
        }
        System.out.println(answer);
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int n = queue.poll();
            dist = distance[n] + 1;

            for (int i = 1; i < edge.length; i++) {
                if (edge[n][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                    distance[i] = dist;
                }
            }
        }
    }
}
