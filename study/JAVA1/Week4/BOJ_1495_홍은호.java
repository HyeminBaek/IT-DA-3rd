import java.util.Scanner;

public class Guitar {
		
	public static int N;
	public static int S;
	public static int M;
	public static int V[];
	public static int dp[][];
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		N = s.nextInt();
		S = s.nextInt();
		M = s.nextInt();
		
		V= new int[N];
		dp= new int[N][M+1];
		
		for(int i=0; i<N; i++)
			V[i] = s.nextInt();
		
		if(S+V[0] <= M )
			dp[0][S+V[0]] = 1;
		if(S-V[0] >= 0)
			dp[0][S-V[0]] = 1;
		
		for(int i=1; i<N; i++)
			dp(i);
		
		int flag = 0;
		
		
		for(int i=M; i>=0; i--)
		{
			if(dp[N-1][i] == 1)
			{
				flag = 1;
				System.out.println(i);
				break;
			}
		}
		
		if(flag == 0)
			System.out.println(-1);
	}
	
	public static void dp(int cur)
	{
		int prev = cur-1;
		//�뷡 ����� ���� 3�̰� ���ۺ��� 5, �ִ밪�� 10
		//10 or 0 �� dp[0][0] = 1, dp[0][10] = 1
		//�� �������� ��ȭ���ɰ��� 3�̹Ƿ� 3 or 7�� ������ ������( -3�� 13�� �ȵ�)
		for(int i=0; i<=M; i++)
		{
			if(dp[prev][i] == 1)
			{
				if(i + V[cur] <= M)
					dp[cur][i+V[cur]] = 1;
				if(i - V[cur] >= 0)
					dp[cur][i-V[cur]] = 1;
			}
		}
	}
}
