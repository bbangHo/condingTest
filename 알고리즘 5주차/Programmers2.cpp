#include <algorithm>

using namespace std;

long long solution(int n, vector<int> times)
{
    long long answer = 0;
    sort(times.begin(), times.end());

    long long min = 1;
    long long max = (long long)times.back() * (long long)n;//형 변환 주의

    while (min <= max)
    {
        long long Passenger = 0;
        long long mid = (min + max) / 2;

        for (long long c : times)
            Passenger += mid / c;

        if (Passenger >= n)//시간을 너무 여유롭게 잡음
        {
            answer = mid;
            max = mid - 1;
        }
        else//시간을 너무 빡빡하게 잡음 
        {
            min = mid + 1;
        }
    }
    return answer;
}
