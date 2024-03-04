package week5;

import java.util.Arrays;

public class Programmers_43238 {
    public long solution(int n, int[] times) {
        Arrays.sort(times);

        long high = times[times.length - 1] * n;
        long answer = high;
        long low = 1;
        long mid;

        while (high > low + 1) {
            long sum = 0;
            mid = (high + low) / 2;
            for (int i = 0; i < times.length; i++) {
                sum += mid / times[i];
            }
            if (sum < n) {
                low = mid;
            } else {
                high = mid;
                answer = Math.min(answer, mid);
            }
        }

        return answer;
    }
}
