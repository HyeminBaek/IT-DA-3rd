package q5557;

import java.util.Scanner;

public class Q5557 {
	static int N;
	static int[] arr;
	static long[][] result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i]= sc.nextInt();
		}
//		result�� ù��° �ε����� �迭�� ���° ��ұ��� ����ߴ����� ��Ÿ����.
//		�ι�° �ε����� ù��° �ε������� ������� �� ����� ���� ��Ÿ����.
//		���ʺ��� ����� �� �߰��� ������ ���� 0���� 20�����̹Ƿ� 21�� �ߴ�.
		result = new long[N-1][21];
		result[0][arr[0]]=1;
		
//		
		for(int i=1;i<N-1;i++) {
			for(int j=0;j<21;j++) {
//				plus�� ����° ������� ���� �� �ִ� ������ arr[]�� ���� ��Ҹ� ���� ���̴�.
//				minus�� ���� ������� �� ���̴�.
//				result�� ������ ���࿡�� ���� �� �ִ� j�� ���� Ƚ���̴�.
				if(result[i-1][j] !=0) {
					int plus = j+arr[i];
					int minus = j-arr[i];					
					if(plus<=20) {
						result[i][plus] += result[i-1][j];							
					}
					if(minus >=0) {
						result[i][minus] +=result[i-1][j];							
					}
				}
				
			}
		}
		
		System.out.println(result[N-2][arr[N-1]]);
	}
	
}
