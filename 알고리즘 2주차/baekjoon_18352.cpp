//백준 18352 특정거리의 도시찾기
#include <iostream>
#include<queue>
#include <vector>
#define INF 987654321
using namespace std;

vector<int>graph[300001];
int dp[300001];
queue<int>q;

void BFS(int start);


int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int N, M, K, X;
	cin >> N >> M >> K >> X;


	int start, end;
	for (int i = 0; i < M; i++)
	{
		cin >> start >> end;
		graph[start].push_back(end);
	}

	//가중치 모두 1 => 다익스트라 말고 BFS도 가능
	//BFS


	
	fill_n(dp, N+1, INF);
	dp[X] = 0;
	q.push(X);
	BFS(X);

	int state = 0;
	for (int i = 1; i <= N; i++)
	{
		if (dp[i] == K)
		{
			cout << i << "\n";
			state = 1;
		}

	}
	if (state == 0)
		cout << -1;



	return 0;
}


void BFS(int start) 
{
	int node = 0;
	int cost = 0;
	while (!q.empty())
	{
		node = q.front();
		cost = dp[node];
		q.pop();

		for (int i = 0; i < graph[node].size(); i++)
		{
			int nextNode = graph[node][i];
			if (cost + 1 < dp[nextNode])
			{
				dp[nextNode] = cost + 1;
				q.push(nextNode);
			}
		}
	}
}