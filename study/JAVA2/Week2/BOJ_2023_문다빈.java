import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SpecialP {
	static ArrayList<Integer> list = new ArrayList<>();
	static int limit;
	static int comp;
	static int N;
	static boolean pri = true;//true�� �Ҽ� ��Ÿ��

	public static void main(String[] args) throws NumberFormatException, IOException {
		// ��� �ڸ��� �Ҽ�(1�� �ڱ��ڽ��� ���θ� �������� ��)�� ���� ã���ô�.
		// 1 �ڸ� �Ҽ� : 2 3 5 7 �̰ɷ� ������ ù �ڸ� ����!
		// 2° �ڸ����ʹ� ¦���� ���ɴϴ�.
		// �Ҽ��� ��� �������� ����. ������ ������~ ���س����� �ɷ�.. ���� ���ô�.. �ð��ʰ� �ȳ��⸦..
		// �ڸ� ���� ���� ã�ƿö󰡴� ������..? �޸� ������ �ʹ��۴�.. 4MB
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		list.add(2);//�⺻ �� �ֱ�..!
		list.add(3);
		list.add(5);
		list.add(7);
		
		if(N == 1)
			for(int i = 0; i < 4; i++) {
				System.out.println(list.get(i));
			}
	
		else {
			for(int i = 1; i < N; i++) {
				limit = list.size();//list���� ������ �����ϴ� �������� ������.
				Prime(i);
			}
		}
		
	}

	static void Prime(int d) {
		int count = 0;
		int lim;//������ ����Ǵ� ����
		while(count < limit) { //while���� list�� ������ ��ŭ�� �����ϴ�.
			count = count + 1;
			comp = list.get(0) * 10 + 1;
			list.remove(0);
			for(int i = 0; i < 5; i++) {
				lim = (int) Math.floor(Math.sqrt(comp));
				pri = true;
				if(Math.pow(lim, 2) == comp) {
					comp = comp + 2;
					continue;
				}
				for(int j = 2; j <= lim; j++) {
					if(comp % j == 0) {
						pri = false;
						break;
					}
				}
				if(pri == true) {//���� �˻��ϴ� comp�� �Ҽ���� �ǹ�
					if(d == N - 1) //������ �ڸ����� ���� ���� �ٷ� ������ݽô�.
						System.out.println(comp);
					else
						list.add(comp);
				}
				comp = comp + 2;//������ ¦������ �˻��� �ʿ䵵 ������ Ȧ���� 2�� ��� ���ؼ� �˻�~ �ð��ʰ� ����
			}
		}
	}
}
