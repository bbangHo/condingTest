#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

vector<pair<int, int>> v;

bool compare(pair<int, int> a, pair<int, int> b) 
{
	if (a.second == b.second)
		return a.first < b.first;
	return a.second < b.second;
}

int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N;
	cin >> N;

	for (int i = 0; i < N; i++)
	{
		int first, second;
		cin >> first >> second;
		v.push_back({ first, second });
	}

	sort(v.begin(), v.end(), compare);

	int max2 = 0;
	int count = 0;

	for (int i = 0; i < N; i++)
	{
		if (v[i].first >= max2)
		{
			max2 = v[i].second;
			count++;
		}
	}
	cout << count;


	return 0;
}