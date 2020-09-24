package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main7 {
/*
 *  
 * 
 *
 * */
	static int N, add, sub;
	static int[] arr;
	static long[][] dp; //dp[i][j] i�� �ε��� j�� ���� �� �ִ� ����� ��
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		String[] a = br.readLine().split(" ");
		
		for(int i=0;i<N; i++) {
			arr[i] = Integer.parseInt(a[i]);
		}
		dp = new long[N][21];
		dp[0][arr[0]] = 1; //1��° �ε����� ��� �־��ֱ�
		dp();
		System.out.print(dp[N-2][arr[N-1]]); //i�� �ε��� �̰� n-1��° ���� ��������� ��� �ϹǷ� n-2 �ε��� ����

		}
	static public void dp() {
		
		for(int i=1; i<N-1; i++) {
			for(int j=0; j<=20; j++) {
				if(dp[i-1][j]>0) { //i-1��° ���� ���ؼ� d[i-1][j]>0���� ū �� ã��
					add = j+arr[i]; //+
					if(add <=20 ) { //0<��<20�� ��츸 ���ϱ�
						dp[i][add] +=dp[i-1][j];
					}
					
					sub = j-arr[i]; //-
					if(sub>=0) { //
						dp[i][sub] += dp[i-1][j];
					}
				}
			}
		}
	}
}
