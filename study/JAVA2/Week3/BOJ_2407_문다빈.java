import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Combination {

	public static void main(String[] args) throws IOException {
		// ���� dp!
		// �ſ� ū ���� ����..(big integer�� �Ⱦ��� �ذ��� �ȉ�)
		// ���� DP�� ��ǰ..
		// ���� nCr = nPr / r! �̿��ؼ� Ǯ������..
		ArrayList<BigInteger> list = new ArrayList<>();  
		BigInteger n, m;
		BigInteger sum = BigInteger.ONE;
		int a, b;
		int temp;
		String s;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		s = st.nextToken();
		b = Integer.parseInt(s);
		n = new BigInteger(s);
		s = st.nextToken();
		m = new BigInteger(s);
		a = Integer.parseInt(s);
		
		if(n.equals(m))
			System.out.println(1);
		else {
			for(int i = 0; i < a; i++) {
				temp = b - i;
				list.add(new BigInteger(temp + ""));//nPr�� list�� ���� �ϴ� �κ� 
			}
			for(int i = a; i > 0; i--) {//r!�� ���ư��鼭 �������� �κ�  
				while(!list.isEmpty()) {
					if(list.get(0).remainder(new BigInteger(i + "")).equals(BigInteger.ZERO)) {
						list.set(0, list.get(0).divide(new BigInteger(i + "")));
						break;
					}
					else {
						list.set(0, list.get(0).multiply(list.get(1)));
						list.remove(1);
					}
				}
			}
			
			for(BigInteger i : list) {
				sum = sum.multiply(i);
			}
			
			System.out.println(sum);
		}
		
		
	}
	
}
