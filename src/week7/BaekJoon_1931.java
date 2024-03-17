package week7;

import java.util.*;
import java.io.*;
public class BaekJoon_1931 {
    static class Pair {
        int start;
        int end;

        Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Pair[] intervals = new Pair[N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            intervals[i] = new Pair(start, end);
        }

        // end 값에 따라 오름차순 정렬하되, end 값이 같을 경우 start 값으로 오름차순 정렬
        Arrays.sort(intervals, Comparator.comparingInt((Pair p) -> p.end).thenComparingInt(p -> p.start));

        int time = 0, count = 0;
        for(int i = 0; i < N; i++){
            if(time <= intervals[i].start){
                time = intervals[i].end;
                count++;
            }
        }

        System.out.println(count);
    }
}
