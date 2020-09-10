#include <iostream>
using namespace std;
double p[4];
int visited[30][30] = { 0, };

int num;
double ans = 0;

int dx[4] = { 0, 0, 1, -1 };
int dy[4] = { 1, -1, 0, 0 };

void dfs(int cx, int cy, int move, double per)
{
	if (move == num)		//������ Ƚ����ŭ �����̸� Ȯ�� ����ϰ� �Լ� ����
	{
		ans += per;
		return;
	}

	for (int i = 0; i < 4; i++)
	{
		int nx = cx + dx[i];
		int ny = cy + dy[i];

		if (visited[nx][ny] == 0)
		{
			visited[nx][ny] = 1;
			int nm = move + 1;
			double np;
			if (move == 0) np = p[i];
			else np = per * p[i];

			dfs(nx, ny, nm, np);

			visited[nx][ny] = 0;
		}
	}
}


int main()
{
	cin >> num;
	for (int i = 0; i < 4; i++)
	{
		cin >> p[i];
		p[i] /= 100;
	}
	visited[15][15] = 1;

	dfs(15, 15, 0, 0);

	cout.precision(9);		//������ �Ҽ��� �Ʒ� 9�ڸ����� ����ϹǷ� �Ҽ��� �Ʒ� 9�ڸ� �̻� ǥ���ؾ� ��
	cout << fixed;
	cout << ans;


}