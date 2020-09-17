import java.util.*;

public class Main{

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int N = input.nextInt(); // ����
		int M = input.nextInt(); // ����
		
		int Geulim [][] = new int[N][M];
		int check [][] = new int[N][M];
		
		int move_x[] = {1, -1, 0, 0};
		int move_y[] = {0, 0, 1, -1};
		
		for(int n = 0; n < N; n++)
			for(int m = 0; m < M; m++)
				Geulim[n][m] = input.nextInt();
		
		Queue<Integer> Geulim_X = new LinkedList<>(); // �׸� X��ǥ
		Queue<Integer> Geulim_Y = new LinkedList<>(); // �׸� Y��ǥ
		
		ArrayList<Integer> Find_Max = new ArrayList<>(); // �׸��� ���̸� �� ���� ArrayList. ���߿��� ���� ū ���� ����Ѵ�.
		
		int picture_count = 0; // ��ü �׸��� ���� 
		
		for(int i = 0; i < N; i++) {
			
			for(int j = 0; j < M; j++) {
				
				int onepicture_count = 0; // �� �׸��� ũ��
				
				if(check[i][j] == 1 || Geulim[i][j] == 0) // �� ���̰ų� �׸��� �ƴϸ�
					continue;
				
				Geulim_X.add(i);
				Geulim_Y.add(j);
				
				check[i][j] = 1; // ���ٰ� üũ���ֱ�.
				
				picture_count = picture_count + 1; // ��ü �׸� ���� ����
				
				while(!Geulim_X.isEmpty()) {
					
					int X = Geulim_X.poll();
					int Y = Geulim_Y.poll();
					
					onepicture_count = onepicture_count + 1; // �� �׸��� ũ�� ����.
					
					for(int mx = 0; mx < move_x.length; mx++) { // �����¿�� �����̸鼭
						
						int go_x = X + move_x[mx];
						int go_y = Y + move_y[mx];
						
						if(go_x < 0 || go_y < 0 || go_x >= N || go_y >= M) // ���� ������
							continue;
						
						if(check[go_x][go_y] == 1 || Geulim[go_x][go_y] == 0) // �������̰ų� �׸��� �ƴ϶��
							continue;
						
						Geulim_X.add(go_x);
						Geulim_Y.add(go_y);
						
						check[go_x][go_y] = 1;
					}
				}
				
				Find_Max.add(onepicture_count); // ArrayList���ٰ� �� �׸��� ũ�� �ֱ�.
			}
		}
		
		System.out.println(picture_count); // ��ü �׸��� ���� ���.
		
		if(picture_count == 0) // "��, �׸��� �ϳ��� ���� ��쿡�� ���� ���� �׸��� ���̴� 0�̴�."
			System.out.println(0);
		
		else
			System.out.println(Collections.max(Find_Max));
		
	}

}
