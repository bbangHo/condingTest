package w8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj15686 {
    static class Point {
        int x;
        int y;
        public Point(int a, int b) {
            x = a;
            y = b;
        }
    }

    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Point> stores = new ArrayList<>();
        List<Point> homes = new ArrayList<>();

        int cnt = 0;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                int point = Integer.parseInt(st.nextToken());
                if(point == 1) {
                    homes.add(new Point(i + 1, j + 1));
                } else if(point == 2) {
                    stores.add(new Point(i + 1, j + 1));
                    cnt++;
                }
            }
        }

        combination(0, new boolean[cnt], m, stores, homes);
        System.out.println(ans);
    }

    public static void combination(int start, boolean[] check, int m, List<Point> stores, List<Point> homes) {
        if(m == 0) {
            int chickenDist = 0;
            for(int i = 0; i < homes.size(); i++) {
                Point home = homes.get(i);
                int min = 101;

                for(int j = 0; j < stores.size(); j++) {
                    if(check[j]) {
                        Point store = stores.get(j);
                        int dist = Math.abs(store.x - home.x) + Math.abs(store.y - home.y);
                        min = Math.min(min, dist);  // i 집에서 가장 가까운 치킨 집 찾기
                    }
                }
                chickenDist += min;     // 가장 짧은 치킨 거리
            }

            ans = Math.min(ans, chickenDist);
            return;
        }

        for(int i = start; i < stores.size(); i++) {
            check[i] = true;
            combination(i + 1, check, m - 1, stores, homes);
            check[i] = false;
        }
    }
}