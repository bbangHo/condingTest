package binary_search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_2792 {
    static int N,M;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int arr[] = new int[M];
        int left = 1, right = 0, mid = 0, sum, answer = 0;

        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            right = Math.max(right, arr[i]);
        }

        while (left <= right) {
            // 질투심이 mid가 되도록 보석 나눠주기
            mid = (left + right) / 2; // mid : 질투심
            sum = 0; // sum : 최소 인원 수
            for (int i = 0; i < M; i++) {
                sum += arr[i] / mid;
                if (arr[i] % mid != 0) {
                    sum++;
                }
            }
            // 보석을 나눠줄 수 없는 경우
            if (sum > N) {
                left = mid + 1;
            }
            // 보석을 나눠줄 수 있는 경우
            else {
                right = mid - 1;
                answer = mid;
            }
        }

        System.out.println(answer);


    }
}
