package w4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B4256_use_array {
    //    static int[] preorder;
    static Queue<Integer> preorder;
    static int[] inorder;
    static int n;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        int iter = Integer.parseInt(br.readLine());
        for (int k = 0; k < iter; k++) {
            n = Integer.parseInt(br.readLine());
            preorder = new LinkedList<>();
            inorder = new int[n + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                preorder.add(Integer.parseInt(st.nextToken()));
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                inorder[i] = Integer.parseInt(st.nextToken());
            }

            postorder(1, n);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void postorder(int start, int end) {
        if (preorder.isEmpty()) return;
        else if (start > end) {
            return;
        }

        int root = preorder.poll();

        for (int idx = 1; idx <= n; idx++) {
            if (root == inorder[idx]) {
                postorder(start, idx - 1);
                postorder(idx + 1, end);
                sb.append(root + " ");
            }
        }
    }
}