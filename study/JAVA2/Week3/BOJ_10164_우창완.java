	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	
	public class BOJ_10164_��â�� {
		static int [][] dp= new int [20][20];
		static int point_x;
		static int point_y;
		public static void main(String[] args) throws IOException {
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			String[]temp= br.readLine().split(" ");
			int n=Integer.parseInt(temp[0]);
			int m=Integer.parseInt(temp[1]);
			int k=Integer.parseInt(temp[2]);
			dp[1][1]=1;
			int cnt=0;
			for(int i=1; i<=n;i++) {
				for(int j=1; j<=m; j++) {
					cnt++;
					if(cnt==k) {
						//point �����ϴ� ���̵�� ����
						point_x=j;
						point_y=i;
					}
					if(i==1&&j==1) continue;
					else	dp[i][j]=dp[i-1][j]+dp[i][j-1];
				}
			}
			if(k==0) System.out.println(dp[n][m]);
			//2��° ��δ� i=1 j=1 ���� �������� ���´ٴ� ���̵�� ì�ܳ��� 
			else System.out.println(dp[point_y][point_x]*dp[n-point_y+1][m-point_x+1]);
		}
	
	}
