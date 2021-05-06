import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
// 백준에 코드 제출 시 클래스명을 Main으로 바꾸기
public class Backjoon9095 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	/**
	 * Dynamic Programming 
	 * 
	 * 경우의 수 
	 * 1일 때 1가지: 1
	 * 2일 때 2가지: 1+1 ,2
	 * 3일 때 4가지: 1+1+1, 1+2, 2+1, 3
	 * 
	 * 정수 n은 양수이다. 그리고 11보다 작다. 배열 수를 10으로 설정해준다. 
	 * 1과 2와 3이 정해져 있기 때문에 for문에서 3부터 9까지 실행한다. (배열은 0번째부터 시작이니까)
	 * 
	 * while(variable-- > 0) 
	 * 설명: variable에서 -1을 빼고 나서도 0보다 클 경우 계속 실행
	 * 해설: 3을 넣었을 때 
	 * 3 > 0
	 * 3-1 = 2 > 0
	 * 2-1 = 1 > 0
	 * 총 3번 실행
	 * 
	 * 참고 배열: https://hwan02.github.io/goldev_tech-interview/docs/
	*/

		int[] dp = new int[10];
		dp[0] = 1;
		dp[1] = 2;
		dp[2] = 4;

		for (int i = 3; i <= 9; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
		}

		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			sb.append(dp[N-1] + "\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
