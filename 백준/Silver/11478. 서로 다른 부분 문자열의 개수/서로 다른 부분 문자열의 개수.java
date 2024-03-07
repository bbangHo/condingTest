import java.util.*;
import java.io.*;

public class Main {
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