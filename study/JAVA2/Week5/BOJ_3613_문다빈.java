import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JavaCpp {

	public static void main(String[] args) throws IOException {
		//����ó���� ���� ����� ������ ���ڿ� ����..
		String s;
		String temp;
		String res = "";
		boolean sw = true;
		int cnt = 0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		s = br.readLine();
		
		if(s.contains("_")) {//cpp case
			if(s.charAt(0) == '_' || s.charAt(s.length() - 1) == '_') {//���� ���̳� �ڿ� _�� �� ���
				System.out.println("Error!");
			}
			else {
				for(int i = 0; i < s.length(); i++) {
					if(s.charAt(i) == '_') {
						++cnt;
						if(cnt >= 2) {//_�� �ι� �������� ���� ���
							System.out.println("Error!");
							sw = false;
							break;
						}
					}
					else if(s.charAt(i) < 97) {//cpp case���� �빮�ڰ� ������ ���
						System.out.println("Error!");
						sw = false;
						break;
					}
					else {
						if(cnt == 1) {//_���� ���Ŀ� ������ ������ ���
							cnt = 0;
							temp = (s.charAt(i) + "").toUpperCase();
							res = res.concat(temp);
						}
						else {
							res = res + s.charAt(i);
						}
					}
				}
				if(sw == true)
					System.out.println(res);
			}
		} 
		else {//java case
			if(s.charAt(0) < 97) {
				System.out.println("Error!");
			}//���� ���� ���ڰ� �빮���� ���
			else {
				System.out.print(s.charAt(0));
				for(int i = 1; i < s.length(); i++) {
					if(s.charAt(i) < 97) {//�빮���� ���
						temp = (s.charAt(i) + "").toLowerCase();
						System.out.print("_" + temp);
					}
					else {//�ҹ����� ���
						System.out.print(s.charAt(i));
					}
				}
			}
		}
	}

}
