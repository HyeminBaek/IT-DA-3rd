import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class XY {
	int x;//��ǥ
	int y;//��ǥ
	int k;//���� �� �� �ִ� ��ȸ
	int cost;//�ű���� ���� ���..
	
	public XY(int a, int b, int c, int d) {
		y = a;
		x = b;
		k = c;
		cost = d;
	}
}

public class MtobeH {
	static int w, h;
	static int op_X[] = {1,-1,0,0};//�������� x��ǥ
	static int op_Y[] = {0,0,-1,1};//�������� y��ǥ
	static int op_X2[] = {2,1,2,1,-2,-1,-2,-1};//����Ʈ�� ��ǥ
	static int op_Y2[] = {1,2,-1,-2,1,2,-1,-2};//����Ʈ�� ��ǥ
	static int map[][];//��ü���� �� ���¸� �����ִ� ������ �迭
	static int visited[][][];//��ǥ �湮�� ��Ÿ��. �� ���� k�� ���� Ƚ���� ��Ÿ��.
	static int cost = 0;
	static boolean cond = false;//���� ã�Ƴ´� �� �� ã�Ƴ´� �� �����ϴ� ����
	static ArrayList<XY> list = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		// ���� ��� : ĭ������ �ּ� �̵� Ƚ���� ���س����� ������� Ǯ��ô�. 
		// ���� ���(����) : �ּ� �̵��� ����ϸ� �ȵǰ� k�� ���� Ƚ���� ����ؼ� �ش� ĭ���� �� �� �ִ� �ּ� �̵�Ƚ���� �����ּ���..
		// BFS�� ���°� ���ƺ��̳׿�..
		// ���� �ڷᱸ���� �����⿣ �ʹ� ����� ����..
		// ���ѽð��� 2�ʷ� �˳������̶� ������ص� �� �� �����ϴ�..(3�� �迭�� �Ǵ� ������ �ƴ϶��..?)
		// �� �ð��ʰ��� �����ϴ�..�� -> ������ ���� visited üũ�� ����� ���ؼ�..�� ���ѷ��� ���ҽ��ϴ�. �˰��� ��ü�� ����x
		int k;//�������� ���� Ƚ��
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		map = new int[h][w];
		visited = new int[h][w][k+1];
		
		for(int i = 0; i < h; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			for(int j = 0; j < w; j++) {
				map[i][j] = Integer.parseInt(st1.nextToken());
			}
		}
		Move(0,0,k);
		if(w == 1 && h == 1) //������ 1ĭ �ۿ� ���� ���� 0 ���
			System.out.println(0);
		else {
			if(cond == false)
				System.out.println(-1);//��� ���Ҵµ��� ��ã���� ���� -1 ���
		}
	}
	
	static void Move(int y, int x, int k) {//�����̸� �����̴� ����
		//���⼭ �Ű��� �� ���� 3���� �迭�� Ȱ���ؼ� k�� ���� Ƚ���� ���� �湮�� �ٸ��� üũ���ִ� ��!
		int next_x, next_y;
		
		list.add(new XY(y, x, k, 0));
		visited[0][0][k] = 1;
		
		while(!list.isEmpty()) {
			cost = list.get(0).cost;
			for(int i = 0; i < 4 ; i++) { //�����̰� �̵��ϴ� ��
				next_x = list.get(0).x + op_X[i];
				next_y = list.get(0).y + op_Y[i];
				if(next_x >= 0 && next_x < w && next_y >= 0 && next_y < h)
					if(map[next_y][next_x] == 0 && visited[next_y][next_x][list.get(0).k] == 0) {
						if(next_x == w - 1 && next_y == h - 1) { //���ϴ� �� ã���� �ٷ�Ż��
							System.out.println(cost + 1);
							cond = true;
							break;
						}
						visited[next_y][next_x][list.get(0).k] = 1;
						list.add(new XY(next_y, next_x, list.get(0).k, cost + 1));
					}
			}
			
			if(cond == true)
				break;
			
			if(list.get(0).k > 0) { //���� �̵��ϴ� ��
				for(int i = 0; i < 8; i++) {
					next_x = list.get(0).x + op_X2[i];
					next_y = list.get(0).y + op_Y2[i];
					if(next_x >= 0 && next_x < w && next_y >= 0 && next_y < h)
						if(map[next_y][next_x] == 0 && visited[next_y][next_x][list.get(0).k - 1] == 0) {
							if(next_x == w - 1 && next_y == h - 1) { //���ϴ� �� ã���� �ٷ�Ż��
								System.out.println(cost + 1);
								cond = true;
								break;
							}
							visited[next_y][next_x][list.get(0).k - 1] = 1;
							list.add(new XY(next_y, next_x, list.get(0).k - 1, cost + 1));
						}
				}
			}
			
			if(cond == true)
				break;
			list.remove(0);
		}
	}

}
