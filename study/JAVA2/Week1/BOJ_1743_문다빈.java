import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FoodA {
	static int op_X[] = {1,-1,0,0};//�������� x��ǥ
	static int op_Y[] = {0,0,-1,1};//�������� y��ǥ
	static int map[][];//����� ���¸� ��Ÿ���� ������ �迭
	static int visited[][];//�湮�ߴ� �� ���ߴ� �� üũ�ؼ� �� ����� ������ ��!
	static int m, n;
	static int cnt;//������ ũ�� ���� ���ϴ� ����

	public static void main(String[] args) throws IOException {
		// �ڵ� ¥�� ������ DFS
		// �����(��ó�� �ִ� �����⸦ �� �湮) �Ǵ� ���� �� ã�� ������� �ڵ带 ¬�ô�.
		// �� ����� ã���� �� ���� ����� ã�Ƴ����� ������ �ڵ��ϸ� �˴ϴ�.
		// �ð������� 2�ʷ� �˳��մϴ�.
		// list�� ����� ũ����� ��� �������� ������ ���� ���� ū ũ��(�� ��)�� ����մϴ�.
		int k;
		int r, c;
		ArrayList<Integer> list = new ArrayList<>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n+1][m+1];
		visited = new int[n+1][m+1];
		
		k = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < k; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st1.nextToken());
			c = Integer.parseInt(st1.nextToken());
			map[r][c] = 1;
		}
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				if(map[i][j] == 1 && visited[i][j] == 0) {
					cnt = 1;
					DFS(i,j);
					list.add(cnt);
				}
			}
		}
		Collections.sort(list);
		System.out.println(list.get(list.size()-1));
	}
	
	static void DFS(int y, int x) {
		int next_x, next_y;
		visited[y][x] = 1;
		for(int i = 0; i < 4 ; i++) {
			next_y = y + op_Y[i];
			next_x = x + op_X[i];
			if(next_x > 0 && next_x <= m && next_y > 0 && next_y <= n)
				if (map[next_y][next_x] == 1 && visited[next_y][next_x] == 0) {
					cnt++;
					DFS(next_y, next_x);
				}
		}
	}

}
