import java.util.Scanner;

public class BOJ_9655_��â�� {
	public static void main(String[] args) {
		//dp[i]=dp[i-1]+1, dp[i-3]+1�̴� ���� Ȧ���� �׻� sk ¦���� cy
		Scanner sc=new Scanner(System.in);
		int n= sc.nextInt();
		if(n%2==0) System.out.println("CY");
		else System.out.println("SK");
	}
}
