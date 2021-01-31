#include<iostream>
#include <vector>
#include <queue>
using namespace std;
int N; //���� ����
int M; //���� ����
int K; //�ִ� �Ÿ�
int X; //��ߵ��� ��ȣ
vector<int> map[300001]; //�Ÿ� ����
bool visit[300001];
int dist[300001];
queue<int> que;
priority_queue<int, vector<int>, greater<int>> pq; //�켱����ť ��������
int yy, xx;
void bfs() {
	while (!que.empty()) {
		int now = que.front();
		que.pop();
		for (int i = 0; i <map[now].size(); i++) {
			if (visit[map[now][i]] == 0){//�湮���� ���� ��쿡�� 
					visit[map[now][i]] = 1;
					que.push(map[now][i]);
					dist[map[now][i]] = dist[now] + 1; //ó���� �׳� while�� ��ü���ٰ� dist++�� ���༭ 4%���� Ʋ�Ⱦ���.
			}
		}
	}	
}

int main(void) {
	cin >> N >> M >> K >> X;
	for (int i = 0; i < M; i++) {
		cin >> yy >> xx;
		map[yy].push_back(xx);
	}

	que.push(X);//������ q�� �ֱ�
	visit[X] = 1; //������ �湮ó��
	bfs();

	for (int i = 0; i <= N; i++) {
		if (dist[i] == K)pq.push(i);
	}
	if (pq.empty()) {
		cout << -1;
		return 0;
	}
	else {
		while (!pq.empty()) {
			cout << pq.top() << endl;
			pq.pop();
		}

	}
	return 0;
}