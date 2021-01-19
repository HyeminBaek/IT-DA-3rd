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

int main()
{
    string s;
    cin >> s;

    int sum = 0;

    for(int i = 0; i < s.size(); i++)
    {
        if(sum == -1)
        {
            cout << 0 << endl;
            return;
        }

        if(s[i] == '(' || s[i] == '[') //���� ��ȣ�� ���ÿ� ����
        {
            st.push(s[i]); 
        }
        else{
            if(!st.empty()) //�����ִ� ��ȣ�ε� ��������� ����
            {
                cout << 0 << endl;
                return;
            }
            if(s[i] == ')')
            {
                if(st.top() == '(')
                {
                    st.pop();
                    st.push('2'); //()�� ���
                }
                else
                {
                    sum = checkstack(st, '[','(',2);
                }   
            }
            else
            {
                if(st.top() == '[')
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

        int total = 0;
        while(!st.empty())
        {
            if(st.top() == '(' || st.top() == ')' || 
            st.top() == '[' || st.top() == ']')
            {
                cout << 0 << endl;
                return;
            }
            
            //total += (int)st.pop();

        }

        cout << total << endl;

    }





    return 0;

}

int checkstack(stack<char> stack, char a, char b, int value)
{
    int result = 0;
    while(!stack.empty())
    {
      char top = stack.top();

      if(top == a)
        return -1;
      else if (top == b)
      {
          stack.pop();
          result *= value;
          stack.push((char)result);
          break;
      }
      else
      {
          //result += stack.pop() - '0';
      }
      
      return result;
      

    }
}