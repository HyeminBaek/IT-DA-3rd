import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CrazyR {
	static int op_X[] = {1,-1,0,0};//�������� x��ǥ
	static int op_Y[] = {0,0,-1,1};//�������� y��ǥ
	static int n;
	static double pro = 1;
	static double pro_l[] = new double[4];//�������� ������ Ȯ�� �� ���� �Ǿ� �ִ� ����
	static double p_sum;
	static int d = 0;
	static int visited[][];//�� ��ǥ�� �湮�ߴ� �� �˷��ִ� �迭
	public static void main(String[] args) throws NumberFormatException, IOException {
		//���� ����� 2������ ������ �� �ְ���
		//1. �ܼ� ����� Ȯ���� �ٷ� ���ϴ� �� 2. �ܼ� ���� ���� ��θ� �湮�ϴ� Ȯ���� ���ؼ� 1���� ���� ��
		//2���� ���� ����� ����� ��.(��������� ����.)
		//1���� ���� ����� ���� �ܼ�. �ߺ��Ǵ� ������ ��ġ���ʰ� �� ������ �����ϴ� Ȯ���� ���ϸ� ��.
		//���� DFS�� Ǯ���Դϴ�..
		//�Ҿ���� 2�ð��� ã�Ƽ�.. �׷��� �ѵ��մϴ�..
		//ó���� Ʋ������ : Ȯ���� 0�� ���� ������� �ʾ���. �̷��� Ǯ�� �־��� ��쿡�� �뷫 600���� ���Ƽ� �ð��ʰ� �Ȱɸ�.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		visited = new int[n * 2 + 1][n * 2 + 1];
		for(int i = 0; i < 4; i++) {
			pro_l[i] = (Double.parseDouble(st.nextToken()) / 100);
		}
		visited[n][n] = 1;
		DFS(n, n, d, -1);
		System.out.println(p_sum);
	}
	
	static int DFS(int x, int y, int d, int k) {//�� ������ �μ� k�� �� �˰��򿡼� �ð� ���࿡ �̿�.
		int next_x, next_y;
		if(d == n) {
			p_sum = p_sum + pro;
		}
		else {
			if(d == 0) {//ó�� �Լ� ������ ���� �ƴ� ���� �����ؼ� �ð��� �� �� ������׽��ϴ�.
				for (int i = 0; i < 4; i++) {
					next_x = op_X[i] + x;//�������� ��ǥ ���ϱ� 
					next_y = op_Y[i] + y;//�������� ��ǥ ���ϱ�
					if(visited[next_x][next_y] == 0 && pro_l[i] != 0) {//���� �� �湮 �����鼭 �� �������� ���� Ȯ���� 0�� �ƴ� ���� Ž��
						visited[next_x][next_y] = 1;
						pro = pro * pro_l[i];
						if(i % 2 == 0) {//�ð� ������ ���� ���θ�
							DFS(next_x, next_y, d+1, i+1);
						}
						else {//�ð� ������ ���� ���θ�2..
							DFS(next_x, next_y, d+1, i-1);
						}
						visited[next_x][next_y] = 0;
						pro = pro / pro_l[i];
					}
				}
			}
			else {
				int a = k + 1;
				int cnt = 0;
				while(cnt < 3) {//�ð� ������ ���� ���θ�3..
					if(a > 3)
						a = a % 4; 
					next_x = op_X[a] + x; 
					next_y = op_Y[a] + y;
					if(visited[next_x][next_y] == 0 && pro_l[a] != 0) {
						visited[next_x][next_y] = 1;
						pro = pro * pro_l[a];
						if(a % 2 == 0) {
							DFS(next_x, next_y, d+1, a+1);
						}
						else {
							DFS(next_x, next_y, d+1, a-1);
						}
						visited[next_x][next_y] = 0;
						pro = pro / pro_l[a];
					}
					a = a + 1;
					cnt = cnt + 1;
				}
			}
		}
		return 0;
	}

}
