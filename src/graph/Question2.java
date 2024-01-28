class Solution {
    public int solution(int n, int[][] results) {
        boolean[][] adj = new boolean[n + 1][n + 1];

        for (int[] result : results)
            adj[result[0]][result[1]] = true;

        int count = 0;
        for (int i = 1; i < n + 1; ++i)
            if (dfs(i, adj, new boolean[n + 1], true)
                    + dfs(i, adj, new boolean[n + 1], false) == n - 1)
                ++count;
        return count;
    }

    // 깊이 우선 탐색 (DFS)을 사용하여 그래프를 탐색하고 주어진 방향으로의 승리 횟수를 계산
    private int dfs(int curNode, boolean[][] adj, boolean[] visited, boolean dir) {
        visited[curNode] = true;

        int wins = 0;
        for (int adjNode = 1; adjNode < adj.length; ++adjNode) {
            if (!visited[adjNode]) {
                // 방향이 정방향이고 현재 노드에서 인접한 노드로의 승리가 있는지 확인
                if (dir) {
                    if (adj[curNode][adjNode])
                        // 승리 횟수 증가 및 재귀적으로 더 탐색
                        wins += 1 + dfs(adjNode, adj, visited, true);
                } else {
                    // 방향이 역방향이고 인접한 노드에서 현재 노드로의 승리가 있는지 확인
                    if (adj[adjNode][curNode])
                        // 승리 횟수 증가 및 재귀적으로 더 탐색
                        wins += 1 + dfs(adjNode, adj, visited, false);
                }
            }
        }
        return wins;
    }
}