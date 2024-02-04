#include <iostream>
#include <algorithm>
#include<vector>

using namespace std;

vector<int> V;
int arr[1000000];


int main() {
    int N;
    cin >> N;
    
    for (int i = 0; i < N; i++)
        cin >> arr[i];

    V.push_back(arr[0]);
    for (int i = 0; i < N; i++)
    {
        if (arr[i] > V[V.size() - 1])
            V.push_back(arr[i]);
        else
        {
            int left = 0;
            int right = V.size() - 1;

            while (left <= right)
            {
                int mid = (left + right) / 2;
                if (V[mid] >= arr[i])
                    right = mid - 1;
                else
                    left = mid + 1;
            }
            V[left] = arr[i];//while문은 left가 right자리로 오면서 종료되었음 
        }
    }

    cout << V.size();


    return 0;
}
