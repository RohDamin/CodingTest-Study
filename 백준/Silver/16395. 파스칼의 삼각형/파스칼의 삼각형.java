import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][N + 1];

        // 파스칼 삼각형 만들기
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N - i + 1; j++) {
                if (isRange(i-1,j) && isRange(i, j-1)) {
                    arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
                } else {
                    arr[i][j] = 1;
                }
            }
        }

        System.out.println(arr[N-K+1][K]);
    }

    static boolean isRange(int y, int x){
        return x > 0 && x <= N && y > 0 && y <= N;
    }
}