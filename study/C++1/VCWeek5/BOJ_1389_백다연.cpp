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

int N, M;

int arr[101][101];

void floyd(void)

{

    for (int k = 1; k <= N; k++)

        for (int i = 1; i <= N; i++)

            for (int j = 1; j <= N; j++)

                if (i == j)
                    continue;

                else if (arr[i][k] && arr[k][j]) //�߰������� ������ �̾����ٸ� ���

                {

                    if (arr[i][j] == 0) //i��j�� ����Ǿ����� ������, �������� ����x
                        arr[i][j] = arr[i][k] + arr[k][j];

                    else
                        arr[i][j] = min(arr[i][j], arr[i][k] + arr[k][j]); //k�� �߰���η� �������� ��
                }
}

int main()

{

    cin >> N >> M;

    for (int i = 0; i < M; i++)

    {

        int x, y;

        cin >> x >> y;

        arr[x][y] = arr[y][x] = 1;
    }

    floyd();



    int result = 987654321;

    int ans;

    for (int i = 1; i <= N; i++)

    {

        int sum = 0;

        for (int j = 1; j <= N; j++)

            sum += arr[i][j]; //���� �� ���ϱ�

        if (result > sum) 

        {

            result = sum;

            ans = i; //�ش簪 ����
        }
    }

    cout << ans << endl;

    return 0;
}
