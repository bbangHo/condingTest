#include <iostream>
#include <algorithm>

using namespace std;

int arr[300000];
 
int main(void)
{
	int N, M;
	cin >> N >> M;

	for (int i = 0; i < M; i++)
		cin >> arr[i];

	int total = 0;

	int high = 0;
	int low = 1;

	for (int i = 0; i < M; i++)
		high = max(high, arr[i]);

	int mid = 0;
	int Total = 0;//학생 수
	int answer = 0;

	while (low <= high)
	{
		Total = 0;
		mid = (high + low) / 2;

		for (int i = 0; i < M; i++)
		{
			Total += arr[i] / mid;
			if (arr[i] % mid != 0)
				Total += 1;
		}

		if (Total > N)//현재 학생 수를 넘겨버림
			low = mid + 1;

		else if (Total <= N)//보석을 안받아도 되는 경우도 있으므로  {<=} 등호 필요
		{
			high = mid - 1;
			answer = mid;
		}
	}

	cout << answer;



	return 0;
}
