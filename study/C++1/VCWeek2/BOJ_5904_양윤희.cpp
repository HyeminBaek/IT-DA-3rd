#include <iostream>
using namespace std;
int dp[31];
int x;
int moo(int n) {
	if (n == 1) return 'm';
	if (n == 2 || n == 3) return 'o';

	int i = 0; //s �ε���
	while (dp[i] < n) i++;
	if (dp[i] == n) return 'o'; 
	if (n - dp[i - 1] == 1) return 'm'; // ���� ĭ 0�� k+2�� �����ϴ� m
	if (n - dp[i - 1] <= i + 3) return 'o'; //  moo.... ���� o �ش��ϴ� ĭ

	return moo((n - dp[i - 1] - (i + 3)));
}
int main(void) {
	dp[0] = 3;
	for (int i = 1; i < 30; i++) {
		dp[i] = (dp[i - 1] * 2) + (i + 3); //s(i)�� ���� ����
	}

	cin >> x;
	cout<<moo(x);
	
}