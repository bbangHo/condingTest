package week8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.PriorityQueue;

public class BaekJoon_1715_modified {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }
        int sum = 0;
        while(pq.size() > 1) {
            int first = pq.poll();
            int twice = pq.poll();
            sum += first + twice;
            pq.add(first + twice);
        }
        System.out.println(sum);
    }
}
