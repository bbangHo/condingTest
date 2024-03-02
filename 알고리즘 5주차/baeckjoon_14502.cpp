#include <iostream>
#include <algorithm>
#include <queue>
using namespace std;

void MakeWall(int arr[8][8], int Wallcount, int row, int col);
void FillVirus(int arr[8][8]);
void CountZone(int copy[8][8]);
void Spread(int copy[8][8], int x, int y);

queue<pair<int, int>> q;

int MAX = 0;
int N, M;

int main(void)
{
	cin >> N >> M;

	int arr[8][8] = { 0, };

	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < M; j++)
			cin >> arr[i][j];
	}
	int RemainWall = 3;
	int row = 0;
	int col = 0;
	MakeWall(arr, RemainWall, row, col);
	cout << MAX;

	return 0;
}

void Spread(int copy[8][8], int x, int y)
{
	
	if (x < 0 || x >= N || y < 0 || y >= M)
		return;
	
	if (copy[x][y] == 0)
	{
		copy[x][y] = 2;
		q.push({ x,y });
	}
}

void FillVirus(int arr[8][8])
{
	int copy[8][8];

	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < M; j++)
		{
			copy[i][j] = arr[i][j];
			if (copy[i][j] == 2)
				q.push({ i,j });
		}
	}

	while (!q.empty())
	{
		int x = q.front().first;
		int y = q.front().second;
		
		q.pop();

		Spread(copy, x + 1, y);
		Spread(copy, x - 1, y);
		Spread(copy, x, y - 1);
		Spread(copy, x, y + 1);
	}

	CountZone(copy);
}

void CountZone(int copy[8][8])
{
	int count = 0;
	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < M; j++)
		{
			if (copy[i][j] == 0)
				count++;
		}
	}
	MAX = max(MAX, count);
}

void MakeWall(int arr[8][8], int Wallcount, int row, int col)
{
	int Remain = Wallcount;
	if (Remain == 0)//안전 존 갯수 세어보기 시도
	{
		FillVirus(arr);
		return;
	}
	

	//0인 지점을 찾아 떠날 때, 원래 줄에서 한칸 아래로 내려가서 찾아야 할때
	//j값은 0이 되어야 한다. 안그러면 예로 중간에서 찾기 시작하면 중간보다 j앞쪽은
	//쳐다도 안보는 상황 발생
	for (int i = row; i < N; i++)
	{
		for (int j = (i == row ? col : 0); j < M; j++)
		{
			if (arr[i][j] == 0)
			{
				arr[i][j] = 1;
				Wallcount = Remain - 1;
				MakeWall(arr, Wallcount, i, j);
				arr[i][j] = 0;
			}
		}
	}
}