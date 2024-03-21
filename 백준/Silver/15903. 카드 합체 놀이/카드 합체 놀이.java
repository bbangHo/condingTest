import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Queue<Long> q = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            q.add(Long.parseLong(st.nextToken()));
        }

        int cnt = 0;
        while(cnt < m) {
            Long sum = q.poll() + q.poll();
            q.add(sum); q.add(sum);
            cnt++;
        }

        Long ans = 0L;
        for(Long i : q) {
            ans += i;
        }
        System.out.println(ans);
    }
}