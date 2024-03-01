package w_6;

import java.util.*;

class P250136 {
    static int n;
    static int m;
    static int minCol;
    static int maxCol;
    static int[][] lnd;
    static int[][] dir = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};

    class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int solution(int[][] land) {
        n = land.length;
        m = land[0].length;

        lnd = land.clone();
        for(int i = 0; i < n; i++)
            lnd[i] = land[i].clone();

        int[] oilMax = new int[m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int oil = 0;

                if(lnd[i][j] == 1) {
                    // 찾은 석유 덩어리는 어떤 열에 시추관을 꽂아도 똑같이 한 덩어리기 때문에
                    // oilMax 배열에 저장하여 가장 큰 덩어리를 한 번에 찾기 위한 변수
                    // 즉 석유 덩어리의 가로길이를 알아뒀다가 배열에 저장하겠다.
                    minCol = 501; maxCol = 0;

                    Queue<Point> q = new LinkedList<>();
                    q.add(new Point(i, j));
                    oil = bfs(q);   // 석유 찾기

                    for(int k = minCol; k < maxCol + 1; k++) {
                        oilMax[k] += oil;
                    }
                }
            }
        }

        Arrays.sort(oilMax);

        return oilMax[m -1];
    }

    public int bfs(Queue<Point> q) {
        int cnt = 0;

        while(!q.isEmpty()) {
            Point p = q.poll();
            lnd[p.x][p.y] = 0;     // 방문처리
            cnt++;

            minCol = Math.min(minCol, p.y);
            maxCol = Math.max(maxCol, p.y);

            for(int i = 0; i < 4; i++) {
                int x = p.x + dir[i][0];
                int y = p.y + dir[i][1];

                if(x >= 0 && y >= 0 && x < n && y < m && lnd[x][y] == 1) {
                    lnd[x][y] = 0;     // 방문처리
                    q.add(new Point(x, y));
                }
            }
        }

        return cnt;
    }
}
