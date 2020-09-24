/*
 * DP(memoization), DFS
 * Whole/Half�� ������ �����ϸ鼭 Ǭ��, Ʈ�������
 * �˾� 3�� = �˾� 2���� ��쿡�� �߰�
 *
 */
#include<iostream>
using namespace std;
#define MAX 30+1

int n;
long long pill[MAX][MAX]={0, };

long long dfs(int w, int h){
	if(pill[w][h]) //�ð� ����
		return pill[w][h];
	if(w==0)
		return 1;

	pill[w][h] = dfs(w-1, h+1);
	if(h>0)
		pill[w][h] += dfs(w, h-1);

	return pill[w][h];
}

void solution(){
	while(1){
		cin >> n;
		if(n==0)	break;
		cout << dfs(n,0) << endl;
	}
}

int main(){
	solution();
	return 0;
}




