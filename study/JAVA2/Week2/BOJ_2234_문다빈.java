import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

class XYC {
	int x;//��ǥ
	int y;//��ǥ
	int chance;//������ ����
	
	public XYC(int a, int b, int c){
		x = a;
		y = b;
		chance = c;
	}
}


public class Castle {
	static int op_Y[] = {1,-1,0,0};//�������� x��ǥ
	static int op_X[] = {0,0,1,-1};//�������� y��ǥ
	static int m, n;
	static int area;
	static int b_area;
	static int cnt = 0;
	static int wide_m = 0;
	static int b_wide;
	static int comp = 0;
	static int map[][];
	static int visited[][][];
	static ArrayList<XYC> list = new ArrayList<>();
	static ArrayList<Integer> b_list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		// BFS����
		// ���� �ǰ��� ������ ������ �����ϰ� 3���� �迭�� �Ἥ �� ���� ��ȸ�� ǥ�����ִ� �� ���� �� ����
		// ���ʿ� ���� ���� ���� 1��, ���ʿ� ���� ���� ���� 2��, 
		// ���ʿ� ���� ���� ���� 4��, ���ʿ� ���� ���� ���� 8�� ���� ���� �־�����.
		// �� ������ �� : 1 �Ͽ��� �� : 2 ������ �� : 4 ������ �� : 8
		// �� �� �� : 3 �� �� �� : 5 �� �� �� : 9 �� �� �� : 6 �� �� �� : 10
		// �� �� �� : 12 ���ϵ� �� : 7 ���ϳ� �� : 11 ������ �� : 13 �ϵ��� �� : 14
		// �������� �� : 15
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[m][n];
		visited = new int[2][m][n];
		
		
		for(int i = 0; i < m; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st1.nextToken());
			}
		}
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(visited[1][i][j] == 0) {
					b_list.clear();
					area = 1;
					comp = 0;
					bfs(i,j);
					if(visited[0][i][j] == 1)
						b_list.remove(b_list.indexOf(area));
					Collections.sort(b_list);
					wide_m = Math.max(wide_m, area);
					if(!b_list.isEmpty())
						b_wide = Math.max(b_wide, area + b_list.get(b_list.size()-1));
					cnt++;
					for(int k = 0; k < m; k++) {
						Arrays.fill(visited[0][k], 0);
					}
				}
			}
		}
		System.out.println(cnt);
		System.out.println(wide_m);
		System.out.println(b_wide);
	}

	static void bfs(int x, int y){
		int next_x, next_y;
		list.add(new XYC(x, y, 1));
		visited[1][x][y] = 1;
		
		while(!list.isEmpty()) {
			next_x = list.get(0).x;
			next_y = list.get(0).y;
			//��
			if(map[next_x][next_y] != 4 && map[next_x][next_y] != 5 && map[next_x][next_y] != 6 && map[next_x][next_y] != 12 && map[next_x][next_y] != 7 && map[next_x][next_y] != 13 && map[next_x][next_y] != 14 && map[next_x][next_y] != 15) {
				next_x = next_x + op_X[0];
				next_y = next_y + op_Y[0];
				if(next_x >= 0 && next_x < m && next_y >= 0 && next_y < n) {
					if(visited[list.get(0).chance][next_x][next_y] != 1) {
						visited[list.get(0).chance][next_x][next_y] = 1;
						area++;
						list.add(new XYC(next_x, next_y, list.get(0).chance));
					}
				}
			}
			else {
				next_x = next_x + op_X[0];
				next_y = next_y + op_Y[0];
				if(next_x >= 0 && next_x < m && next_y >= 0 && next_y < n) {
					if(visited[1][next_x][next_y] != 1 && visited[0][next_x][next_y] == 0 && list.get(0).chance > 0) {
						b_area = 0;
						dfs(next_x, next_y);
						b_list.add(b_area);//��ǥ�� ���� �����ϴ� �� ���غ�..
					}
				}
			}
			//��
			next_x = list.get(0).x;
			next_y = list.get(0).y;
			if(map[next_x][next_y] != 1 && map[next_x][next_y] != 3 && map[next_x][next_y] != 5 && map[next_x][next_y] != 7 && map[next_x][next_y] != 9 && map[next_x][next_y] != 13 && map[next_x][next_y] != 11 && map[next_x][next_y] != 15) {
				next_x = next_x + op_X[1];
				next_y = next_y + op_Y[1];
				if(next_x >= 0 && next_x < m && next_y >= 0 && next_y < n) {
					if(visited[list.get(0).chance][next_x][next_y] != 1) {
						visited[list.get(0).chance][next_x][next_y] = 1;
						area++;
						list.add(new XYC(next_x, next_y, list.get(0).chance));
					}
				}
			}
			else {
				next_x = next_x + op_X[1];
				next_y = next_y + op_Y[1];
				if(next_x >= 0 && next_x < m && next_y >= 0 && next_y < n) {
					if(visited[1][next_x][next_y] != 1 && visited[0][next_x][next_y] == 0 && list.get(0).chance > 0) {
						b_area = 0;
						dfs(next_x, next_y);
						b_list.add(b_area);
					}
				}
			}
			//��
			next_x = list.get(0).x;
			next_y = list.get(0).y;
			if(map[next_x][next_y] != 8 && map[next_x][next_y] != 9 && map[next_x][next_y] != 10 && map[next_x][next_y] != 11 && map[next_x][next_y] != 12 && map[next_x][next_y] != 13 && map[next_x][next_y] != 14 && map[next_x][next_y] != 15) {
				next_x = next_x + op_X[2];
				next_y = next_y + op_Y[2];
				if(next_x >= 0 && next_x < m && next_y >= 0 && next_y < n) {
					if(visited[list.get(0).chance][next_x][next_y] != 1) {
						visited[list.get(0).chance][next_x][next_y] = 1;
						list.add(new XYC(next_x, next_y, list.get(0).chance));
						area++;
					}
				}
			}
			else {
				next_x = next_x + op_X[2];
				next_y = next_y + op_Y[2];
				if(next_x >= 0 && next_x < m && next_y >= 0 && next_y < n) {
					if(visited[1][next_x][next_y] != 1 && visited[0][next_x][next_y] == 0 && list.get(0).chance > 0) {
						b_area = 0;
						dfs(next_x, next_y);
						b_list.add(b_area);
					}
				}
			}
			//��
			next_x = list.get(0).x;
			next_y = list.get(0).y;
			if(map[next_x][next_y] != 2 && map[next_x][next_y] != 3 && map[next_x][next_y] != 6 && map[next_x][next_y] != 10 && map[next_x][next_y] != 7 && map[next_x][next_y] != 11 && map[next_x][next_y] != 14 && map[next_x][next_y] != 15) {
				next_x = next_x + op_X[3];
				next_y = next_y + op_Y[3];
				if(next_x >= 0 && next_x < m && next_y >= 0 && next_y < n) {
					if(visited[list.get(0).chance][next_x][next_y] != 1) {
						visited[list.get(0).chance][next_x][next_y] = 1;
						list.add(new XYC(next_x, next_y, list.get(0).chance));
						area++;
					}
				}
			}
			else {
				next_x = next_x + op_X[3];
				next_y = next_y + op_Y[3];
				if(next_x >= 0 && next_x < m && next_y >= 0 && next_y < n) {
					if(visited[1][next_x][next_y] != 1 && visited[0][next_x][next_y] == 0 && list.get(0).chance > 0) {
						b_area = 0;
						dfs(next_x, next_y);
						b_list.add(b_area);
					}
				}
			}
			list.remove(0);
		}
	}
	
	static void dfs(int x, int y){
		int next_x, next_y;
		next_x = x;
		next_y = y;
		visited[0][next_x][next_y] = 1;
		b_area++;
		for (int i = 0; i < 4; i++) {
			next_x = x;
			next_y = y;
			if(i == 0) {
				if(map[next_x][next_y] != 4 && map[next_x][next_y] != 5 && map[next_x][next_y] != 6 && map[next_x][next_y] != 12 && map[next_x][next_y] != 7 && map[next_x][next_y] != 13 && map[next_x][next_y] != 14 && map[next_x][next_y] != 15) {
					next_x = op_X[i] + x; next_y = op_Y[i] + y;
					if(next_x >= 0 && next_x < m && next_y >= 0 && next_y < n) {
						if(visited[0][next_x][next_y] != 1) {
							dfs(next_x, next_y);
						}
					}
				}
			}
			else if(i == 1) {
				if(map[next_x][next_y] != 1 && map[next_x][next_y] != 3 && map[next_x][next_y] != 5 && map[next_x][next_y] != 7 && map[next_x][next_y] != 9 && map[next_x][next_y] != 13 && map[next_x][next_y] != 11 && map[next_x][next_y] != 15) {
					next_x = op_X[i] + x; next_y = op_Y[i] + y;
					if(next_x >= 0 && next_x < m && next_y >= 0 && next_y < n) {
						if(visited[0][next_x][next_y] != 1) {
							dfs(next_x, next_y);
						}
					}
				}
			}
			else if(i == 2) {
				if(map[next_x][next_y] != 8 && map[next_x][next_y] != 9 && map[next_x][next_y] != 10 && map[next_x][next_y] != 11 && map[next_x][next_y] != 12 && map[next_x][next_y] != 13 && map[next_x][next_y] != 14 && map[next_x][next_y] != 15) {
					next_x = op_X[i] + x; next_y = op_Y[i] + y;
					if(next_x >= 0 && next_x < m && next_y >= 0 && next_y < n) {
						if(visited[0][next_x][next_y] != 1) {
							dfs(next_x, next_y);
						}
					}
				}
			}
			else if(i == 3) {
				if(map[next_x][next_y] != 2 && map[next_x][next_y] != 3 && map[next_x][next_y] != 6 && map[next_x][next_y] != 10 && map[next_x][next_y] != 7 && map[next_x][next_y] != 11 && map[next_x][next_y] != 14 && map[next_x][next_y] != 15) {
					next_x = op_X[i] + x; next_y = op_Y[i] + y;
					if(next_x >= 0 && next_x < m && next_y >= 0 && next_y < n) {
						if(visited[0][next_x][next_y] != 1) {
							dfs(next_x, next_y);
						}
					}
				}
			}
			
		}
	}
}
