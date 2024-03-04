import java.util.*;
import java.io.*;

public class Main{

    static class Bus {
        int index;
        int cost;

        public Bus(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }

    static final int INF = 1000 * 100000 + 1;
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());

        List<List<Bus>> graph = new ArrayList<>();

        for(int i = 0 ; i<=N; i++)
            graph.add(new ArrayList<>());

        int []distance = new int[N+1];

        Arrays.fill(distance,INF);

        for(int i = 0; i <M; i++){
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Bus(b,cost));

        }

        st = new StringTokenizer(bf.readLine());
        int start =Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(graph,distance,start,end);

    }

    public static void dijkstra(List<List<Bus>> graph,int []distance, int start, int end){
        PriorityQueue<Bus> pQ = new PriorityQueue<>((n1, n2) -> n1.cost - n2.cost);
        boolean [] check = new boolean[graph.size()];

        pQ.add(new Bus(start,0));
        distance[start] = 0;

        while(!pQ.isEmpty()) {
            Bus current = pQ.poll();
            if(current.index == end)
                break;

            for (int i = 0; i < graph.get(current.index).size(); i++) {
                Bus near = graph.get(current.index).get(i);
                if (!check[current.index] && distance[near.index] > distance[current.index]+ near.cost) {
                    distance[near.index] = distance[current.index] + near.cost;
                    pQ.add(new Bus(near.index, distance[near.index]));
                }
            }
            check[current.index] = true;
        }
        System.out.print(distance[end]);
    }
}