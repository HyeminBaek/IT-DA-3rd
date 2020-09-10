import java.util.*;

public class Main {
	
	static int check[][] = new int[30][30];
	static double Percant [] = new double [4]; // �������� Ȯ�� 
	static int move_x[] = {1, -1, 0, 0}; // ��������
	static int move_y[] = {0, 0, -1, 1}; // ��������
	static int N;
	static double answer;

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		N = input.nextInt();
		
		for(int p = 0; p < Percant.length; p++) {
			int perc = input.nextInt();
			Percant[p] = (perc * 0.01);
		}
		
		check[15][15] = 1; // ��� �κп��� ����Ѵٰ� ����.
		
		dfs(15, 15, 1.0, 0);
		
		/**
		 * Ȯ�� ����ϴ� �κ��� �� ���ذ� ���� �ʾҴ�. 
		 * ���� �� �κ��� ���۸��� �ؼ� ���� ���ظ� ���� ���Դ�.
		 */
		
		System.out.println(answer);
	}

	public static void dfs(int x, int y, double percant, int n) {
		
		if(n == N) {
			answer = answer + percant;
			return;
		}
		
		for(int i = 0; i < move_x.length; i++) {
			
			if(Percant[i] == 0) // �� Ȯ���� �ƾ� ������ 
				continue;
			
			int go_x = x + move_x[i];
			int go_y = y + move_y[i];
			
			if(check[go_x][go_y] != 1) { // �̰Ÿ� while�̶�� �ߴٴ�..
				
				check[go_x][go_y] = 1; // ���� ǥ��
				dfs(go_x, go_y, percant*Percant[i], n+1);
				check[go_x][go_y] = 0; // ���� �ٽ� Ǯ���ֱ�.
			}
		}
	}

}
