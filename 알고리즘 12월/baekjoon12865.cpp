#include <iostream>
#include <vector>
using namespace std;

int dp[101][100001] = { 0, };//아이템 갯수, 무게
int weight[101] = { 0, };
int price[101] = { 0, };

int main(void)
{
	int N, K;
	cin >> N >> K;

	for (int i = 1; i <= N; i++)
		cin >> weight[i] >> price[i];

	for (int i = 1; i <= N; i++)
	{
		for (int j = 1; j <= K; j++)
		{
			if (j - weight[i] >= 0)
				dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - weight[i]] + price[i]);
			else
				dp[i][j] = dp[i - 1][j];
		}
	}

	int answer = 0;
	for (int i = 0; i <= N; i++)
	{
		for (int j = 0; j <= K; j++)
			answer = max(answer, dp[i][j]);
	}
	cout << answer;

	return 0;
}