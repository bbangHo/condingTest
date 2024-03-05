package w5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj3584 {
    static class Node {
        public Node parent;
        public int num;
        public List<Node> childs = new ArrayList<>();

        public Node(int num) {
            this.num = num;
        }
    }

    public static Map<Integer, List<Integer>> edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int iter = 0; iter < t; iter++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st;
            edges = new HashMap<>();    // 트리 만들 때 찾는시간 1로 만들기 위함
            boolean[] rootfinder = new boolean[n + 1];    // 1 ~ n 중에 루트 찾기

            // tree 구성 준비
            for (int i = 0; i < n - 1; i++) {
                st = new StringTokenizer(br.readLine());
                int parent = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());
                rootfinder[child] = true;    // a가 b의 부모이면, 입력에서 root는 b에 없다.

                if (edges.containsKey(parent)) {
                    edges.get(parent).add(child);
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(child);
                    edges.put(parent, list);
                }
            }

            // 공통 조상을 찾을 애들
            st = new StringTokenizer(br.readLine());
            int target1 = Integer.parseInt(st.nextToken());
            int target2 = Integer.parseInt(st.nextToken());

            int rootNum = 0;
            for (int i = 1; i <= n; i++) {
                if (!rootfinder[i]) {
                    rootNum = i;
                    break;
                }
            }

            Node tree = treeBuilder(rootNum);   // 트리 구성

            Node targetNode1 = findNode(tree, target1);
            Node targetNode2 = findNode(tree, target2);

            // 공통 조상 찾기
            Set<Integer> set = new HashSet<>();
            while(targetNode1 != null) {
                set.add(targetNode1.num);
                targetNode1 = targetNode1.parent;
            }

            while(targetNode2 != null) {
                if(set.contains(targetNode2.num)) {
                    System.out.println(targetNode2.num);
                    break;
                } else
                    set.add(targetNode2.num);

                targetNode2 = targetNode2.parent;
            }
        }

    }

    public static Node treeBuilder(int rootNum) {
        List<Integer> childList = edges.get(rootNum);
        Node root = new Node(rootNum);

        for (int i = 0; childList != null && i < childList.size(); i++) {
            Node child = treeBuilder(childList.get(i));
            root.childs.add(child);    // 현재 root의 자식의 서브트리까지 모두 추가
            child.parent = root;
        }

        return root;
    }

    public static Node findNode(Node root, int num) {
        Node target = null;
        if (root.num == num)
            return root;

        for (int i = 0; i < root.childs.size(); i++) {
            target = findNode(root.childs.get(i), num);
            if(target != null)
                break;
        }

        return target;
    }
}