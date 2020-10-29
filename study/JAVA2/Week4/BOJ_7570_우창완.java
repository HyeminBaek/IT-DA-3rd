import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_7570_��â�� {
//�� ����� ������ Lis �� ã�� �Ͱ�����(���� �� �����ϴ� ���Ӽ��� ã��)
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] temp=br.readLine().split(" ");
		int n=Integer.parseInt(temp[0]);
		temp=br.readLine().split(" ");
		int[]dp=new int[n+1];
		//n=1000000�̹Ƿ� n^2���δ� ��Ǯ���� ���� �Է¹��ڸ��� Ǯ�� �ְԲ� �ڵ� ����
		for(int i=0; i<n; i++)	{
			int lis=Integer.parseInt(temp[i]);
			dp[lis]=dp[lis-1]+1;
		}
		Arrays.sort(dp);
		System.out.println(n-dp[n]);
	}
}
