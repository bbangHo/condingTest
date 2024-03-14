import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            int[] ans = new int[n];
            boolean isPossible = true;
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<Integer> nums = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                nums.add(j + 1);
                arr[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = n - 1; j >= 0; j--) {
                if (arr[j] < nums.size()) {
                    ans[j] = nums.get(arr[j]);
                    nums.remove(arr[j]);
                } else {
                    isPossible = false;
                    break;
                }
            }

            if (!isPossible)
                System.out.print("IMPOSSIBLE");
            else {
                Arrays.stream(ans).forEach(s -> System.out.print(s + " "));
            }
            System.out.println();
        }
    }
}