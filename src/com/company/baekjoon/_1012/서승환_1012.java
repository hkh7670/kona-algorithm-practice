import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
// import java.util.Scanner;

public class 서승환_1012 {

    static int x, y, cNm;
    static int[] xRoute = { -1, 0, 1, 0 };
    static int[] yRoute = { 0, 1, 0, -1 };

    static int[][] field;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        /**
         * 깊이 우선 탐색(DFS, Depth-First Search)
         * 
         * 특징 1. 순환 알고리즘 2. 트리 순회 3. 노드 방문 여부 반드시 검사
         * 
         * 방법 1. 순환 호출 2. 명시적인 스택
         * 
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(br.readLine());
        // int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int answer = 0;
            // String[] s = sc.nextLine().split(" ");
            String[] s = br.readLine().split(" ");
            // x =  sc.nextInt();
            // y =  sc.nextInt();
            // cNm =  sc.nextInt();
            x = Integer.parseInt(s[0]);
            y = Integer.parseInt(s[1]);
            cNm = Integer.parseInt(s[2]);
            field = new int[y][x];

            for (int j = 0; j < cNm; j++) {
                // String[] s2 = sc.nextLine().split(" ");
                String[] s2 = br.readLine().split(" ");
                int cX =  Integer.parseInt(s2[0]);
                int cY =  Integer.parseInt(s2[1]);
                field[cY][cX] = 1;
            }

            for (int w = 0; w < y; w++) {
                for (int z = 0; z < x; z++) {
                    if (field[w][z] == 1) {
                        answer++;
                        DFS(w, z);
                    }
                }
            }
            System.out.println(answer);
        }
        // sc.close();
        br.close();
    }

    static void DFS(int x, int y){
        field[y][x] = 0;
        for(int s = 0; s < 4; s++){
            int nextX = x + xRoute[s];
			int nextY = y + yRoute[s];
			if( nextX >= 0 && nextX < x && nextY >= 0 && nextY < y ) {
				if( field[nextX][nextY] == 1) {
					DFS(nextX, nextY);
				}
			}
        }
    }
}