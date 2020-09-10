import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Wedding {
	static int visited[];
	static ArrayList<ArrayList<Integer>> F_list = new ArrayList<>();
	static int cnt = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// ����Ʈ�� ���� �� ģ���� ��� �湮�ϴ� �������� Ž�� ����.
		// ģ���� ģ���� ģ�����ʹ� �ʴ� ����.
		// DFS�� ����Ͽ� ������ Ǯ �̴ϴ�.
		// �޸𸮸� �� �����ϰ� ���� ���� ���� ��̸���Ʈ�� ����ϴ�.
		// ��� �������� ���� ���� �ʾ� 2���� �迭�� �ᵵ ������� �����Դϴ�
		// ������ �迭�ᵵ �ִ� byte : 4 * 500 * 500 byte = �뷫 1mb(�Ƹ���..)�� �޸� �������ص� ��.
		// ������ �迭�� ���� �ڵ�¥��� �������� �̿���� �ʴ� ������� �ʹ� ���� ���ܼ� �̷��� Ǯ�����ϴ�.
		int n;
		int m;
		int a, b;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		visited = new int[n+1]; 
		
		m = Integer.parseInt(br.readLine());
		
		for(int i = 0; i <= n; i++) {
			F_list.add(new ArrayList<Integer>());
		}
		
		for(int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			F_list.get(a).add(b);//ģ�� ����Ʈ �ۼ� ����
			F_list.get(b).add(a);//ģ�� ����Ʈ �ۼ� ����
		}
		
		visited[1] = 1;
		DFS(1, 0);
		System.out.println(cnt);
	}
	
	static int DFS(int n, int d) {
		if(d == 2) {
			return 0;
		}			
		else {
			for(int i : F_list.get(n)) {
				if(visited[i] == 0) {//üũ �� �Ǿ��� ģ���鸸 �߰����ִ� ������ ��� Ž��
					visited[i] = 1;
					cnt++;
				}
				DFS(i, d+1);
			}
		}
		return 0;
	}

}
