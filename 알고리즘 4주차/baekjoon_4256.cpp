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

void tree(int start, int end, int pos)//pos�� preorder���� ���� �ε��� ��ġ
{
	for (int i = start; i < end; i++)//�ڽ��� ���°�쿡�� for���� �ٷ� �����
	{
		if (preoder[pos] == inorder[i])//���� Ž�� (����-> ������-> print)
		{
			tree(start, i, pos+1);//��Ʈ ���� ������ Ž��
			tree(i+1, end, pos+1 + i -start);
			cout << preoder[pos] << ' ';
		}
	}
}

