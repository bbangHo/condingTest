#include <iostream>
#include <string>

using namespace std;

int main(void)
{
	string S, T;
	cin >> S >> T;

	int i = T.length() - 1;
	string tmp;
	while (i >= S.length())
	{
		if (T[i] == 'A')
		{
			i--;
		}
		else
		{
			for (int j = i - 1; j >= 0; j--)
				tmp += T[j];
			T = tmp;
			tmp = "";
			i--;
		}
	}

	int state = 0;
	for (int i = 0; i < S.length(); i++)
	{
		if (S[i] != T[i])
		{
			state = 1;
			break;
		}
	}
	if (state == 1)
		cout << 0;
	else
		cout << 1;


	return 0;
}