#include<iostream>
using namespace std;

int y, x, direction, minx, miny, maxx, maxy;

int dy[4] = { 1,0,-1,0 }; // ��, ��, �Ʒ�, ����
int dx[4] = { 0,-1,0,1 };

string turtle;

void run() {
	y = 0; x = 0, maxx = 0, maxy = 0, minx = 0, miny = 0;
	for (int i = 0; i < turtle.length(); i++) {
		if (turtle[i] == 'L') {
			direction = (direction + 1) % 4; //�������� ���� ��ȯ
		}
		else if (turtle[i] == 'R') {
			direction = (direction + 3) % 4; //���������� ���� ��ȯ
		}
		else if (turtle[i] == 'F') {
			y += dy[direction];
			x += dx[direction];
		}
		else if (turtle[i] == 'B') {
			y -= dy[direction];
			x -= dx[direction];
		}
		maxx = max(maxx, x); //������ �����ϴ� �簢�� ����� 
		minx = min(minx, x);
		maxy = max(maxy, y);
		miny = min(miny, y);
	}
}

int main (void) {
	int T;
	cin >> T;
	while (T-- > 0) {
		cin >> turtle;
		run();
		cout << (maxx - minx) * (maxy - miny)<<endl;
	}
	return 0;
}