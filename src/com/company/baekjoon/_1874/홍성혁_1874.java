package com.company.baekjoon._1874;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class 홍성혁_1874 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Stack<Integer> stack = new Stack<Integer>();
				
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> list = new ArrayList<Integer>();		//입력받은 입력값 / 만들어야 하는 순열
		
		int n = Integer.parseInt(br.readLine());
		int j = 0;	//입력받은 값의 idx
		
		int number = 1;
		String result = "";
		for(int i=0 ; i<n ; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		
		while(j<n) {
			if(number == n+1 && !(stack.peek() == list.get(j))) {
				System.out.println("NO");
				return;
			}
			if(!stack.empty()) {
				if(stack.peek() == list.get(j)) {
					j++;
					stack.pop();
					result += "-\n";
					continue;
				}
			}
			stack.push(number);
			number++;
			result += "+\n";
		}
		System.out.println(result);
	}

}
