#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int arr[40000];
vector<int> v;

int main() {

    int n;
    cin >> n;

    for (int i = 0; i < n; i++)
        cin >> arr[i];

    v.push_back(arr[0]);

    for (int i = 0; i < n; i++)
    {
        if (v.back() < arr[i])//v.back() ������ "����"�� ����
            v.push_back(arr[i]);
        else
        {
            int left = 0;
            int right = v.size()-1;//������ "�ε���"�� ����
            while (left <= right)
            {
                int mid = (left + right) / 2;
                if (v[mid] >= arr[i])
                    right = mid - 1;
                else
                    left = mid + 1;
            }
            v[left] = arr[i];
        }
    }

    cout << v.size();
    return 0;
}
