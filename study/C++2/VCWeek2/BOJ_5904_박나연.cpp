#include<iostream>
using namespace std;

long long N;


int main() {

	cin >> N;
	
	int s = 3; //S(0)
	int k = 4; //S(1)�� ��� ���� ����


	while (true) {
		s = 2 * s + k;
		if (N > s)
			break;
		k++;
	}

	

}