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
//3107

int main()
{
    string ans;
    cin >> ans;

    int count = 0;
    int check = 0;

    for (int i = 0; i < ans.length(); i++)
    {
        if (ans[i] == ':')
        {
            count++;
        }
        if (i > 0)
        {
            if (ans[i - 1] == ':' && ans[i] == ':') //����� ������ �Ѵ� :: ��� �ε��� ����
            {
                check = i - 1;
            }
        }
    }

    //32��Ʈ������ֱ�
    if (count < 7) //7�� ���ϸ� : �ʿ�
    {
        for (int i = 0; i <= 7 - count - 1; i++)
        {
            ans.insert(check + 1, ":"); //::�ΰ��� ���߰�
        }
    }
    else if (count > 7)
    {
        for (int i = 1; i < ans.length(); i++)
        {
            if (ans[i - 1] == ':' && ans[i] == ':')
            {
                ans.erase(i - 1, 1);
            }
        }
    }

    count = 0;
    for (int i = 0; i < ans.length(); i++)
    {
        count++;

        if (ans[i] == ':' && count < 5) //��ĭ�� 4���̹Ƿ� 
        {
            for (int j = 0; j < 5 - count; j++)
            {
                ans.insert(i - count + 1, "0"); //���ʿ� �߰�
            }
            i += 5 - count;
            count += 5 - count;
        }

        if (count == 5) //���ڰ� �� ����
            count = 0;
    }

    if (count < 4)
    {
        for (int i = 0; i < 4 - count; i++)
        {
            ans.insert(ans.length() - count, "0");
        }
    }
    cout << ans;