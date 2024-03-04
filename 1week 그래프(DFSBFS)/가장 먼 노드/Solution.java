import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<List<Integer>> graph= new ArrayList<>();

        // n 까지 노드로 사용하기 때문에 0번쨰 인덱스 사용하지않고 1부터 시작해서 0 부터 까지 범위 설정 되는거
        //int [][]arr = new int[n+1][n+1] 해주는거랑 비슷하다고 생각하면 됨 아래 코드는 {{},{},{},{},{},{},{}} 이렇게 만드는 거임 여기에다 원하는거 추가해가는 방식
        for(int i =0; i<=n;i++){
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edge.length; i++) {
            int u = edge[i][0]; //ex) {3,6}이면 3
            int v = edge[i][1];// 6가져옴
            graph.get(u).add(v); //이 방법은 생각지도 못했다.. arraylist 잘 써야겠음 {{},{},{},{6},{},{},{}} 이렇게 됨
            graph.get(v).add(u); //{{},{},{},{6},{},{},{3}} 이렇게 됨
        }


        return bfs(graph);
    }

    private int bfs(List<List<Integer>> graph) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] check = new boolean[graph.size()+1];
        q.add(1);

        check[1] = true;
        int edge = 0;

        while (!q.isEmpty()){
            int size = q.size();
            edge = size;

            for(int i =0; i < size; i++){
                int current = q.poll();
                for (int n : graph.get(current)) {
                    if(check[n] == false){
                        q.add(n);
                        check[n] = true;
                    }

                }
            }

        }

        return edge;
    }
}
