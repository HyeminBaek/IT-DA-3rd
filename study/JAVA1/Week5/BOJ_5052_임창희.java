package q5052;

import java.util.Arrays;
import java.util.Scanner;


public class PhoneNumber_list {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		t�� �׽�Ʈ ���̽� ����
		int t = sc.nextInt();
		
		for(int i=0;i<t;i++) {
			int n=sc.nextInt();	//n�� ��ȭ��ȣ�� ��
			String[] tel = new String[n];
			String result = "YES";
			for(int j=0;j<n;j++) {
				tel[j] = sc.next();
			}
//			������������ ����
			Arrays.sort(tel);
			
			for(int k=0;k<n-1;k++) {
				if(tel[k+1].startsWith(tel[k])) {
					result ="NO";
					break;
				}
			}
			
			System.out.println(result);
		}
		
	}	
}
