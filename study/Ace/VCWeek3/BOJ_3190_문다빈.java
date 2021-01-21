import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Snake {
	
	static class graph {
		int x;
		int y;
		
		graph(int a, int b) {
			x = a;
			y = b;
		}
	}
	
	static class Apple {
		int x;
		int y;
		boolean eat;
		
		Apple(int a, int b, boolean c) {
			x = a;
			y = b;
			eat = c;
		}
	}
	
	static int direction_index = 0;
	static graph direction[] = {new graph(1,0), new graph(0,1), new graph(-1,0), new graph(0,-1)};//��������0123
	
	public static void main(String[] args) throws IOException {
		// �ϴ� �ܼ��� ����
		// �� ������ġ ������ �ڷᱸ�� �ʿ�
		int x;
		int y;
		int N;//���� ũ��
		int K;//��� ����
		int L;//���� ��ȯ ����
		int length = 1;//���� ����
		int time = 0;
		boolean crash = false;
		boolean sw = true;
		
		HashMap<Integer, String> turn = new HashMap<>();//ȸ�� ���� ����
		ArrayList<Apple> apple = new ArrayList<>();//��� ��ġ ����
		ArrayList<graph> snake = new ArrayList<>();//�� ��ġ���� ����
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		snake.add(new graph(1,1));
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			apple.add(new Apple(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), false));
		}
		
		L = Integer.parseInt(br.readLine());
		for(int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			turn.put(Integer.parseInt(st.nextToken()), st.nextToken());
		}
		
		while(true) {
			++time;
			//�̵�
			sw = false;
			x = snake.get(0).x;
			y = snake.get(0).y;
			snake.add(0, new graph(x + direction[direction_index].x, y + direction[direction_index].y));
			//�Ӹ���ġ�� ��� �ִ��� �ľ�
			if(K > 0) {
				for(int i = 0; i < apple.size(); i++) {
					if(apple.get(i).x == snake.get(0).x && apple.get(i).y == snake.get(0).y) {
						System.out.println("in");
						if(apple.get(i).eat == false) {
							System.out.println("in");
							apple.get(i).eat = true;
							sw = true;
							++length;
							--K;
						}
						break;
					}
				}
			}
			
			//�ھҴ��� �ľ�
			if(snake.get(0).x <= 0 || snake.get(0).y <= 0 || snake.get(0).x > N || snake.get(0).y > N) {
				break;
			}
			//���뿡 �ھҴ��� �ľ�
			for(int i = 1; i < length; i++) {
				if(snake.get(0).x == snake.get(i).x && snake.get(0).y == snake.get(i).y) {
					crash = true;
					break;
				} 
			}
			
			if(!sw) 
				snake.remove(length);//��� �� ���� ���
			
			if(crash) {
				break;
			}
			
			//��ȯ ���� �ִ��� �ľ�
			if(turn.containsKey(time)) {
				convert_direction(turn.get(time));
			}
		}
		
		System.out.println(time);
	}

	
	static void convert_direction(String s) {
		if(s.equals("D")) {
			if(direction_index < 3) {
				++direction_index;
			}
			else {
				direction_index = 0;
			}
		}
		else {
			if(direction_index > 0) {
				--direction_index;
			}
			else {
				direction_index = 3;
			}
		}
	}
}
