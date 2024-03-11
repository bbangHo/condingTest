package w6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Boj11478 {
    public static String str;
    public static Set<String> set;
    public static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;
        str = br.readLine();
        set = new HashSet<>();
        for (int size = 1; size < str.length() + 1; size++) {
            for (int j = 0; j < str.length() - size + 1; j++) {
                sb = new StringBuilder();
                for (int k = j; k < j + size; k++) {
                    sb.append(str.charAt(k));
                }

                if (!set.contains(sb.toString())) {
                    ans++;
                    set.add(sb.toString());
                }
            }
        }
        System.out.println(ans);
    }
}