import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class ABC {
	//��ǥ �� �����ϴ� Ŭ����
	int a, b, c;
	public ABC (int x, int y, int z) {
		a = x;
		b = y;
		c = z;
	}
}

public class WaterBottle {
	static int visited[][][];
	static ArrayList<ABC> list = new ArrayList<>();
	static ArrayList<Integer> sol = new ArrayList<>();
	static int A, B, C;
	
	public static void main(String[] args) throws IOException {
		// � ���뿡 ����ִ� ���� �ٸ� �������� ��� ���� �� �ִ�. 
		// �� ������ ��ų�, �ٸ� �� ������ ���� �� ������ ���� ���� �� �ִ�.
		// c�� �׻� �������� �־���.
		// bfs..?
		// A->B A->C B->A B->C C->A C->B ��� ����
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		visited = new int[A+1][B+1][C+1];
		BFS();
		
		Collections.sort(sol);
		for(int i : sol) {
			System.out.print(i + " ");
		}
	}
	
	static void BFS() {
		int a, b, c;
		
		list.add(new ABC(0,0,C));
		
		while(!list.isEmpty()) {
			a = list.get(0).a;
			b = list.get(0).b;
			c = list.get(0).c;

			list.remove(0);
			if(visited[a][b][c] == 1)
				continue;
			visited[a][b][c] = 1;
			if(a == 0) {
				sol.add(c);
			}
			
			if(a + c >= A) {//c -> a
				list.add(new ABC(A, b, c - (A - a)));
			}
			else {
				list.add(new ABC(a + c, b, 0));
			}
			
			if(c + b >= B){//c -> b
				list.add(new ABC(a, B, c - (B - b)));
			}
			else {
				list.add(new ABC(a, c + b, 0));
			}
			
			if(a + b >= A){//b -> a
				list.add(new ABC(A, b - (A - a), c));
			}
			else {
				list.add(new ABC(a + b, 0, c));
			}
			
			if(c + b >= C){//b -> c
				list.add(new ABC(a, b - (C - c), C));
			}
			else {
				list.add(new ABC(a, 0, c + b));
			}
			
			if(a + c >= C){//a -> c
				list.add(new ABC(a - (C - c), b, C));
			}
			else {
				list.add(new ABC(0, b, a + c));
			}
			
			if(a + b >= B){//a -> b
				list.add(new ABC(a - (B - b), B, c));
			}
			else {
				list.add(new ABC(0, a + b, c));
			}
		}
	}


}
