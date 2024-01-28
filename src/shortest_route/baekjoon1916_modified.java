package shortest_route;

import java.util.*;
import java.io.*;

public class baekjoon1916_modified {
    private static final int INF = Integer.MAX_VALUE / 16;
    static List<ArrayList<Node>> list;
    static int dist[];

    static int N;

    //현재 도시 정보 및 비용 관련 클래스
    static class Node implements Comparable<Node> {
        int nodeNum;
        int weight;

        public Node(int nodeNum, int weight) {
            this.nodeNum = nodeNum;
            this.weight = weight;
        }

        //비용 관련 오름차순 정렬
        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); // 도시의 개수
        int M = Integer.parseInt(br.readLine()); // 버스의 개수


        list = new ArrayList<>();
        dist = new int[N + 1];
        Arrays.fill(dist, INF);

        for(int i=0; i<=N; i++) {
            list.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());


            list.get(s).add(new Node(d, w));
        }

        st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int destination = Integer.parseInt(st.nextToken());

        System.out.println(dijkstra(start, destination));
    }

    static int dijkstra(int start, int destination) {
        PriorityQueue<Node> que = new PriorityQueue<Node>();
        boolean visited[] = new boolean[N + 1];

        dist[start] = 0;
        que.offer(new Node(start, 0));

        while( !que.isEmpty() ) {
            Node queNode = que.poll();
            int start_nodeNum = queNode.nodeNum;

            if( !visited[start_nodeNum] ) {
                visited[start_nodeNum] = true;

                for(Node node : list.get(start_nodeNum)) {

                    if( !visited[node.nodeNum] && dist[node.nodeNum] > (dist[start_nodeNum] + node.weight) ) {
                        dist[node.nodeNum] = dist[start_nodeNum] + node.weight;
                        que.offer(new Node(node.nodeNum, dist[node.nodeNum]));
                    }
                }
            }
        }

        return dist[destination];
    }

}
