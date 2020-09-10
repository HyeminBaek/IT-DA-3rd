//1405 ��ģ �κ�
#include <iostream>
#include <cstdio>
using namespace std;

bool visited[30][30];
int move_a[4] = { 1,-1,0,0 };
int move_b[4] = { 0,0,-1,1 };
double eachper[4]; //������ Ȯ��
int N;
int a2, b2;//�̵� ���� ��ġ
double per = 0; //�� Ȯ��
double temp = 1; //�� �����Ӹ��� ���ؼ� �� Ȯ���� �־� �� �ӽ��� ����

void dfs(int cnt, int a, int b, double p) {
	if (cnt == N) { //�Է� Ƚ����ŭ ���������� ������ �������� �����ְ�, �����Ѵ�
		if (visited[a][b] != true) {//���������� ���� ���� ���� �ȵǴϱ� 
			temp *= p;
			per += temp;
			temp /= p; //�ٷ� �� ���·� ���ư��ϱ� Ȯ���� �ٽ� �����ش�
		}
		return;
	}

	if (visited[a][b] != true) {
		for (int i = 0; i < 4; i++) {
			if (eachper[i] != 0) { //Ȯ���� 0�̸� ���� �� �������ϱ� Ȯ�� 0�϶��� ��ŵ
				temp *= p; 
				visited[a][b] = true; 
				a2 = a + move_a[i], b2 = b + move_b[i]; //�̵� �� ��ġ�� move�迭�� ���� �����ϰ�
				dfs(cnt + 1, a2, b2, eachper[i]); //cnt�� ������Ű�� ���� Ž���Ѵ�
				visited[a][b] = false; //dfs�� ���������� ���ο� ��θ� ���ؾ� �Ǵϱ� �ٽ� �湮 ���� false�� �ٲٰ�
				temp /= p; //Ȯ���� �ٽ� �����ش�
			}
		}
	}
}

int main()
{
	cin >> N;
	for (int i = 0; i < 4; i++) {
		cin >> eachper[i];
		eachper[i] /= 100.0;
	}
	dfs(0, 15, 15, 1); //��� �� 15,15�� �������� �����Ѵ�.
	printf("%.11f", per);
}