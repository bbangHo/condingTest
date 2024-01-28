#include <iostream>
#include <algorithm>
#define INF 100000000

using namespace std;

int arr[101][101];

int main(void) {

	int n, m;
	cin >> n;
	cin >> m;

	//초기화
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			if (i == j)
				arr[i][j] = 0;
			else
				arr[i][j] = INF;
		}
	}
	
	//채우기
	int start, end, cost;

	for (int i = 0; i < m; i++) {
		cin >> start >> end >> cost;
		arr[start][end] = min(arr[start][end], cost);
	}

	for (int i = 1; i <= n; i++) {//중간유통
		for (int j = 1; j <= n; j++) {//시작
			for (int k = 1; k <= n; k++)//끝
				arr[j][k] = min(arr[j][k], arr[j][i] + arr[i][k]);
		}
	}

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			if (arr[i][j] == INF)
				cout << 0 << ' ';
			else
				cout << arr[i][j] << ' ';
		}
		cout << "\n";
	}


	return 0;
}

