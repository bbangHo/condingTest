package w4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B14002_dp {
    static int[] arr;
    static int[] dp;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        dp = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[1] = 1;
        int maxSize = 0;

        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < i; j++) {
                if(arr[j] < arr[i])
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
            }

            maxSize = Math.max(maxSize, dp[i]);
        }

        List<Integer> ans = new ArrayList<>();
        System.out.println(maxSize);
        for(int i = n; i > 0; i--) {
            if(maxSize == dp[i]) {
                ans.add(arr[i]);
                maxSize--;
            }
        }

        ans.stream()
                .sorted()
                .forEach(i -> System.out.print(i + " "));
    }
}