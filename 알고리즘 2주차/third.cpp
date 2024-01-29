//백준 1914 최소비용.
#include <iostream>
#include <vector>
#include <queue>
#define INF 987654321

using namespace std;

vector<pair<int, int>> bus[1001];
priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
//다익스트라는 방문하지 않은 노드 중 가장 작은 노드를 선택해야함
int dp[1001];

int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin.tie(NULL);

	int N, M;
	cin >> N >> M;

	int s, e, c;

	for (int i = 0; i < M; i++)
	{
		cin >> s >> e >> c;
		bus[s].push_back({ e,c });
	}

	int first, last;
	cin >> first >> last;

	fill_n(dp, 1001, INF);


	//다익스트라 시작
	dp[first] = 0;//자신은 가중치 0
	pq.push({ 0,first });//{비용,도시} greater<>가 첫 원소를 기점으로 정렬해서

	while (!pq.empty()) 
	{
		int cost = pq.top().first;
		int pos = pq.top().second;
		pq.pop();

		if (cost > dp[pos])
			continue;
		
		for (int i = 0; i < bus[pos].size(); i++)//pos와 연결된 도시들
		{
			int npos = bus[pos][i].first;//다음 도시
			int ncost = cost + bus[pos][i].second;//현재 도시까지의 비용 + 다음에 연결된 도시까지의 비용

			if (ncost < dp[npos])//dp에 기록된 비용보다 ncost가 싸다면
			{
				pq.push({ncost, npos}); //우선순위 큐에 삽입
				dp[npos] = ncost;//dp수정
			}
		}
	}



	cout << dp[last];

	return 0;
}
