package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon_15686 {
    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n, m;
    static int[][] map;
    static int min = Integer.MAX_VALUE;
    static ArrayList<Node> chickenList = new ArrayList<>(); //치킨집 위치를 저장하는 리스트
    static ArrayList<Node> houseList = new ArrayList<>(); // 집의 위치를 저장하는 리스트
    static boolean[] visited; // 뽑은 치킨집 체크

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1)
                    houseList.add(new Node(i, j));
                else if(map[i][j] == 2)
                    chickenList.add(new Node(i, j));
            }
        }

        visited = new boolean[chickenList.size()];
        backtracking(0, 0); //m개의 치킨집을 뽑는다.
        System.out.println(min);
    }

    public static void backtracking(int count, int idx) {
        if(count == m) { //치킨 거리의 최솟값을 구한다.
            int total = 0; // 도시의 치킨거리
            for(int i = 0; i < houseList.size(); i++) {
                int sum = Integer.MAX_VALUE;
                for(int j = 0; j < chickenList.size(); j++) {
                    if(visited[j]) { //i번째 집에서부터 j번째 치킨집 까지의 거리 중 최소값을 구한다.
                        int dist = Math.abs(houseList.get(i).x - chickenList.get(j).x)
                                + Math.abs(houseList.get(i).y - chickenList.get(j).y);
                        sum = Math.min(sum, dist);
                    }
                }
                total += sum;
            }
            min = Math.min(total, min);
            return;
        }

        for(int i = idx; i < chickenList.size(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                backtracking(count + 1, i + 1);
                visited[i] = false;
            }
        }
    }
}
