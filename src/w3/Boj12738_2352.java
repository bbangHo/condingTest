package w3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj12738_2352 {
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
            if (idx < lis.size() && lis.get(idx) >= arr[i])     // 삽입될 값이 마지막 값이 아니면서 가 최대인 값
                lis.set(idx, arr[i]);
            else if(lis.get(lis.size() - 1) < arr[i])       // 삽입 될 값이 마지막 값일 때는 뒤에 추가
                lis.add(arr[i]);
        }
        System.out.println(lis.size() - 1);     // index = 0 일 때 뺴고
    }

    // 이분 탐색을 잘못 구현해서 고생좀 했음
    public static int binarySearchToGetIndex(List<Integer> lis, int k, int left, int right) {
        if(left > right) return left;     // 값을 못 찾았음

        int mid = (left + right) / 2;

        if(lis.get(mid) == k)
            return mid;
        else if(lis.get(mid) < k)
            return binarySearchToGetIndex(lis, k, mid + 1, right);
        else
            return binarySearchToGetIndex(lis, k, left, mid - 1);
    }
}