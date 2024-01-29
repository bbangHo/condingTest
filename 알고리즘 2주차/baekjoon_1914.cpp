//���� 1914 �ּҺ�� ���ͽ�Ʈ��
#include <iostream>
#include <vector>
#include <queue>
#define INF 987654321

using namespace std;

vector<pair<int, int>> bus[1001];
priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
//���ͽ�Ʈ��� �湮���� ���� ��� �� ���� ���� ��带 �����ؾ���
int dp[1001];

int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

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


	//���ͽ�Ʈ�� ����
	dp[first] = 0;//�ڽ��� ����ġ 0
	pq.push({ 0,first });//{���,����} greater<>�� ù ���Ҹ� �������� �����ؼ�

	while (!pq.empty()) 
	{
		int cost = pq.top().first;
		int pos = pq.top().second;
		pq.pop();

		if (cost > dp[pos])
			continue;
		
		for (int i = 0; i < bus[pos].size(); i++)//pos�� ����� ���õ�
		{
			int npos = bus[pos][i].first;//���� ����
			int ncost = cost + bus[pos][i].second;//���� ���ñ����� ��� + ������ ����� ���ñ����� ���

			if (ncost < dp[npos])//dp�� ��ϵ� ��뺸�� ncost�� �δٸ�
			{
				pq.push({ncost, npos}); //�켱���� ť�� ����
				dp[npos] = ncost;//dp����
			}
		}
	}



	cout << dp[last];

	return 0;
}