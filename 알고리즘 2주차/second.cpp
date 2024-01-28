//백준 10159 저울
#include <iostream>

using namespace std;

bool arr[101][101];
bool index[101][101];
int main(void)
{
	int N, M;
	cin>> N >> M;

	for (int i = 1; i <=N; i++)
	{
		for (int j = 1; j <= N; j++)
		{
			if (i == j)
				arr[i][j] = true;
			else
				arr[i][j] = false;
		}

	}

	int win, lose;

	for (int i = 0; i < M; i++)
	{
		cin >> win >> lose;
		arr[win][lose] = true;
		arr[lose][win] = false;
	}

	for (int i = 1; i <= N; i++)//중간유통
	{
		for (int j = 1; j <= N; j++)//시작
		{
			for (int k = 1; k <= N; k++)//끝
			{
				if (arr[j][i] && arr[i][k])
					arr[j][k] = true;
			}
		}
	}
	

	int count = 0;
	//한 인덱스를 기준으로 가로줄 세로줄이 모두 false로 중첩되는 경우
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			index[i][j] = arr[i][j];
		}

		for (int k = 1; k <= N; k++) {
			if (arr[k][i] == index[i][k])
				count++;
		}
		cout << count - 1 << "\n";
		count = 0;
	}




	return 0;
}