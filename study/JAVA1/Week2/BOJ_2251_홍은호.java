import java.util.Scanner;

public class WaterBottle {

	static boolean visited[][] = new boolean[201][201];
	static boolean cnt[] = new boolean[201];
	static int maxA, maxB, maxC;
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		maxA = s.nextInt();
		maxB = s.nextInt();
		maxC = s.nextInt();
		
		DFS(0,0,maxC);
		
		for(int i=0; i<201; i++)
		{
			if(cnt[i])
				System.out.print(i+ " ");
		}
		
	}
	
	public static void DFS(int ca, int cb, int cc) {
		if(visited[ca][cb])
			return;
		
		if(ca == 0)
			cnt[cc] = true;
		
		visited[ca][cb] = true;
		
		// 1. A -> B
		if(ca+cb > maxB) //B�� ���� �װ� A�� ���� ���
			DFS((ca+cb)-maxB, maxB, cc);
		else //B�� ���� �װ� A�� �� ���
			DFS(0, ca+cb, cc);
		
		// 2. B -> A
		if(cb+ca > maxA) //A�� ���� �װ� B�� ���� ���
			DFS(maxA, (cb+ca)-maxA, cc);
		else //A�� ���� �װ� B�� �� ���
			DFS(cb+ca, 0, cc);
		
		// 3. A -> C (C�� �״� ���� ��ĥ ���ɼ��� ����)
		DFS(0, cb, ca+cc);
		
		// 4. C -> A
		if(cc+ca > maxA) //A�� ���� �װ� C�� ���� ���
			DFS(maxA, cb, (cc+ca)-maxA);
		else //A�� ���� �װ� C�� �� ���
			DFS(cc+ca, cb, 0);
		
		// 5. B -> C (C�� �״� ���� ��ĥ ���ɼ��� ����)
		DFS(ca, 0, cb+cc);
		
		// 6. C -> B
		if(cc + cb > maxB) //B�� ���� �װ� C�� ���� ���
			DFS(ca, maxB, (cc+cb)-maxB);
		else //B�� ���� �װ� C�� �� ���
			DFS(ca, cc+cb, 0);
	}

}
