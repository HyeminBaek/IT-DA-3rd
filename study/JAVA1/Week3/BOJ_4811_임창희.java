package q4811;

import java.util.Scanner;

public class Q4811 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=-1;
		int t =0;
//		t�� �ִ� 1000���� �׽�Ʈ ���̽��� �̷������ while ���ǹ��� t<1000�� �ߴ�.
		while(t<1000) {
			N=sc.nextInt();
			if(N==0) break;		//	N���� 0�� ������ �Է��� �����Ѵ�.
			
			long[][] map = new long[2*N][2*N+1];
			System.out.println(split(N,0,map));
			t++;
		}
		
	}
//	full�� �˾� �Ѱ� half�� �˾� �ݰ��̴�.
	static long split(int full, int half,long[][] map) {
//		����� ���� 1���� �Ǵ� ������ full�� �Ѱ��� �� half�� 0�̰ų� full�� 0�϶� �̴�.
		if(half == 0 && full==1 || full==0) {
			map[full][half]=1;
			return 1;
		}else if(half<0) {
			return 0;
		}
		if(map[full][half]==0) {
			map[full][half] = split(full-1,half+1,map)+split(full,half-1,map);
		}
		return map[full][half];
	}
}
