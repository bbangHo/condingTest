package w7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj1541_upgrade {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] minus = br.readLine().split("-");
        int sum = Integer.MAX_VALUE;

        for (String m : minus) {
            int tmp = 0;

            String[] add = m.split("\\+");
            tmp = Arrays.stream(add).mapToInt(Integer::parseInt).sum();

            if (sum == Integer.MAX_VALUE) {
                sum = tmp;  // 첫 번째 숫자인 경우
            } else {
                sum -= tmp;
            }
        }

        System.out.println(sum);
    }
}