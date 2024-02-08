package w4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B14003 {
    static int[] arr;
    static int[] idx;
    static List<Integer> lis;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        idx = new int[n + 1];       // 역추적을 위한 인덱스값
        lis = new ArrayList<>();
        lis.add(-1_000_000_001);
        idx[0] = 0;

        for (int i = 1; i <= n; i++) {
            int index = lowerBound(0, lis.size() - 1, arr[i]);

            if (lis.get(lis.size() - 1) < arr[i]) {    // 최장 수열 마지막에 값이 될 수 있다면
                lis.add(arr[i]);
                idx[i] = lis.size() - 1;
            } else if (lis.get(index) >= arr[i]) {      //
                lis.set(index, arr[i]);
                idx[i] = index;
            }
        }

        List<Integer> ans = new ArrayList<>();
        int size = lis.size() - 1;    // 0 인덱스 떄문에 -1
        System.out.println(size);
        for(int i = n; i > 0; i--) {    // 알아보니 역출력 하는 과정은 stack 자료구조를 써도 된다.
            if(size == idx[i]) {        // 시간이 조금 더 빡빡한 경우 정렬이 아닌 스택을 써야겠다.
                ans.add(arr[i]);
                size--;
            }
        }

        ans.stream()
                .sorted()
                .forEach(i -> System.out.print(i + " "));
    }

    // 중복인 값 가장 첫 번째 인덱스 반환
    public static int lowerBound(int low, int high, int k) {
        while (low < high) {
            int mid = (low + high) / 2;

            if (lis.get(mid) < k)
                low = mid + 1;
            else // k <= mid
                high = mid;
        }
        return high;
    }
}