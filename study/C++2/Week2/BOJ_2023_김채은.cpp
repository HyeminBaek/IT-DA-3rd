#include<iostream>
#include<math.h>
#include<queue>
#include<algorithm>

using namespace std;

//���ʺ��� DFS�� �Ҽ��Ǵ�->level����
//�Ҽ� 2�� �����ϰ� ��� Ȧ����

int N;
vector<int> result;

bool isPrime(int n) {
	if (n <= 1)
		return false;
	for (int i = 2; i <= sqrt(n); i++) {
		if ((n % i) == 0) {
			return false;
		}
	}
	return true;
}

void dfs(int num, int level) {
	if(level == N){
		result.push_back(num);
		return;
	}

	for (int i = 1; i < 10; i += 2) {
		if (isPrime(num * 10 + i))
			dfs(num * 10 + i, level + 1);
	}
}

void solution(){
	dfs(2,1);
	dfs(3,1);
	dfs(5,1);
	dfs(7,1);

	sort(result.begin(), result.end());
	for(int i=0; i < result.size(); i++){
		cout << result[i] << endl;
	}
}

int main() {
	cin >> N;
	solution();
	return 0;
}


