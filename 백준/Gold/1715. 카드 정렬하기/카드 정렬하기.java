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
        if (q.size() == 1) {
            System.out.println(0);
        } else {
            while (!q.isEmpty()) {
                int tmp = 0;
                tmp += q.poll();
                tmp += q.poll();

                sum += tmp;
                if (q.isEmpty()) break;
                else {
                    q.add(tmp);
                }
            }

            System.out.println(sum);
        }
    }
}
