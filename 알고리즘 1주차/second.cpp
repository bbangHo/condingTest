//프로그래머스 순위
#include <vector>

using namespace std;

bool check[101][101] = { false, };

int solution(int n, vector<vector<int>> results) {

    for (int i = 0; i < results.size(); i++)
        check[results[i][0]][results[i][1]] = true;

    for (int k = 1; k <= n; k++)//중간유통지역
    {
        for (int i = 1; i <= n; i++)//세로 = 승리자
        {
            for (int j = 1; j <= n; j++)//가로 = 패배자
            {
                if (check[i][k] && check[k][j])
                {
                    check[i][j] = true;
                }
            }
        }
    }

    int count = 0;
    int answer = 0;
    for (int i = 1; i <= n; i++)
    {
        count = 0;
        for (int j = 1; j <= n; j++)
        {
            if (check[i][j] || check[j][i])//1개의 숫자가 지고 이기는 경우의 합이 n-1이 나오면 순위 확정
                count++;
        }
        if (count == n - 1)
            answer++;
    }
    return answer;
}