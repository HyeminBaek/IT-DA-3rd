#include<iostream>
#include<queue>
using namespace std;
int direct[4][2] = { 1,0,0,-1,-1,0,0,1 }; //�� �� �Ʒ� ����
int map[1001][1001];
int n, m, y, x, obj;
int dist[1001][1001];
bool visit[1001][1001];

queue<pair<int, int>> q;

void bfs() {
	while (!q.empty()) {
		pair<int, int> now = q.front();
		q.pop();
		int yy = now.first;
		int xx = now.second;

		for (int i = 0; i < 4; i++) {
			int ny = yy + direct[i][0];
			int nx = xx + direct[i][1];
			if (ny >= n || ny < 0 || nx >= m || nx < 0) continue; //���� ����
			if (map[ny][nx] == 0)continue; //0�� ���� �ƿ� �湮x
			if (visit[ny][nx] == 0) { //�湮���� ���� �����̸�
					dist[ny][nx] = dist[yy][xx] + 1; //���� �Ÿ��� +1
					visit[ny][nx] = true; //�湮ó��
					q.push(make_pair(ny, nx));
			}
		}
	}
}
void check() { //�湮���� ���� �� �߿� 0�� �ƴ� �� -1�� �����
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (visit[i][j] == 0 && map[i][j]!=0) {
				dist[i][j] = -1;
			}
		}
	}
}
int main(void) {
	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> obj;
			if (obj == 2) { //2�� ��ġ ����
				y = i; x = j;
			}
			map[i][j] = obj;
		}
	}
	q.push(make_pair(y,x));

	visit[y][x] = 1;
	bfs();
	check();
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cout << dist[i][j] << " ";
		}
		cout << endl;
	}
}