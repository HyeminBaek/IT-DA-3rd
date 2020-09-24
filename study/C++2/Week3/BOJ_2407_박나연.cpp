#include<iostream>
#include<algorithm>
using namespace std;

//���� : nCr = n-1Cr-1 + n-1Cr
//ū ���� ���� ���� string ���� �ٲ� ���� ���

//setting
string com[101][101];

//ū �� ���(��α� ����) -- �ܿ�������..
string add(string n, string m) {
	string result;
	long long int s;
	while (!n.empty() || !m.empty() || s) {
		if (!n.empty())
		{
			s = s + n.back() - '0';
			n.pop_back();
		}
		if (!m.empty())
		{
			s = s + m.back() - '0';
			m.pop_back();
		}

		result.push_back((s % 10) + '0');
		s = s / 10;

	}
	reverse(result.begin(), result.end());
	return result;
}

string dp(int n, int r) {
	if (n == r || r == 0)
		return "1";
	/*if (dp(n,r) == "")
		return dp(n,r);*/
	return com[n][r] = add(dp(n - 1,r - 1), dp(n - 1,r));
}

int main() {
	int N, M;
	cin >> N >> M;
	cout << dp(N, M);
}

//�ð� �ʰ�, �޸��ʰ�