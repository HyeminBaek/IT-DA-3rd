import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int N = input.nextInt(); // ģ�� ���
		
		int L = input.nextInt();
		
		int Friend_Map [][] = new int [N+1][N+1]; // 1���� �����̴ϱ�
		int check [] = new int [N+1];
		int level [] = new int [N+1];
		
		for(int l = 0; l < L; l++) {
			
			int a = input.nextInt();
			int b = input.nextInt();
			
			Friend_Map[a][b] = 1;
			Friend_Map[b][a] = 1;
		}
		
		Queue<Integer> Friend = new LinkedList<>();
		int count = 0;
		
		Friend.add(1); // ����̺��� ����
		check[1] = 1; // ����� ���� üũ
		
		while(!Friend.isEmpty()) {
			
			int F = Friend.poll();
			
			if(level[F] > 1) // level2�� �Ѿ�� count���� �ʱ�!
				break;
			
			for(int i = 1; i < Friend_Map[F].length; i++) {
				
				if(Friend_Map[F][i] == 0) // �ƹ��͵� ������
					continue;
				
				if(check[i] == 1) // �̹� ���� ���̶��
					continue;
				
				Friend.add(i);
				check[i] = 1;
				count = count + 1; // ģ���� �߰�
				
				level[i] = level[F] + 1;
			}
		}
		
		System.out.println(count);
	}

}
