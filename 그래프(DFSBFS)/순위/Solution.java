class Solution {
    public int solution(int n, int[][] results) {
            for(int i= 1; i <=n; i++){
                for(int j = 1; j <=n; j++){
                    if(graph[i][k] == 1 && graph[k][j] == 1){
                        int [][] graph = new int[n+1][n+1];
                        int answer = n;


                        for(int i = 0 ; i < results.length; i++){
                            int u = results[i][0];
                            int v = results[i][1];
                            graph[u][v] = 1;
                            graph[v][u] = -1;
                        }

                        for(int k = 1; k <= n; k++){
                        graph[i][j] = 1;
                        graph[j][i] = -1;
                    }
                }
            }
        }
        for(int i = 1; i < graph.length; i++){
            int count = 0;
            for(int j = 1; j < graph.length; j++){
                if(graph[i][j] == 0)
                    count++;
            }
            if(count >1)
                answer--;
        }
        return answer;
    }
}