package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BaekJoon_1715 {
    public static void main(String[] args) throws IOException {
        int[] card;
        int[] total;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        card = new int[n];
        for(int i=0; i<n; i++){
            card[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(card);

        int tot = 0;
        total = new int[n - 1];
        if(n == 1)
            tot = card[0];
        else {
            int sum = card[0] + card[1];
            total[0] = sum;
            for (int i = 2; i < n; i++) {
                total[i - 1] = sum;
                sum += card[i];
            }

            for(int i = 0; i < total.length; i++){
                tot += total[i];
            }
        }

        System.out.println(tot);
    }
}
