import java.util.Scanner;

public class BOJ_1747_��â�� {
	//�����佺�׳׽��� ü�� �̿��ؼ� �Ҽ��� �Ǻ��ϰ�, �Ӹ������ ���ڿ��� ���ڸ��� ���ڸ��� ���ؼ� �Ǻ��Ͽ���
	public static void main(String[] args) {
		int []number= new int[2000001];
		Scanner sc=new Scanner(System.in);
		int n =sc.nextInt();

		for(int i=2; i<=2000000; i++) {
			number[i]=1;
		}
		for(int i=2; i*i<=2000000; i++) {
			for(int j=2*i; j<=2000000; j+=i) {
				if(number[j]==0) continue;
				else if(number[j]==1) number[j]=0;
			}
		}
		for(int i=n; i<=2000000; i++) {
			if(number[i]==1) {
				boolean check=true;
				String temp=Integer.toString(i);
				int a=0;
				int b=temp.length()-1;
				while(a<=b) {
					if(temp.charAt(a)!=temp.charAt(b)) {
						check=false;
						break;
					}else {
						a++; b--;
					}
				}
				if(check==true) {
					System.out.println(i);
					return;
				}
			}
		}

	}

}
