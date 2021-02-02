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
//18352
//X�κ��� ����Ͽ� ������ �� �ִ� ���� �߿���, �ִ� �Ÿ��� K�� ��� ������ ��ȣ
//�����ؾ���
int n,m,k,x;
vector <int> answer;
vector <int> v[300001];
int visit[300001];

void bfs(int first)
{
    queue<int> q;
    q.push(first);

    while(!q.empty())
    {
        int now = q.front();
        q.pop();

        for(int i = 0; i < v[now].size(); i++)
        {
            int next = v[now][i]; //������� ����� ���
            if(visit[next] == 0) //�湮���� ���ٸ�
            {
                visit[next] = visit[now] + 1; // ������κ��� �Ÿ� ����
                q.push(next);
            }
        }


    }
}



int main()
{
    //���ð���, ���ΰ���, �Ÿ�����, ��ߵ���
    cin >> n >> m >> k >> x; 

    for(int i = 0; i <m; i++)
    {
        int a, b;
        cin >> a >> b;
        v[a].push_back(b);
    }

    visit[x] = 0; //����ϴ� ��
    bfs(x);

    for(int i = 1; i <=n; i++)
    {
        if(visit[i] == k)
            answer.push_back(i);
    }

    if(answer.size()== 0)
        cout << -1 << endl;
    
    else
    {
        sort(answer.begin(), answer.end());
        for(int i = 0; i < answer.size(); i++)
            cout << answer[i] << endl;
    }
    



    
    return 0;
}