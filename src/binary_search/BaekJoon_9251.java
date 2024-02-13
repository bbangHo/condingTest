package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon_9251 {
    static String A, B;
    static char[] AString, BString;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        A = bf.readLine();
        B = bf.readLine();

        AString = A.toCharArray(); //문자열을 char 배열로 변환
        BString = B.toCharArray();

        int[][] dp = new int[AString.length + 1][BString.length + 1];

        for (int i = 1; i <= AString.length; i++) {
            for (int j = 1; j <= BString.length; j++) {
                if (AString[i - 1] == BString[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(dp[AString.length][BString.length]);
    }
}
