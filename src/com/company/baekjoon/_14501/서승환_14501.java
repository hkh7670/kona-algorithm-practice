import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;


public class 서승환_14501 {
    static int N;
    
    public static void main(String[] args) throws Exception, IOException{
        /**
         * 1. 상담일이 퇴사일 N보다 커지는 경우 상담을 할 수 없다. 
         * 2. 남은 기간 중 최대 수익을 내는 상담만을 고른다. 
         * 3. 수익을 더한다.
         * 4. 수익 중 가장 큰 값을 출력한다.
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        int[] L =new int[N+2];
        int[] P =new int[N+2];
        for(int i=1; i<= N; i++){
            int[] numbers = Arrays.asList(br.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
            System.out.println(numbers[0]);
            System.out.println(numbers[1]);
            L[i] = numbers[0];
            P[i] = numbers[1];
        }
        int[] answer = new int[N+2];
        for(int i = N; i>0; i--){
            int day = i + L[i];
            if(day > N + 1){
                answer[i] = answer[i+1];
            }else{
                answer[i] = Math.max(answer[i+1], answer[day] + P[i]);
            }
        }
        bw.write(answer[1] + "\n");
        br.close();
        bw.flush();
        bw.close();
    }
}
