//น้มุ DFS, BFS
#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>


using namespace std;

vector<int> Graph[1001];
int Visited[1001] = { 0, };
queue<int> que;


void DFS(int v);
void BFS(int v);


int main(void)
{
	int N;
	int M;
	int v;

	cin >> N >> M >> v;

	int v1; int v2;
	for (int i = 1; i <= M; i++)
	{
		cin >> v1 >> v2;
		Graph[v1].push_back(v2);
		Graph[v2].push_back(v1);
	}

	for (int i = 1; i <= N; i++)
		sort(Graph[i].begin(), Graph[i].end());

	DFS(v);

	cout << "\n";
	for (int i = 0; i <= N; i++)
		Visited[i] = 0;

	BFS(v);



	return 0;
}

void DFS(int v)
{
	Visited[v] = 1;
	cout << v << " ";

	int temp = 0;
	for (int i = 0; i < Graph[v].size(); i++)
	{
		temp = Graph[v][i];
		if (Visited[temp] != 1)
			DFS(temp);
	}
}

void BFS(int v)
{
	que.push(v);
	Visited[v] = 1;

	while (!que.empty())
	{
		int temp = que.front();
		cout << temp << " ";
		que.pop();


		int temp2 = 0;
		for (int i = 0; i < Graph[temp].size(); i++)
		{
			temp2 = Graph[temp][i];
			if (Visited[temp2] != 1)
			{
				que.push(temp2);
				Visited[temp2] = 1;
			}
		}
	}
}