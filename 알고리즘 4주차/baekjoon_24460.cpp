#include<iostream>
#include<vector>
#include <algorithm>

using namespace std;


int arr[1025][1025];
int Lotto(int start_x, int start_y, int end_x, int end_y);//x�� 2���� �迭�� ����

int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int N;
	cin >> N;

	for (int i = 1; i <= N; i++)
	{
		for (int j = 1; j <= N; j++)
			cin >> arr[i][j];
	}


	int answer = Lotto(1, 1, N, N);
	cout << answer;
	return 0;
}

int Lotto(int start_x, int start_y, int end_x, int end_y)//x�� 2���� �迭�� ����
{
	if (start_y == end_y)
		return arr[start_x][start_y];

	int mid_x = (start_x + end_x) / 2;
	int mid_y = (start_y + end_y) / 2;
	vector<int> V
	{
		Lotto(start_x, start_y, mid_x, mid_y),//1����
		Lotto(start_x, mid_y+1, mid_x, end_y),//2����
		Lotto(mid_x+1, start_y, end_x, mid_y),//3����
		Lotto(mid_x+1, mid_y+1, end_x, end_y)
		//Lotto(start����, start����, end����, end���� ��ǥ ��)
	};
	
	sort(V.begin(), V.end());
	return V[1];

}