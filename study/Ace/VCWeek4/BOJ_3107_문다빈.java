import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Ipv6 {

	public static void main(String[] args) throws IOException {
		// ���ڿ�
		// �ϴ� �ִ±״�� �ܼ��� ����
		int index;
		String s;
		String ans = "";
		String[] split;
		ArrayList<String> list = new ArrayList<>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s = br.readLine();
		
		split = s.split(":");
		if(s.equals("::")) { //�ϵ��ڵ� �κ�
			split = new String[2];
			split[0] = "";
			split[1] = "";
		}
		
		for(String i : split) {
			if(i.length() == 4) {
				list.add(i);
			}
			else {
				if(i.length() == 0) {
					list.add(i);
				}
				else {
					while(i.length() != 4) {
						i = "0" + i;
					}
					list.add(i);
				}
			}
		}
		
		index = list.indexOf("");
		
		if(index == -1 && list.size() < 8) { //�ϵ��ڵ� �κ�
			//1::���� ��쿡�� ���ø��� ����� ���� �ʴ� ��� ����
			list.add("");
			list.add("");
			index = list.indexOf("");
		}
		
		if(index == 0) {//::1 �̷������϶�
			list.remove(0);
			list.remove(0);
			while(list.size() < 8) {
				list.add(0, "0000");
			}
		}
		else {//1:: �Ǵ� 6::6�̷����� �Ǵ� �ƿ� ::�̰� ���� ��
			if(index == list.size() - 2) {
				if(list.get(list.size() - 2) == "" && list.get(list.size() - 1) == "") {
					list.remove(list.size() - 2);
					list.remove(list.size() - 1);
					while(list.size() < 8) {
						list.add("0000");
					}
				}
				else {
					list.remove(index);
					while(list.size() < 8) {
						list.add(index, "0000");
					}
				}
			}
			else {
				if(index != -1) {
					list.remove(index);
					while(list.size() < 8) {
						list.add(index, "0000");
					}
				}
			}
		}
		
		ans = list.get(0);
		for(int i = 1; i < list.size(); i++) {
			ans = ans + ":" + list.get(i);
		}
		System.out.println(ans);
	}

}
