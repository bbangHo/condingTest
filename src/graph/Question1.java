package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Question1 {
    static boolean[] visited;
    static int[][] arr;

    public static void main(String[] args) {
        int N, M, V;
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        V = scanner.nextInt();
        scanner.nextLine();

        arr = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            arr[a][b] = arr[b][a] = 1;
        }

        visited = new boolean[N + 1];
        dfs(V);
        System.out.println();

        visited = new boolean[N + 1];
        bfs(V);
    }

    private static void dfs(int v) {
        visited[v] = true;
        System.out.print(v + " ");

        if(v == arr.length)
            return;

        for(int j = 1; j < arr.length; j++) {
            if(arr[v][j] == 1 && !visited[j]) {
                dfs(j);
            }
        }
    }

    private static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(v);
        visited[v] = true;

        System.out.print(v + " ");

        while (!queue.isEmpty()) {
            int n = queue.poll();

            for (int i = 1; i < arr.length; i++) {
                if (arr[n][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    System.out.print(i + " ");
                    queue.offer(i);
                }
            }
        }
    }
}
