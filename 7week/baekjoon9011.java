import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        for (int i = 0; i < T; i++) {
            int S = Integer.parseInt(bf.readLine());
            StringTokenizer st = new StringTokenizer(bf.readLine());

            int[] idx = new int[S];
            int[] arr = new int[S];
            List<Integer> list = new ArrayList<>();
            for (int j = S - 1; j >= 0; j--) {
                idx[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 0; j < S; j++)
                list.add(j + 1);
            boolean state = true;
            for (int j = 0; j < S; j++) {
                if (idx[j] >= list.size()) {
                    System.out.println("IMPOSSIBLE");
                    state = false;
                    break;
                } else {
                    arr[S - 1 - j] = list.get(idx[j]);
                    list.remove(idx[j]);
                }

            }

            if (state) {
                for (int j = 0; j < S; j++) {
                    System.out.println(arr[j]);
                }
            }
        }

    }
}