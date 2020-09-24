package q2407;


import java.math.BigInteger;
import java.util.Scanner;

public class Q2407 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n,m;
		n=sc.nextInt();
		m=sc.nextInt();
		
		if((n/2)<m) {
			m = n-m;
		}
//		nCm = nPm / m!
//		up = nPm , down = m!
//		BigInteger�� ������ ���Ѵ��̴�. ���� BigIntegerŬ������ ����ϸ� int�� long���� ǥ���� �� ���� ���� ǥ���� �����ϴ�.
		BigInteger up = BigInteger.ONE;
		BigInteger down = BigInteger.ONE;
		
		for(int i =0 ; i<m;i++) {
			up = up.multiply(new BigInteger(String.valueOf(n-i)));
			down = down.multiply(new BigInteger(String.valueOf(i+1)));
		}
		BigInteger result = up.divide(down);
		
		System.out.println(result);
	}
}
