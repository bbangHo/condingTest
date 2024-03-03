#include <algorithm>

using namespace std;

long long solution(int n, vector<int> times)
{
    long long answer = 0;
    sort(times.begin(), times.end());

    long long min = 1;
    long long max = (long long)times.back() * (long long)n;//�� ��ȯ ����

    while (min <= max)
    {
        long long totalTime = 0;
        long long mid = (min + max) / 2;

        for (long long c : times)
            totalTime += mid / c;

        if (totalTime >= n)//�ð��� �ʹ� �����Ӱ� ����
        {
            answer = mid;
            max = mid - 1;
        }
        else//�ð��� �ʹ� �����ϰ� ���� 
        {
            min = mid + 1;
        }
    }
    return answer;
}