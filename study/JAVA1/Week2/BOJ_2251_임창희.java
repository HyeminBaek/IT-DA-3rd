package waterbottle2251;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


/*
 * ���ǰ� A,B,C(1<=A,B,C<=200)����
 * ó�� ���� �� ������ ����ִ�. 
 * ����° ������ ����(C����)�� �ִ�.
 * ���� �ٸ� �������� ��� ���� �� �ִµ� 
 * ����) �� ������ ��ų�, �ٸ� �� ������ ���� �� ������
 * ���) A������ ��� ���� ��, C���뿡 ������� �� �ִ� ���� ���� ��� ���س��� ���α׷�*/
public class WaterBottle {
	public static void main(String[] args)  {
		
		Scanner sc = new Scanner(System.in);
		int[] amount = new int[3];	//A,B,C�� ���Ǹ� ��� �迭 amount
		for(int t=0;t<3;t++) {
			amount[t]=sc.nextInt();
		}
//		A,B,C�� ���ǰ� 200�ε� �ε��� ���� ����ϹǷ� 200���� ��Ÿ������ ���� ũ�⸦ 201�� �ߴ�.
		boolean[][] visited = new boolean[201][201];	
	    boolean[] answer = new boolean[201];	
		Queue<Pair> q = new LinkedList<>();
	    int []from = {0,0,1,1,2,2};
		int []to = {1,2,0,2,0,1};
		
		q.add(new Pair(0,0));
		visited[0][0]=true;
		answer[amount[2]] = true;
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			int x = p.x;
			int y=p.y;
			int z = amount[2]-x-y;
			
			for (int i = 0; i < to.length; i++) {
				int[] next = {x,y,z};
				next[to[i]] += next[from[i]];		
				next[from[i]]=0;
				
				if(next[to[i]]>amount[to[i]]) {
					next[from[i]] +=next[to[i]]-amount[to[i]];
					next[to[i]]= amount[to[i]];
				}
				if(!visited[next[0]][next[1]]) {
					visited[next[0]][next[1]]=true;
					q.add(new Pair(next[0],next[1]));
					if(next[0]==0) {
						answer[next[2]]=true;						
					}
				}
			}
		}
		for(int j=0;j<=amount[2];j++) {
			if(answer[j]) {
				System.out.print(j+" ");
			}
		}
	}
}
class Pair{
	int x,y;
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}