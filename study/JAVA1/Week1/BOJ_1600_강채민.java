import java.util.*;

public class Main {
	
	//����Ʈ ��ǥ.
	static int move_k_x[] = {-1, 1, 2, 2, 1, -1, -2, -2};
	static int move_k_y[] = {1, 1, 1, -1, -2, -2, -1, 1};
	
	static int move_x[] = {1, -1, 0, 0}; // ��������
	static int move_y[] = {0, 0, -1, 1}; // ��������
	
	static int Monkey_Map [][];
	static int check [][];
	
	static int W;
	static int H;

	static ArrayList<Integer> Answer = new ArrayList<>();
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int K = input.nextInt(); // ����Ʈ ���� �̵� Ƚ��.
		
		W = input.nextInt(); // ����
		H = input.nextInt(); // ����
		
		Monkey_Map = new int [H][W];
		check = new int [H][W];
		
		for(int h = 0; h < H; h++) {
			for(int w = 0; w < W; w++) {
				Monkey_Map[h][w] = input.nextInt();
			}
		}
		
		check[0][0] = 1; // ������ �����.
		dfs(0, 0, K, 0);
		
		if(Answer.size() == 0)
			System.out.println(-1);
		
		else
			System.out.println(Collections.min(Answer)); // �ּڰ� ����ϱ�
	}

	public  static void dfs(int x, int y, int k_count, int count) {
		
		if(x == W-1 && y == H-1) { // ������ �� �Դٸ�
			Answer.add(count-1);
			return;
		}
		
		if(k_count > 0) { // ����Ʈ �̵� Ƚ���� ���� �ִٸ�
			
			for(int kc = 0; kc < move_k_x.length; kc++) {
				
				int go_kx = x + move_k_x[kc];
				int go_ky = y + move_k_y[kc];
				
				if(go_kx < 0 || go_ky < 0 || go_kx >= W || go_ky >= H) // ������ �����
					continue;
				
				if(check[go_kx][go_ky] == 1) // �̹� �����̶��
					continue;
				
				if(Monkey_Map[go_kx][go_ky] == 1) // ��ֹ��� �ִٸ�
					continue;
				
				check[go_kx][go_ky] = 1; // ���� ǥ��
				dfs(go_kx, go_ky, k_count-1, count+1);
				check[go_kx][go_ky] = 0; // ���� �ٽ� �������ֱ�.
				
			}
		}
		
		else {
			
			for(int i = 0; i < move_x.length; i++) {
				
				int go_x = x + move_x[i];
				int go_y = y + move_y[i];
				
				if(go_x < 0 || go_y < 0 || go_x >= W || go_y >= H) // ������ �����
					continue;
				
				if(check[go_x][go_y] == 1) // �̹� �����̶��
					continue;
				
				if(Monkey_Map[go_x][go_y] == 1) // ��ֹ��� �ִٸ�
					continue;
				
				check[go_x][go_y] = 1; // ���� ǥ��
				dfs(go_x, go_y, 0, count+1);
				check[go_x][go_y] = 0; // ���� �ٽ� �������ֱ�.
			}
		}
	}

}
