import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] jewelry = new int[m+1];
        int max = Integer.MIN_VALUE;
        for(int i = 1; i <= m; i++) {
            jewelry[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, jewelry[i]);
        }

        int left = 1;
        int right = max;
        int ans = Integer.MAX_VALUE;

        while(left<=right) {
            int count = 0;
            int mid = (left + right) / 2;

            for(int i = 1; i <= m; i++) {
                count += (int) Math.ceil((double) jewelry[i] / mid);
//                if(jewelry[i] % mid == 0)
//                    count += jewelry[i]/mid;
//                else
//                    count += jewelry[i]/mid + 1;
            }


            if(count > n) {
                left = mid + 1;
            } else {
                right = mid - 1;
                ans = mid;
            }
        }

        System.out.println(ans);
    }
}