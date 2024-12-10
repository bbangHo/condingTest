#include <iostream>
#include <vector>
using namespace std;


int main(void)
{
	int N, M;
	cin >> N >> M;

	int num;

	vector<int> card;

	for (int i = 0; i < N; i++)
	{
		cin >> num;
		card.push_back(num);
	}



	int max = 0;
	for (int i = 0; i < N - 2; i++)
	{
		for (int j = i + 1; j < N - 1; j++)
		{
			for (int k = j + 1; k < N; k++)
			{
				int sum = card[i] + card[j] + card[k];
				if (sum <= M && sum > max)
				{
					max = sum;
				}
			}
		}
	}

	cout << max;

	return 0;
}