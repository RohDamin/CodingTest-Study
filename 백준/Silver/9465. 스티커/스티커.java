// Dynamic Programming

import java.io.*;
import java.util.*;

public class Main {
    public static int value[][] =  new int[2][100000];
    public static int dp[][] = new int[100000][3];
    public static int T, N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t<T; t++) {
            N = Integer.parseInt(br.readLine());
            for (int i = 0; i<2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j<N; j++) {
                    value[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i<N; i++) {
                for (int j = 0; j<3; j++) {
                    dp[i][j] = -1;
                }
            }
            System.out.println(sticker(0, 0));
        }

    }
    public static int sticker(int c, int status) {
        if (c == N) return 0;
        if (dp[c][status] != -1) return dp[c][status];

        int result = sticker(c+1, 0); // c열의 스티커를 아무것도 떼지 않았을 때의 값
        // c열 위 스티커를 떼지 않은 경우 -> max(제거 X 상태, 제거 O 상태+지금 스티커의 값)
        if (status !=1) result=Math.max(result, sticker(c+1, 1)+value[0][c]);
        // c열 아래 스티커를 떼지 않은 경우 -> max(제거 X 상태, 제거 O 상태+지금 스티커의 값)
        if (status !=2) result=Math.max(result, sticker(c+1, 2)+value[1][c]);

        dp[c][status] = result;
        return result;
    }
}