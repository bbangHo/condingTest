import java.util.*;
import java.io.*;

public class Main {
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