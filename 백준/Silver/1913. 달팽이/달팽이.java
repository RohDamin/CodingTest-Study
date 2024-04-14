import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int value = Integer.parseInt(br.readLine());

        solve(N, value);
    }

    static void solve(int N, int value) {
        int[][] arr = new int[N][N];

        int num = 1;
        int x = N/2, y = N/2;
        int len = 1;

        while (true) {
            for (int l = 0; l<len; l++) {
                arr[y--][x] = num++;
            }
            if (num-1 == N*N) break;
            for (int l = 0; l<len; l++) {
                arr[y][x++] = num++;
            }
            len++;
            for (int l = 0; l<len; l++) {
                arr[y++][x] = num++;
            }

            for (int l = 0; l<len; l++) {
                arr[y][x--] = num++;
            }
            len++;
        }

        StringBuilder sb = new StringBuilder();
        int px=0, py=0;
        for (int i = 0; i<N; i++) {
            for (int j = 0; j<N; j++) {
                sb.append(arr[i][j]).append(" ");
                if (arr[i][j] == value) {
                    px = i+1;
                    py = j+1;
                }
            }
            sb.append("\n");
        }
        sb.append(px).append(" ").append(py);
        System.out.println(sb);
    }
}