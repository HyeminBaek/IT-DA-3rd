package BaekJoon;

import java.util.*;

public class HW_BJ_2234_Castle {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int N = input.nextInt();
		int M = input.nextInt();
		
		int Castle_Map [][] = new int [M][N];
		int Castle_Map2 [][] = new int [M][N]; // ���� ��ȣ ������ ���ο� Map
		int check [][] = new int [M][N];
		
		int move_x[] = {1, 0, -1, 0}; // ���ϵ����ε� �������� �Ųٷ� Ž���ϴϱ� ������ �����ϼ���!
		int move_y[] = {0, 1, 0, -1};
		
		for(int m = 0; m < M; m++) 
			for(int n = 0; n < N; n++)
				Castle_Map[m][n] = input.nextInt();
		
		Queue<Integer>Castle_X = new LinkedList<>();
		Queue<Integer>Castle_Y = new LinkedList<>();
		
		ArrayList<Integer>Room_Area = new ArrayList<>();
		
		int room = 0;
		
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				
				int count = 0;
				
				if(check[i][j] == 1)
					continue;
				
				else {
					
					Castle_X.add(i);
					Castle_Y.add(j);
					
					check[i][j] = 1;
					
					room = room + 1;
					
					Castle_Map2[i][j] = room; // ���� ��ȣ �־��ֱ�.
					
					while(!Castle_X.isEmpty()) {
						
						int X = Castle_X.poll();
						int Y = Castle_Y.poll();
						
						count++; // ���� ũ�� ����.
						
						
						int num = Castle_Map[X][Y];
						
						String Bnum = String.format("%04d",
								Integer.parseInt(Integer.toBinaryString(num))); //2���� ��ȯ��  + �̰� 4�ڸ��� ��ȯ.

						for(int s = 0; s < Bnum.length(); s++) {
							
							char tmp_s = Bnum.charAt(s);
							
							if(tmp_s == '1') //���̸�
								continue;
							
							
							int go_x = X + move_x[s];
							int go_y = Y + move_y[s];
							
							if(go_x < 0 || go_y < 0 || go_x >= M || go_y >= N) // ���� ������
								continue;
							
							if(check[go_x][go_y] == 1)
								continue;
							
							Castle_X.add(go_x);
							Castle_Y.add(go_y);
							
							check[go_x][go_y] = 1;
							
							Castle_Map2[go_x][go_y] = room;
						}
					}
					
					Room_Area.add(count); // �� ���� ũ�� ArrayList�� �ֱ�.
				}
			}
		}
		
		System.out.println(room); // �� ���� ���� ����
		
		/*for(int a = 0; a < Room_Area.size(); a++)
			System.out.println(Room_Area.get(a));*/
		
		System.out.println(Collections.max(Room_Area)); // ���� ���� ���� ũ��
		
		
		//�� ���ִ�! ���� ��ȣ ����
		/*for(int iii = 0; iii < M; iii++) {
			for(int jjj = 0; jjj < N; jjj++) {
				System.out.print(Castle_Map2[iii][jjj] + " ");
			}
			
			System.out.println();
		}*/
		
		int check2 [][] = new int [M][N];
		
		int max_area = 0; // ���ؼ� max�ϰ� üũ�ϱ�
		
		for(int r = 1; r <= room; r++) { // ���� ��ȣ ���� ����!
			
			for(int ii = 0; ii < M; ii++) {
				
				for(int jj = 0; jj < N; jj++) {
					
					if(check2[ii][jj] == 1 || Castle_Map2[ii][jj] != r)
						continue;
					
					//queue�� ������ �ʱ�ȭ �Ǿ����ϱ� �ٽ� ����ص� �ǰ���?
					
					Castle_X.add(ii);
					Castle_Y.add(jj);
					
					check2[ii][jj] = 1;
					
					while(!Castle_X.isEmpty()) {
						
						int X = Castle_X.poll();
						int Y = Castle_Y.poll();
						
						//int area_index = Castle_Map2[X][Y];
						
						for(int mx = 0; mx < move_x.length; mx++) {
							
							int gogo_x = X + move_x[mx];
							int gogo_y = Y + move_y[mx];
							
							if(gogo_x < 0 || gogo_y < 0 || gogo_x >= M || gogo_y >= N) // ���� ������
								continue;
							
							if(check2[gogo_x][gogo_y] == 1)
								continue;
							
							int go_area_index = Castle_Map2[gogo_x][gogo_y];
							
							if(r != go_area_index) {
								max_area = Math.max(max_area, 
										(Room_Area.get(r - 1) + Room_Area.get(go_area_index - 1)));
								
								continue;
							}
							
							Castle_X.add(gogo_x);
							Castle_Y.add(gogo_y);
							
							check2[gogo_x][gogo_y] = 1;
						}
					}
				}
			}
		}
		
		System.out.println(max_area);
	}

}
