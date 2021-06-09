import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 서승환_1138 {
    static int n;
    static int[] answer;
    public static void main(String[] args) throws Exception, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        answer = new int[n];

        int[] numbers = Arrays.asList(br.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();

        for(int i=0; i < n; i++){
            int left = numbers[i];
            for(int j=0; j<n; j++){
                if(left ==0 && answer[j] ==0){
                    answer[j] = i+1;
                    break;
                }else if(answer[j] ==0){
                    left--;
                }
            }
        }
        for(int i=0; i < n; i++){
            System.out.println(answer[i]);
        }
        
    }
}
