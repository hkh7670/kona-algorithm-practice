package com.company.programmers._72410;

public class 송복민_72410 {

	public static void main(String[] args) {
		System.out.println(solution("123_.def"));
	}
	
	public static String solution(String new_id) {
        String answer = "";
        for (int i = 0; i < new_id.length(); i++) {
			char s=new_id.charAt(i);
			int num=(int)s;
			//1단계
			if(65<=num&&num<=90) {
				num+=32;
				answer+=(char)num;
				continue;
			}
			//2단계
			if((97<=num&&num<=122)||(48<=num&&num<=57)||num==45||num==95||num==46) {
				answer+=s;
			}
		}
        
        //3단계, 4단계
        String answer1="";
        int dot=0;
        boolean flag=false;
        for (int i = 0; i < answer.length(); i++) {
			char s=answer.charAt(i);
			if(s=='.'&&!flag) continue;//시작부터 .이면 다음으로
			if(s!='.') flag=true;//.아닌 순간부터 고려하기
			if(flag) {
				if(s!='.'&&dot>0) {//1개로 치환
					answer1+="."+s;
					dot=0;
				}else if(s!='.'){//.아니면 그냥 붙이기
					answer1+=s;
				}else {
					dot++;//.중복 값
				}
			}
		}
        
        //5단계
        if(answer1.length()==0) answer1="a";
        //6단계 
        if(answer1.length()>=16) {
        	String answer2="";
        	for (int i = 0; i < 15; i++) {
				char s=answer1.charAt(i);
				if(i==14&&s=='.') continue; //6단계 후 마지막이 .인 것을 고려
				answer2+=s;
			}
        	return answer2;
        }
        //7단계
        if(answer1.length()<=2) {
        	String answer2=answer1;
        	char s=answer1.charAt(answer1.length()-1);
        	for (int i = answer1.length(); i <3; i++) {
				answer2+=s;
			}
        	return answer2;
        }
        
        return answer1;
    }
}
