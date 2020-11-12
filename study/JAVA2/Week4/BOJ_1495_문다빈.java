import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class Guitar {
	public static void main (String[] args) throws IOException {
		//�߰��� ���� ������ �� ���ٸ� -1�� ����Ѵ�.
		int N, S, M;//���ۺ��� : S �ִ뺼�� : M
		ArrayList<Integer> list = new ArrayList<>();
		int v[];
		int s = 0;
		int check[][];//���� �ε����� ���� �� �ڰ� �� ��° ��~
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		StringTokenizer st = new StringTokenizer(br.readLine());
 
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		check = new int[M+1][N];
 
		v = new int[N];
		list.add(S);
 
		StringTokenizer st1 = new StringTokenizer(br.readLine());
 
		for(int i = 0; i < N; i++) {
			v[i] = Integer.parseInt(st1.nextToken());
		}
 
		int sw;
		int limit;
		int max = 0;
 
		while(!list.isEmpty()) {
			limit = list.size();
			sw = 0;
			if(s == N - 1) {
				for(int i = 0; i < limit; i++) {
					int a = list.get(0);
					if(a + v[s] <= M) {
						max = Math.max(a + v[s], max);
						sw = 1;
					}
					if(a - v[s] >= 0) {
						max = Math.max(a - v[s], max);
						sw = 1;
					}
					list.remove(0);
				}
				if(sw == 0) {
					System.out.println(-1);
					break;
				}
				System.out.println(max);
				break;
			}
			for(int i = 0; i < limit; i++) {
				int a = list.get(0);
				if(a + v[s] <= M && check[a+v[s]][s] == 0) {
					list.add(a + v[s]);
					check[a+v[s]][s] = 1;
					sw = 1;
				}
				if(a - v[s] >= 0 && check[a-v[s]][s] == 0) {
					list.add(a - v[s]);
					check[a-v[s]][s] = 1;
					sw = 1;
				}
				list.remove(0);
			}
			if(sw == 0) {
				System.out.println(-1);
				break;
			}
			++s;
		}
 
	}
}