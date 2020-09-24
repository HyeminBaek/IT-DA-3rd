#include<iostream>
#include<algorithm>
#include<string>
using namespace std;
string arr[101][101];
string stringadd(string num1, string num2)
{
	long long sum = 0;
	string result;
    while (!num1.empty() || !num2.empty() || sum) {
        if (!num1.empty()) {
            sum += num1.back() - '0';
            num1.pop_back();
        }
        if (!num2.empty()) {
            sum += num2.back() - '0';
            num2.pop_back();
        }
        result.push_back((sum % 10) + '0');
        sum /= 10;
    }
    reverse(result.begin(), result.end());
    return result;
}
int main() {
	int n, m;
	cin >> n >> m;
	for (int i = 0; i <= n; i++)
	{
		arr[i][0] = arr[i][i] = "1";
		for (int j = 1; j <= n-1; j++)
		{
			arr[i][j] = stringadd(arr[i - 1][j - 1], arr[i - 1][j]);
		}
	}
    cout << arr[n][m];
}