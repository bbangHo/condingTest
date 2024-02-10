#include<iostream>
#include<vector>

using namespace std;

vector<pair<int, int>> dp(1001, { 0, 1 });//¿Œµ¶Ω∫, dp
vector<int> answer;
int arr[1001];

int main(void)
{
	int N;
	cin >> N;

	for (int i = 1; i <= N; i++)
		cin >> arr[i];

	for (int i = 2; i <= N; i++)
	{
		for (int j = 1; j < i; j++)
		{
			if (arr[i] > arr[j] && dp[i].second < dp[j].second+1)
			{
				dp[i].first = j;
				dp[i].second = dp[j].second + 1;
			}
		}
	}

	int MAX = 0;
	int index = 0;
	for (int i = 1; i <= N; i++)
	{
		if (MAX < dp[i].second)
		{
			MAX = dp[i].second;
			index = i;
		}
	}

	answer.push_back(arr[index]);

	while (dp[index].first != 0)
	{
		index = dp[index].first;
		answer.push_back(arr[index]);
	}
	
	for (int i = answer.size() - 1; i >= 0; i--)
		cout << answer[i] << ' ';
	


	return 0;
}