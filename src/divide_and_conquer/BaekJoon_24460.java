package divide_and_conquer;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon_24460 {
    static int N;
    static int[][] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        num = new int[N + 1][N + 1];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                num[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if(N == 1)
            System.out.println(num[0][0]);
        else
            System.out.println(selectSeat(N, 0, 0));
    }

    private static int selectSeat(int size, int x, int y) {
        if (size < 2) {
            return num[x][y];
        }

        int half = size / 2;
        int[] tmp = new int[4];

        for (int i = 0; i < 4; i++) {
            int nx = x + (i % 2) * half; // 0, 1, 0, 1
            int ny = y + (i / 2) * half; // 0, 0, 1, 1

            tmp[i] = selectSeat(half, nx, ny);
        }

        Arrays.sort(tmp);
        return tmp[1];
    }
}
