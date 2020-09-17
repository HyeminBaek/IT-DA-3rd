package BOJ;
import java.io.*;
import java.util.*;
/*
 * bfs
 * 1)�� ���μ����س� ��Ģ�� ���� �Ŷ�� ����
 * C �� ����� ���� A, B, C, C-A, C-B, �̷��� ���� �Ŷ�� ������
 * 
 * 
 * public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int res[]= new int[4];
		int a = Integer.parseInt(bf.readLine());
		int b = Integer.parseInt(bf.readLine());
		int c = Integer.parseInt(bf.readLine());

		if(a>200 || b>200 || c>200) {
			return;
		}
		int d = c-a;
		int e = c-b;
		if(d<0) {
			res = new int[] {a,b,c,e}; ���� A�� C���� ũ�ٸ� PASS
		}
		if(e<0) {
			res = new int[] {a,b,c,d}; ���� B�� C���� ũ�ٸ� PASS
		}
		if(e<0 && d<0) {
			res = new int[] {a,b,c}; A, B �� �� ũ�� PASS
		}
		res = new int[] {a,b,c,d,e};

        ArrayList<Integer> arrayList = new ArrayList<>();

        for(int i : res){ //�ߺ��˻�
            if(!arrayList.contains(i))
                arrayList.add(i);
        }
        Collections.sort(arrayList); //�������� ����
        for(int j : arrayList) {
        	   System.out.print(j + " ");
        	} 
        	System.err.println();
        
	}  
 * 
 * ���� ��찡 �´ٰ� �����ߴµ� ��Ÿ�� ������ ���� C++�� �ڵ带 ������ ��
 * 
 * #include <iostream>
#include <algorithm>
#include<vector>
using namespace std;


	int main(){
		int a,b,c;
		vector<int> s;
		cin>>a>>b>>c;

		if(a>200 || b>200 || c>200) {
			return -1;
		}
		
		int d = c-a;
		int e = c-b;
		
		if(d<0) {
			s.push_back(a);
			s.push_back(b);
			s.push_back(c);
			s.push_back(e);

		}
		if(e<0) {
			s.push_back(a);
			s.push_back(b);
			s.push_back(c);
			s.push_back(d);		
			}
		if(e<0 && d<0) {
			s.push_back(a);
			s.push_back(b);
			s.push_back(c);
		}
		
		s.push_back(a);
		s.push_back(b);
		s.push_back(c);
    	s.push_back(d);
		s.push_back(e);
		s.erase(unique(s.begin(),s.end()),s.end());	    
        sort(s.begin(), s.end());
        for(size_t i=0; i<s.size(); i++){
        	cout<<s[i]<<" ";
		}

	}


 * 
 * ���� �ڵ尡 Ʋ���� ��α׿� �˻��ؼ� BFS�� ���� Ž�� �ؾ����� �˰� ��
 * �ٵ� ������ ó�� ���� ���� ����Ž���� �ؾ��ϴ� ������� �Ǵ��� �� ���� �ʾҴ�.
 * A->B
 * A->C
 * B->A
 * B->C
 * C->A
 * C->B 6������ ��� Ž��
 * 
 * */
public class BOJ_2251_������ {
	
	static boolean[][][] visited;
	static Queue<Node> q = new LinkedList<>();
	static ArrayList<Integer> list = new ArrayList<>();
	static int max_a,max_b,max_c; //A,B,C ������ ����
	
	public static void main(String[] args) throws IOException{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	    String[] t =br.readLine().split(" ");
	    max_a = Integer.parseInt(t[0]);
	    max_b = Integer.parseInt(t[1]);
	    max_c = Integer.parseInt(t[2]);

		visited = new boolean[max_a+1][max_b+1][max_c+1];
		visited[0][0][max_c] = false; //C���뿡 ó������ ���� �� �����Ƿ� 0,0,C �湮 ó��

		q.add(new Node(0,0,max_c));
		bfs();
		Collections.sort(list); //�������� ����
		
		for(int i=0; i<list.size(); i++) {
			System.out.print(list.get(i)+" ");
		}
	}
	

	
	public static void bfs() {
		while(!q.isEmpty()) {
			Node node = q.poll();

			if(visited[node.a][node.b][node.c]) {
				continue; //�湮�� ����̸� PASS
			}
			visited[node.a][node.b][node.c] = true;

			if(node.a+node.b <=max_a) { //B->A A�� ��ġ�� ���� �� 
				q.add(new Node(node.a+node.b,0,node.c)); //���ο� ��쿡 ���ؼ� ��� Ž������
			}
			else {//B->A A�� ��ĥ ��
				q.add(new Node(max_a,node.b+node.a-max_a, node.c));
			}
			if(node.a+node.c<=max_a) { //C->A A�� ��ġ�� ���� ��
				q.add(new Node(node.a+node.c,node.b,0));
			}
			else {//C->A A�� ��ĥ ��
				q.add(new Node(max_a,node.b,node.c+node.a-max_a));
			}
			if(node.a+node.b<=max_b) { //A->B
				q.add(new Node(0,node.a+node.b,node.c));
			}
			else {
				q.add(new Node(node.a+node.b-max_b,max_b,node.c));
			}
			if(node.c+node.b <=max_b) {//C->B
				q.add(new Node(node.a, node.b+node.c, 0));
			}
			else {
				q.add(new Node(node.a,max_b,node.c+node.b-max_b));
			}
			if(node.a+node.c <=max_c) {//A->C
				q.add(new Node(0,node.b,node.a+node.c));
			}
			else {
				q.add(new Node(node.a+node.c-max_c, node.b, max_c));
			}
			if(node.b+node.c <=max_c) {// B->C
				q.add(new Node(node.a,0,node.c+node.b));
			}
			else {
				q.add(new Node(node.a,node.b+node.c-max_c,max_c));
			}
			if(node.a==0) { //A ���뿡 ���� 0�ΰ�� ����� �߰���
				list.add(node.c);
			}
		}		
	}
}


class Node{
    int a,b,c;
    Node(int a, int b ,int c){
        this.a=a;
        this.b=b;
        this.c=c;
    }
}