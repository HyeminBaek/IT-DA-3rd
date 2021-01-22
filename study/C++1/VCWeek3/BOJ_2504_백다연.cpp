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
stack<char> st;
//2504 ��ȣ�� ��
//�ùٸ��� ������ 0���

//�����ؾ���

int checkstack(stack<char> st, char a, char b, int value)
{
    int result = 0;
    while (!st.empty())
    {
        char top = st.top();

        if (top == a)
            return -1;
        else if (top == b)
        {
            st.pop();
            result *= value;
            st.push((char)result);
            break;
        }
        else
        {
            result += st.top() - '0';
            st.pop();
        }

        return result;
    }
}

int main()
{
    string s;
    cin >> s;

    int sum = 0;

    for (int i = 0; i < s.length(); i++)
    {
        if (sum == -1)
        {
            cout << 0 << endl;
            return 0;
        }

        if (s[i] == '(' || s[i] == '[') //���� ��ȣ�� ���ÿ� ����
        {
            st.push(s[i]);
        }
        else
        {
            if (!st.empty()) //�����ִ� ��ȣ�ε� ��������� ����
            {
                cout << 0 << endl;
                return 0;
            }
            if (s[i] == ')')
            {
                if (st.top() == '(')
                {
                    st.pop();
                    st.push('2'); //()�� ���
                }
                else
                {
                    sum = checkstack(st, '[', '(', 2);
                }
            }
            else
            {
                if (st.top() == '[')
                {
                    st.pop();
                    st.push('3'); //[]�� ���
                }
                else
                {
                    sum = checkstack(st, '(', '[', 3);
                }
            }
        }

    }
        int total = 0;
        while (!st.empty())
        {
            if (st.top() == '(' || st.top() == ')' ||
                st.top() == '[' || st.top() == ']')
            {
                cout << 0 << endl;
                return 0;
            }

            total += st.top() - '0';
            st.pop();
        }

    
    cout << total << endl;

    return 0;
}
