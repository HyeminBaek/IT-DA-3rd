#include <iostream>
#include <queue>
#include <vector>
#include <math.h>
#include <string.h>
#include <stack>
#include <string>
#include <utility>
#include <algorithm>

using namespace std;

int n, m, k, x;
int cnt[300001];
vector<int> v[300001];

void bfs()
{
    memset(cnt, -1, sizeof(cnt));
    queue<pair<int, int>> q;
    q.push({x, 0}); //����� �ֱ�
    cnt[x] = 0;

    while (!q.empty())
    {
        int first = q.front().first;
        int second = q.front().second;

        q.pop();

        for (int i = 0; i < v[first].size(); i++)
        {
            if (cnt[i] == -1)
            {
                q.push({i, second + 1}); //�����湮���� �ʾҴٸ� �Ÿ��� ��������
                cnt[i] = second + 1;
            }
        }
    }

    vector<int> ans;

    for (int i = 1; i <= n; ++i)
    {
        if (cnt[i] == k)
            ans.push_back(i); //ã�����ϴ� �Ÿ��϶� ����
    }

    if (ans.empty())
        ans.push_back(-1);

    for (int i = 0; i < ans.size(); i++)
        cout << ans[i] << endl;
}

int main()
{
    cin >> n >> m >> k >> x;

    for (int i = 0; i < m; i++)
    {
        int a, b;
        cin >> a >> b;

        v[a].push_back(b);
    }

    bfs();
}