import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reverse3 {

	public static void main(String[] args) throws IOException {
		// �׸��� �˰���
		// ��� ����� ���� ���ؼ� ���ϱ⿣ �׽�Ʈ���̽��� �ʹ� ����..
		// ��Ģ : �񱳴���� �Ǵ� �Ǿ� ���ڿ�(�ֳ��ϸ� �̰� ������ �������� ��ġ�� �ٲ�� ���̴ϱ�)���������� ���ĵ��������� ������ �δٰ�, ������ ������ ���°� ������ ������ �� �� �� �� ���ִ� ��.
		// ����ġ�� 100�ۼ�Ʈ Ʋ�Ƚ��ϴ� �� �Ѥ� ->�� ���� 1�϶� ������ؼ�..������������
		String s;
		String sol = "";
		StringBuilder sb;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		s = br.readLine();
		
		if(s.length() == 1) {
			sol = s;//�̰� ��ó�����༭ Ʋ����.. �ٵ� �� �ϵ��ڵ��ε�
		}
		
		for(int i = 1; i < s.length(); i++) {
			if(s.charAt(i) <= s.charAt(0)) {
				sb = new StringBuilder(s.substring(0, i));
				sb.reverse();
				sb.append(s.charAt(i));
				sol = sb.reverse().toString();
				if(i != s.length() - 1) {
					s = sb.toString() + s.substring(i + 1, s.length());
				}
			}
			else {
				sol = s.substring(0, i+1);
			}
		}
		
		System.out.println(sol);
	}

}
