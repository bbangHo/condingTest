import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        String[] signs = line.split("[0-9]");
        String[] nums = line.split("[+-]");

        List<String> list = new ArrayList<>();

        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);

            for (; idx < signs.length; idx++) {
                if (!signs[idx].equals("")) {
                    list.add(signs[idx]);
                    idx++;
                    break;
                }
            }
        }

        int sum = 0;
        int ans = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            String now = list.get(i);
            if (now.equals("+")) {
                continue;
            } else if (now.equals("-")) {
                ans -= sum;
                sum = 0;
            } else {
                sum += Integer.parseInt(now);
            }
        }

        ans += sum;
        System.out.println(ans);
    }
}