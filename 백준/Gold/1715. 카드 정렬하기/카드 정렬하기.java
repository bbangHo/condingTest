import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            q.add(Integer.parseInt(br.readLine()));
        }

        int sum = 0;
        while (q.size() > 1) {
            int tmp = q.poll() + q.poll();
            sum += tmp;
            q.add(tmp);
        }

        System.out.println(sum);
    }
}
