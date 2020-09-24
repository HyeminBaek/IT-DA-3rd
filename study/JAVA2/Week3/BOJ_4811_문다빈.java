import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Capsule {
	static BigInteger check[][];//1���� �ε��� : ���� ����� W�� ����, 2��° �ε��� : ���� ����Ƚ�� 
	//���� H�� ���� - > ���� ����� W�ǰ��� - (���� ���� Ƚ�� - ���� ����� W�� ����)
	static ArrayList<Integer> w_list = new ArrayList<>();//�̹� ���࿡�� ����ǰ� �� w�� ������..

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 1�г�� ���繮��
		// �ð��ʰ��� �����ϱ����� �̹����� �ߺ��Ǵ� ���� �� �������ִ� ������ �����ô�..
		// W����(������ �˾�)�� ���� ���̿� ���� ����~ ������ �迭��~
		// �̰͵� ������ ��û ���� ������ biginteger�� �����ؾ��մϴ�.
		// ���Ҿ����� Ǯ������..
		// �� �ڵ忡�� �ߺ��� �� �� �� ���� �� �����ϴ�.(W 30���� �� �� ���� �ߺ���� ���ϴ� ������~)
		int n;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		while(n != 0) {
			w_list.clear();
			check = new BigInteger[n+1][(n * 2) + 1];
			
			for(int i = 1; i < n+1; i++) {
				Arrays.fill(check[i], new BigInteger("0"));
			}
			
			Cap(n, (n * 2) + 1);
			System.out.println(check[n][n*2]);
			
			n = Integer.parseInt(br.readLine());
		}
	}
	
	static void Cap(int n, int s) {
		int count = 1;//���� Ƚ��
		int limit;//w_list�� ���̰� ����� ����
		int temp;
		w_list.add(1);
		check[1][1] = new BigInteger("1");
		while(count < s - 1) {
			limit = w_list.size();
			for(int i = 0; i < limit; i++) {
				temp = w_list.get(0);
				if(temp < n) {
					if(check[temp + 1][count + 1].equals(BigInteger.ZERO)) {
						check[temp + 1][count + 1] = check[temp][count];
						w_list.add(temp + 1);
					}
					else {
						check[temp + 1][count+1] = check[temp + 1][count + 1].add(check[temp][count]);
					}
				}
				if(temp - (count - temp) > 0) {//H���� 0������ Ŭ ���� ����
					if(check[temp][count + 1].equals(BigInteger.ZERO)) {
						check[temp][count + 1] = check[temp][count];
						w_list.add(temp);
					}
					else {
						check[temp][count+1] = check[temp][count + 1].add(check[temp][count]);
					}
				}
				w_list.remove(0);
			}
			count = count + 1;
		}
	}

}
