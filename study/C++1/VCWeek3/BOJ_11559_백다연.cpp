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
//11559
char arr[12][6];
bool check[12][6];
int num = 1;
int dx[] = {1, -1, 0, 0};
int dy[] = {0, 0, 1, -1};

void falling()
{ 
    for (int j = 0; j < 6; j++)
    {
        while (true)
        {
            bool fall = false;
            for (int i = 11; i >= 1; i--)
            {
                if (arr[i][j] == '.' && arr[i - 1][j] != '.') //���� �ѿ䰡 ����
                {
                    arr[i][j] = arr[i - 1][j];
                    arr[i - 1][j] = '.'; //�ѿ� �����ֱ�
                    fall = true;
                }
            }
            if (!fall)
                break; // ������
        }
    }
}

void remove()
{
    for (int i = 0; i < 12; i++)
    {
        for (int j = 0; j < 6; j++)
        {
            if (check[i][j])
            {
                arr[i][j] = '.'; //�ѿ� ��ĭ���� �����
            }
        }
    }
}

void dfs(int x, int y, char before)
{
    check[x][y] = true;

    for (int i = 0; i < 4; i++)
    {
        int nx = x + dx[i];
        int ny = y + dy[i];
        if (nx >= 0 && ny >= 0 && nx < 12 && ny < 6)
        {
            if (!check[nx][ny] && before == arr[nx][ny]) //���� �������̰� �湮 x
            {
                num++;
                dfs(nx, ny, arr[x][y]);
            }
        }
    }
}

int main()
{
  for(int i = 0; i < 12; i++)
    for(int j = 0; j < 6; j++)
        cin >> arr[i][j];

  int time = 0;

  while(true)
  {
      bool flag = false;
      for (int i = 11; i >= 0; i--) {
			for (int j = 0; j < 6; j++) {
                num = 1;
                memset(check, false, sizeof(check)); 
				if (arr[i][j] != '.') { // �ѿ� �ִ� ���
					dfs(i, j, arr[i][j]);
                    if (num >= 4)
                    {
                        flag = true;
						remove(); // 4���𿩼� �����������
                    }
                }
			}
		}
		if (!flag) break; 
		falling(); 
		time++; // 1���� ��

  }

  cout << time << endl;
}