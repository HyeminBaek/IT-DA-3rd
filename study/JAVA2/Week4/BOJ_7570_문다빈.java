import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Line { 
	public static void main(String[] args) throws IOException {
		//LIS ����
		//���� ���� ���� �� �κ� ������ �ǵ帮 ���ʰ� �ؾ� �ּ��� ��찡 ����!
		//�� �������� LIS�� Ư¡�� �����ϴ� ���ҵ��� ������ ������ ������ ������ŭ �̵��� �߻�
		//�� �ִ���̸� ������ ���� �� LSI�� ���� ������ ���ϸ� ��.
		int child[];
		int max = 0;
		int a;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		child = new int[n + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++) {
			a = Integer.parseInt(st.nextToken());
			child[a] = child[a-1] + 1;//���� ��ȣ�� ���� ���̰� �ִٸ� �ջ��ؼ�
			max = Math.max(child[a], max);
		}
		System.out.println(n - max);
	}
}
