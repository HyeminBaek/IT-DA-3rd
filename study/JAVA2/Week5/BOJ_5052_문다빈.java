import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class CallingNumber {
	
	public static void main(String[] args) throws IOException {
		// ���ξ �Ǹ� ��ȭ�� �� �� �����..
		// Trie �˰����ε� �̷��Դ� ��Ǯ����..
		// String �޼ҵ��� startsWith���
		// sort�� �ؾ��ϴ���..
		int t;
		int n;
		boolean sw;
		
		ArrayList<String> list = new ArrayList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		t = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < t; i++) {
			sw = true;
			n = Integer.parseInt(br.readLine());
			for(int j = 0; j < n; j++) {
				list.add(br.readLine());
			}
			Collections.sort(list);
			for(int j = 1; j < list.size(); j++) {
				if(list.get(j).startsWith(list.get(j - 1))) {
					sw = false;
					break;
				}
			}
			list.clear();
			if(sw == false) {
				System.out.println("NO");
			}
			else {
				System.out.println("YES");
			}
		}
		
	}

}
