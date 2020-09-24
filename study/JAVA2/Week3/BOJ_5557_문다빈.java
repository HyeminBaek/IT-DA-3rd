import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Grade1 {
	static long check[][];//1���� �ε��� : �� �� �ִ� ����, 2��° �ε��� : ���� ����Ƚ��
	static ArrayList<Integer> n_list = new ArrayList<>();
	static ArrayList<Integer> result = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		// ���Ҿ��̳� ž�ٿ��̳� �װ��� �����δ�..
		// ���������� ������ =�� ��..!
		// ���Ҿ����� ����..
		// ���� bfs..?(n-2�� ���� ����)
		// �� n-2�� ������ �̷��� �� = ���� ��~
		// �ð��ʰ���..�� check ���� �迭�� �Ἥ �ߺ������� ������..!
		// Ʋ������ : long�� �ȽἭ..��
		
		int n;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		check = new long[21][n-1];
		for(int i = 0; i < n; i++) {
			n_list.add(Integer.parseInt(st.nextToken()));
		}
		math(n);
		System.out.println(check[n_list.get(n_list.size()-1)][n-2]);
	}
	
	static void math(int d) {
		int limit;
		int a;
		int b;
		int n = 1;
		result.add(n_list.get(0));
		check[n_list.get(0)][0] = 1;
		
		while(n <= d-2) {
			limit = result.size();
			b = n_list.get(n);
			for(int i = 0; i < limit; i++) {
				a = result.get(0);
				if(a + b <= 20) { 
					if(n == d-2) {//������ ���궧 =�� Ȯ��
						if(a + b == n_list.get(n_list.size() - 1)) {
							if(check[a + b][n] == 0) {
								check[a + b][n] = check[a][n-1];
							}
							else {
								check[a + b][n] = check[a + b][n] + check[a][n-1];
							}
						}
					}
					else {
						if(check[a + b][n] == 0) {
							result.add(a + b);
							check[a + b][n] = check[a][n-1];
						}
						else {
							check[a + b][n] = check[a + b][n] + check[a][n-1];
						}
					}
				}
				
				if(a - b >= 0) {
					if(n == d-2) {//������ ���궧 =�� Ȯ��
						if(a - b == n_list.get(n_list.size() - 1)) {
							if(check[a - b][n] == 0) {
								check[a - b][n] = check[a][n-1];
							}
							else {
								check[a - b][n] = check[a - b][n] + check[a][n-1];
							}
						}
					}
					else {
						if(check[a - b][n] == 0) {
							result.add(a - b);
							check[a - b][n] = check[a][n-1];
						}
						else {
							check[a - b][n] = check[a - b][n] + check[a][n-1];
						}
					}
				}
				result.remove(0);
			}
			n++;
		}
	}

}
