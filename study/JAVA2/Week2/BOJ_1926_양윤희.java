package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main4 {
	static int dx[] = {-1,1,0,0}; //x��ǥ
	static int dy[] = {0,0,-1,1}; //y��ǥ
	
	
	static int map[][];
	static int visited[][];
	static int n,m, cnt, mark=1;
	static ArrayList<Integer> res = new ArrayList<Integer>();
	static Queue<pos> q = new LinkedList<>();

	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
	
	
		map = new int[n+1][m+1];
		visited = new int[n+1][m+1];
		for(int i=0; i<n; i++) {
			String[] tmp = br.readLine().split(" ");
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(tmp[j]);
				}
			}
		bfs();
		System.out.println(mark - 1);
		System.out.println(Collections.max(res)); //�ִ� ��������
	}
	
	public static void bfs() {

		for(int i =0 ; i< m; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j]==1) {
					cnt = 1; //�׸� ���� �׸� ���̸� count�ϱ� ���� ����
					mark++; //�׸� ��ȣ
					q.add(new pos(i,j));
					map[i][j] = mark;
					
					while(!q.isEmpty()) {
						
						pos now  = q.poll();
						
						for(int d = 0; d<4; d++) {
							int xx = now.x + dx[d]; //�����¿� Ž��
							int yy = now.y + dy[d];
							
							//map�� ������ ����� pass
							if(xx<0 || yy<0 || xx>=m || yy>=n ) continue;
							//�׸��� ���ų�, �ٸ� �׸����� ���������� pass
							if(map[xx][yy] !=1 )continue;
							
							//�׸����� ���Խ�Ű��
							map[xx][yy] = mark; 
							cnt++;
							q.add(new pos(xx,yy)); //�� ��ġ���� �� �����¿� Ž��
						}
					}
					res.add(cnt); //
				}
			}
	}		
}
	
	
	static public class pos{ //���� �湮 �ϴ� ���� ��ǥ�� �����ϱ� ���� ������
		int x;
		int y;
		public pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
