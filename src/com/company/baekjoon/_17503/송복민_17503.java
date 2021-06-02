package com.company.baekjoon._17503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 송복민_17503 {

	static int N; 
	static int M; 
	static int K;
	static int[][] data; //선호도, 도수
	static PriorityQueue<Integer> pq;
	static int sum=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		data=new int[K][2];
		pq=new PriorityQueue<>();
		
		for (int k = 0; k < K; k++) {
			st=new StringTokenizer(br.readLine());
			int v=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			data[k][0]=v;//선호도
			data[k][1]=c;//도수
		}
		
		//도수 낮은 순으로 정렬
		Arrays.sort(data,new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1]-o2[1];
			}
		});
		
		for (int k = 0; k < K; k++) {
			pq.offer(data[k][0]);//선호도 값 넣어주기
			sum+=data[k][0];
			
			if(pq.size()>N) {//사이즈가 N보다 커지면
				sum-=pq.peek();//가장 선호도가 낮은 것 빼기
				pq.poll();
			}
			
			if(pq.size()==N&&sum>=M) {//사이즈가 N이고 선호도의 합도 충족하면
				System.out.println(data[k][1]);//해당 도수 출력 (위에서 도수가 낮은 순으로 정렬되었기 때문에 현재가 N개 중에서는 최고 도수)
				return;
			}
		}
		System.out.println("-1");
		
	}
}

/* 시간초과
public class 송복민_17503 {

	static int N; 
	static int M; 
	static int K;
	static int[][] data; //선호도, 도수
	static boolean[] visited;
	static int[] num;
	static int min=Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		data=new int[K][2];
		visited=new boolean[K];
		num=new int[K];
		
		for (int k = 0; k < K; k++) {
			st=new StringTokenizer(br.readLine());
			int v=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			data[k][0]=v;
			data[k][1]=c;
		}
		
		bt(0,0);
		System.out.println(min==Integer.MAX_VALUE?-1:min);
		
	}
	private static void bt(int start, int cnt) {
		//K종류 중 N개 선택 (N일동안 N병 마시기 때문)
		if(cnt==N) {
			//선호도 합 체크
			int prefer=0;
			int level=Integer.MIN_VALUE;
			for (int i = 0; i < N; i++) {
				prefer+=data[num[i]][0];
				level=Math.max(level, data[num[i]][1]);
			}
			if(prefer<M) return;
			
			//간 레벨 체크
			min=Math.min(min, level);
			
			return;
		}
		for (int i = start; i <K ; i++) {//0~K-1 : data의 인덱스
			if(!visited[i]) {
				visited[i]=true;
				num[cnt]=i;
				bt(i,cnt+1);
				visited[i]=false;
			}
		}
	}
}

*/