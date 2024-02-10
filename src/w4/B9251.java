package w4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = new String();
        String str2 = new String();
        int[][] dp = new int[1001][1001];

        str1 = br.readLine();
        str2 = br.readLine();

        for(int i = 1; i <= str1.length(); i++) {
            char c1 = str1.charAt(i-1);
            for(int j = 1; j <= str2.length(); j++) {
                char c2 = str2.charAt(j-1);

                if(c1==c2)
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        System.out.println(dp[str1.length()][str2.length()]);

    }
}