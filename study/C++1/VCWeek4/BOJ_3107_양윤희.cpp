#include <iostream>
#include <algorithm>
#include <cstring>
using namespace std;
string ans[8];
string ipv6;
int cnt;
int main() {
    cin >> ipv6; 
    ipv6 += ":";
    int idx=0;
    for (int i = 0; i < ipv6.length(); i++) {
        if (i>0 &&ipv6[i] ==':'&& ipv6[i - 1]==':') {
            for (int j = i+1;ipv6[j]!='\0'; j++) { //�ڿ� �󸶸� ����� 0000�� ä���� ���� : ����
                if (ipv6[j] == ':') {
                    cnt++;
                }
            }
            int temp = idx;
            if (temp == 0)ans[0] = "0000";//::1 �տ��� �� ::�� ���
            for (int k = temp; k < 8 - cnt; k++) { //0000 ä��� 
                ans[k] = "0000";
                idx++;
            }
            continue;
        }
        if (ipv6[i] == ':') {
            while (ans[idx].length() != 4) {//�տ� 0 ä���
                ans[idx].insert(0, "0");
            }
            idx++;
        }
        
        else { 
            ans[idx] += ipv6[i]; //16���� �״�� �߰�
        }
    }
    if (ans[7] == "")ans[7] = "0000"; //1:: �ڿ��� �� ::�� ���
    for (int i = 0; i < 8;i++) {
        if (i == 7)cout << ans[i];
        else{
        cout << ans[i] << ":";
        }
    }
}