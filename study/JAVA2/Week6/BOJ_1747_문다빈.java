import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Palindrome {

	public static void main(String[] args) throws NumberFormatException, IOException {
		//1���ڸ��� �Ӹ������ �Ǵ±���...��
		//�Ӹ������ �켱 ã�� �Ŀ� �Ҽ��� ã���ִ� ������� ������ Ǯ�����ϴ�.
		String N;
		boolean pri;
		StringBuilder sb;
		int lim;
		int n;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = br.readLine();
		
		if(Integer.parseInt(N) <= 2)
			System.out.println(2);
		else if(Integer.parseInt(N) <= 3)
			System.out.println(3);
		else if(Integer.parseInt(N) <= 5)
			System.out.println(5);
		else if(Integer.parseInt(N) <= 7)
			System.out.println(7);
		else if(Integer.parseInt(N) <= 11)
			System.out.println(11);
		else {
			if(N.length() == 2) {
				System.out.println(101);
			}
			else {
				if(Integer.parseInt(N) % 2 == 0)
					N = Integer.toString((Integer.parseInt(N) + 1));
				while(true) {
					sb = new StringBuilder(N.substring(N.length() - N.length() / 2, N.length()));
					sb.reverse();
					if(N.substring(0, N.length() / 2).equals(sb.toString())) {
						n = Integer.parseInt(N);
						lim = (int) Math.floor(Math.sqrt(n));
						pri = true;
						if(n % lim == 0) {
							N = Integer.toString(n + 2);
							continue;
						}
						for(int j = 2; j < lim; j++) {
							if(n % j == 0) {
								pri = false;
								break;
							}
						}
						if(pri == true) {//���� �˻��ϴ� n�� �Ҽ���� �ǹ�
							System.out.println(n);
							break;
						}
					}
					N = Integer.toString(Integer.parseInt(N) + 2);//������ ¦������ �˻��� �ʿ䵵 ������ Ȧ���� 2�� ��� ���ؼ� �˻�~ �ð��ʰ� ����
				}
			}
		}
	}
}

