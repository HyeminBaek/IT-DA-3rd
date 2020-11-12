import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class BOJ_14675_��â�� {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		LinkedList<Integer>[] graph= new LinkedList[n+1];
		for (int i = 0; i <= n; i++) {
			graph[i] = new LinkedList<Integer>();
		}
		for(int i=0; i<n-1; i++) {
			int from=sc.nextInt();
			int to=sc.nextInt();
			graph[from].add(to);
			graph[to].add(from);
		}
		int q=sc.nextInt();
		for(int i=0; i<q; i++) {
			//t=1�϶� ���������� �Ǵ�? t=2�϶� ���������� �Ǵ�?
			int t=sc.nextInt();
			int k=sc.nextInt();
			int cnt=0;
			if(t==1) {
				if(graph[k].size()>=2) System.out.println("yes");
				else System.out.println("no");
			}
			else	System.out.println("yes");
			
		}
	}
}
