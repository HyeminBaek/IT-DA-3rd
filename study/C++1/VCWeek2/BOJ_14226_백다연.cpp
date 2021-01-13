#include <iostream>
#include <queue>
#include <vector>
#include <math.h>
#include <string.h>
#include <string>
#include <utility>
#include <algorithm>

using namespace std;
// 14226

int arr[1001][1001];

int main()
{

  int s;
  cin >> s;

  memset(arr, -1, sizeof(arr));
  queue<pair<int,int>>q; // �̸�Ƽ��, Ŭ������
  q.push(make_pair(1,0));

  arr[1][0] = 0; //�� ó�� �Ѱ�, Ŭ������0�� �ð�

  while(!q.empty())
  {
    int emo = q.front().first;
    int clip = q.front().second;
    q.pop();

    if(arr[emo][emo] == -1) //1�ܰ�, s���� �̸�Ƽ�ܰ� Ŭ������� s Ž��
    {
      q.push(make_pair(emo,emo));
      arr[emo][emo] = arr[emo][clip] + 1; //��������
    }
    if(emo+clip <=s && arr[emo+clip][clip] == -1) //�ٿ��ֱ�
    {
        q.push(make_pair(emo+clip,clip));
        arr[emo+clip][clip] = arr[emo][clip] + 1;
    }

    if(emo-1 >=0 && arr[emo-1][clip] == -1) //����
    {
      q.push(make_pair(emo-1,clip));
      arr[emo-1][clip] = arr[emo][clip] + 1; 
    }

  
  }

  int value = -1;

  for (int i = 0; i <= s; i++)
  {
    if (arr[s][i] != -1)
    {
      if (value == -1 || value > arr[s][i])
        value = arr[s][i];
    }
  }

  cout << value << endl;

    return 0;
}