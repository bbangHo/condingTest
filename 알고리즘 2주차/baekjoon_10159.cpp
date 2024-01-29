//백준 10159 저울 워셜플로이드
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
	//한 인덱스를 기준으로 가로줄 세로줄이 모두 false로 중첩되는 경우(둘 중 하나가 이기거나 지면 무조건 상반되게 나옴)
	//(1,2) = true면 (2,1) = false임.
	//동시에 false가 나온거면 누가 이기고 진건지 모른다는 의미
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
