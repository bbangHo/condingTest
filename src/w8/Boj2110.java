package w8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj2110 {
    static int n;
    static int c;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int left = 0;
//        int right = arr[0] + arr[n - 1] + 1;
        int right = 1_000_000_001;

        while (left < right) {
            int mid = (left + right) / 2;

            if (check(mid) >= c) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        /**
         * upperBound이기 때문에 -1 해줘야 한다.
         * upperbound는 결과값을 초과하는 첫번째 위치의 값이기 떄문
         */
        System.out.println(right - 1);

    }

    public static int check(int mid) {
        int i = 0;
        int count = 1;

        for (int j = 1; j < n; j++) {
            if (arr[j] - arr[i] >= mid) {
                count++;
                i = j;
            }
        }

        return count;
    }
}