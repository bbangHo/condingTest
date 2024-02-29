#include <iostream>
using namespace std;

int parent_[10001];
bool visit[10001];

int main(void)
{
	int T, N;
	int a, b;
	int node1, node2;

	cin >> T;
	for (int i = 0; i < T; i++)
	{
		cin >> N;
		
		for (int j = 1; j <= N; j++)
		{
			visit[j] = false;
			parent_[j] = 0;//자신의 부모는 모두 0으로 초기화
		}

		for (int j = 1; j < N; j++)
		{
			cin >> a >> b;
			parent_[b] = a;//b의 부모는 a 의미
		}

		cin >> node1 >> node2;

		visit[node1] = true;

		int root = 0;

		while (node1 != root)//루트 노드의 부모는 0임<나오지 않는 값>
		{
			node1 = parent_[node1];
			visit[node1] = true;
		}

		while (true)
		{
			if (visit[node2] == true)
			{
				cout << node2<<"\n";
				break;
			}
			node2 = parent_[node2];
		}
	}

	return 0;
}