import java.io.*;
//������ �޸� ������ �Ⱥ��� �Ҽ��� �����س��� �����佺�׳׽��� ü�� Ǯ���� �õ��� ������ ������ �޸� ���� 4mb�̿��� 10^8���� �����������δ� Ǯ�� ���Ѵ�
//���� top down ������� Ǯ �ÿ�, �Ҽ��� �Ǻ��س��� �ð� ���⵵O(N^2)�̹Ƿ� TOP DOWN ���ٴ� Bottom-up�� �����ϴ�.
//public class BOJ_2234_��â�� {
//	public static int []array =new int[10000001];
//	private static BufferedWriter wr= new BufferedWriter(new OutputStreamWriter(System.out));
//	
//	public static void dfs(int first, int cur, int number) throws IOException {
//		if(number==0) {
//			System.out.println(first);
//			return;
//		}
//		int temp=cur/10;
//		
//		if(array[temp]!=0) {
//			dfs(first, temp , number-1);
//		}else {
//			return;
//		}
//	}
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String temp[]=br.readLine().split(" ");
//		int number=Integer.parseInt(temp[0]);
//		double min= Math.pow(10, number-1);
//		double max=Math.pow(10, number)-1;
//		array[1]=0;
//		for(int i=2; i<=max; i++) {
//			array[i]=i;
//		}
//		for(int i=2; i*i<=max; i++) {
//			if(array[i]==0) continue;
//			for(int j=2*i; j<=max; j=j+i) {
//				array[j]=0;
//			}
//		}
//		for(int i=(int) min; i<=max; i++) {
//			//n�� �ڸ� �����߿��� �Ҽ��� �ƴ� ���� n-1�ڸ� �˻�
//			if(array[i]!=0) {
//				dfs(array[i],array[i],number-1);
//			}
//		}
//		wr.flush();
//		wr.close();
//	}
//}
public class BOJ_2023_��â��{
	private static BufferedWriter wr= new BufferedWriter(new OutputStreamWriter(System.out));
	public static int number;
	
	public static boolean isDecimal(int num) {
		//�Ҽ��϶� true �� ��ȯ�Ѵ�.
		for(int i=2; i<num; i++){
			if(num%i==0) return false;
		}
		return true;
	}
	public static void dfs(int current, int cnt) {
		if(number==cnt) {
			if(isDecimal(current)) System.out.println(current);
		}
		int temp=current*10;
		for(int i=1; i<=9; i+=2) {
//			���ʿ������� 10�� �ڸ�, 100�� �ڸ� ,,,N-1�� �ڸ��� �Ҽ����� üũ
			int target=temp+i;
			if(isDecimal(target)) {
				dfs(target, cnt+1);
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String temp[]=br.readLine().split(" ");
		number = Integer.parseInt(temp[0]);
//		�Ҽ��� �Ƿ��� ���ڸ��� 2,3,5,7 �߿� �ϳ����� �Ѵ�
		int [] deci= {2,3,5,7};
		for(int i=0; i<4; i++) {
			dfs(deci[i],1);
		}
	}
}