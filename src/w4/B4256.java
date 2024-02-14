package w4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B4256 {
    public static class Node {
        public int num;
        public Node left;
        public Node right;

        public Node(int num) {
            this.num = num;
            left = null;
            right = null;
        }
    }

    static Queue<Integer> preorder;
    static int[] inorder;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int iter = Integer.parseInt(br.readLine());
        for(int k = 0; k < iter; k++) {
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

            Node tree = buildTree(1, n);
            postorder(tree);
            System.out.println();
        }
    }

    public static void postorder(Node tree) {

        if(tree.left != null)
            postorder(tree.left);
        if(tree.right != null)
            postorder(tree.right);
        System.out.print(tree.num + " ");
    }

    public static Node buildTree (int start, int end) {
        if(start > end)
            return null;
        else if(start >= end)
            return new Node(preorder.poll());

        int rootIndex = findIndex(preorder.poll());    // 루트 꺼내주기
        Node node = new Node(inorder[rootIndex]);
        node.left = buildTree(start, rootIndex - 1);
        node.right = buildTree(rootIndex + 1, end);

        return node;
    }

    public static int findIndex(int target) {
        int tmp = 0;
        for(int i = 1; i <= n; i++){
            if(inorder[i] == target) {
                tmp = i;
                break;
            }
        }
        return tmp;
    }

}