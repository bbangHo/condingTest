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
	int Total = 0;//�л� ��
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

		if (Total > N)//���� �л� ���� �Ѱܹ���
			low = mid + 1;

		else if (Total <= N)//������ �ȹ޾Ƶ� �Ǵ� ��쵵 �����Ƿ�  {<=} ��ȣ �ʿ�
		{
			high = mid - 1;
			answer = mid;
		}
	}

	cout << answer;



	return 0;
}