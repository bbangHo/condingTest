package w3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj12738_failure {

    /**
     * 1% 에서 틀림
     * 원인 모르겠음
     */

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(bf.readLine());
        int[] arr = new int[n + 1];

        st = new StringTokenizer(bf.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> lis = new ArrayList<>();
        lis.add(-1_000_000_001);

        for (int i = 1; i <= n; i++) {
            int idx = binarySearchToGetIndex(lis, arr[i], 0, lis.size() - 1);
            if (lis.get(idx) >= arr[i])     //
                lis.set(idx, arr[i]);
            else if(lis.get(lis.size() - 1) < arr[i])
                lis.add(arr[i]);
        }
        System.out.println(lis.size() - 1);     // index = 0 일 때 뺴고
    }

    public static int binarySearchToGetIndex(List<Integer> lis, int k, int left, int right) {
        if(left > right) return -1;     // 값을 못 찾았음

        int mid = (left + right) / 2;
        int idx = 0;

        if(lis.get(mid) == k)
            return mid;
        else if(lis.get(mid) < k)
            idx = binarySearchToGetIndex(lis, k, mid + 1, right);
        else if(lis.get(mid) > k)
            idx = binarySearchToGetIndex(lis, k, left, mid - 1);

        return idx == -1 ? mid : idx;   // 탐색 실패시 mid를 성공시 찾은 idx를 반환
    }
}