#include<iostream>
#include<vector>
#include <algorithm>

using namespace std;

int arr[1000001];

int indx_arr[1000001];
vector<int>v, ans;

int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N;
	cin >> N;
	for (int i = 1; i <= N; i++)
		cin >> arr[i];


	v.push_back(-1000000001);

	for (int i = 1; i <= N; i++)
	{
		if (arr[i] > v.back())
		{
			v.push_back(arr[i]);
			indx_arr[i] = v.size()-1;
		}
		else
		{
			int left = 1;
			int right = v.size()-1;
			while (left <= right)
			{
				int mid = (left + right) / 2;
				if (v[mid] >= arr[i])
					right = mid - 1;
				else
					left = mid + 1;
			}
			v[left] = arr[i];
			indx_arr[i] = left;
		}
	}

	cout << v.size()-1 << "\n";//0번 인덱스는 제외

	int LCS = v.size()-1;

	//역추적
	for (int i = N; i >= 1; i--)
	{
		if (indx_arr[i] == LCS)
		{
			ans.push_back(arr[i]);
			LCS--;
		}
	}

	sort(ans.begin(), ans.end());
	for (int c : ans)
		cout << c << ' ';


	return 0;
}


