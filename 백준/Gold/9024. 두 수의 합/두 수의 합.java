import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for(int r = 0; r < t; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            int min = Integer.MAX_VALUE;
            int cnt = 0;

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            int start = 0, end = n - 1;
            while(start < end) {
                int sum = arr[start] + arr[end];
                int tmp = Math.abs(sum - k);

                if(min > tmp) {
                    min = tmp;
                    cnt = 1;
                } else if(min == tmp) {
                    cnt++;
                }

                if(sum > k) end--;
                else start++;
            }

            sb.append(cnt);
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}