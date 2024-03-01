#include <vector>
#include <algorithm>
using namespace std;

int FindMiddle(int In[], int Out[]);
int FindStick(int In[], int Out[]);
int FindEight(int In[], int Out[]);

int MAX = 0;

vector<int> solution(vector<vector<int>> edges) {

    int In[1000001] = { 0, };
    int Out[1000001] = { 0, };

    int a = 0;
    int b = 0;
    for (int i = 0; i < edges.size(); i++)
    {
        a = edges[i][0];
        b = edges[i][1];
        In[b] += 1;
        Out[a] += 1;
        MAX = max(max(MAX, a), b);
    }

    vector<int> ans =
    {
        FindMiddle(In, Out),
        FindStick(In, Out),
        FindEight(In, Out)
    };

    int Donut = Out[ans[0]] - ans[1] - ans[2];
    ans.insert(ans.begin() + 1, Donut);

    return ans;
}//end\

int FindEight(int In[], int Out[])
{
    int eight = 0;
    for (int i = 1; i <= MAX; i++)
    {
        if (Out[i] == 2 && In[i] > 0)
            eight++;
    }
    return eight;
}

int  FindStick(int In[], int Out[])
{
    int stick = 0;
    for (int i = 1; i <= MAX; i++)
    {
        if (Out[i] == 0)
            stick++;
    }
    return stick;
}

int FindMiddle(int In[], int Out[])
{
    for (int i = 1; i <= MAX; i++)
    {
        if (Out[i] >= 2 && In[i] == 0)
            return i;
    }
}