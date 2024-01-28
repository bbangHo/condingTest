package shortest_route;

import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        arr = new int[n+1][n+1];
        for(int i = 1; i < n + 1; i++) {
            arr[i][i] = 1;
        }
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = 1; // a > b;
            arr[b][a] = -1; // b > a;
        }

        Floyd();
        print();
    }

    private static void Floyd(){
        for(int k = 1; k < n + 1; k++) {
            for(int i = 1; i < n + 1; i++) {
                for(int j = 1; j < n + 1; j++) {
                    if(arr[i][k] == 1 && arr[k][j] == 1) {
                        arr[i][j] = 1;
                    }

                    if(arr[i][k] == -1 && arr[k][j] == -1) {
                        arr[i][j] = -1;
                    }
                }
            }
        }
    }

    private static void print(){
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < n + 1; i++) {
            int count = 0;
            for(int j = 1; j < n + 1; j++) {
                if(arr[i][j] != 0) {
                    count++;
                }
            }
            sb.append((n - count) + "\n");

        }
        System.out.println(sb.toString());
    }
}