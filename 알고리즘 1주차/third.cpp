//프로그래머스 가장 먼노드
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;
vector<int>Graph[20001];
int visit[20001];
queue<int> que;


int solution(int n, vector<vector<int>> edge) {


    int node1, node2;
    for (int i = 0; i < edge.size(); i++) {
        node1 = edge[i][0];
        node2 = edge[i][1];
        Graph[node1].push_back(node2);
        Graph[node2].push_back(node1);
    }

    //BFS
    int k = 1;
    int distance = 1;
    que.push(k);
    visit[k] = distance;

    while (!que.empty()) {
        int temp = que.front();

        que.pop();

        for (int i = 0; i < Graph[temp].size(); i++) {
            int temp2 = Graph[temp][i];
            if (visit[temp2] == 0)
            {
                que.push(temp2);
                visit[temp2] = visit[temp] + 1;
            }
        }
    }

    int Max = 0;
    int answer = 0;

    for (int i = 1; i < n; i++)
    {
        Max = max(Max, visit[i + 1]);
    }

    for (int i = 1; i <= n; i++)
    {
        if (visit[i] == Max)
            answer++;
    }
    return answer;



}