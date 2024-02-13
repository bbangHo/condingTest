#include<iostream>

using namespace std;

int preoder[1000];
int inorder[1000];

void tree(int start, int end, int pos);

int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int T;
	cin >> T;



	for(int  i = 0; i<T; i++)
	{
		int n;
		cin >> n;

		for (int i = 0; i < n; i++)
			cin >> preoder[i];
		for (int i = 0; i < n; i++)
			cin >> inorder[i];


		int start = 0;
	
		tree(start, n, 0);
		cout << "\n";
	}




	return 0;
}

void tree(int start, int end, int pos)//pos는 preorder기준 현재 인덱스 위치
{
	for (int i = start; i < end; i++)//자식이 없는경우에는 for문이 바로 종료됨
	{
		if (preoder[pos] == inorder[i])//후위 탐색 (왼쪽-> 오른쪽-> print)
		{
			tree(start, i, pos+1);//루트 기준 왼쪽을 탐색
			tree(i+1, end, pos+1 + i -start);
			cout << preoder[pos] << ' ';
		}
	}
}

