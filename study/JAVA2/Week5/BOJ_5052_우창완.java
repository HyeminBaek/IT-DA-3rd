import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
//Ʈ���� ���ڿ��� �˻��ؼ� Ǯ �� ������,, �ʹ�������� ���ķ� Ǯ����
public class BOJ_5052_��â�� {
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			int n=Integer.parseInt(br.readLine());
			String []arr=new String[n];
			String answer="YES";
			for(int j=0; j<n; j++) {
				arr[j]=br.readLine();
			}
			//���������� ����
			Arrays.sort(arr, new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					return o1.compareTo(o2);
				}
			});
			for(int j=0; j<n-1; j++) {
				int len=arr[j].length();
				if(len>arr[j+1].length()) continue;
				if(arr[j].equals(arr[j+1].substring(0, len)))	answer="NO";
			}
			System.out.println(answer);
		}

	}

}
