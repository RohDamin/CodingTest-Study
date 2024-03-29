// 동적 계획법(Dynamic Programming)

import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static int[][] maxdp;
    static int[][] mindp;
    static int N, max, min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N+1][3];
        maxdp = new int[N+1][3];
        mindp = new int[N+1][3];

        StringTokenizer st;
        for (int i = 1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int v3 = Integer.parseInt(st.nextToken());
            arr[i][0] = v1;
            arr[i][1] = v2;
            arr[i][2] = v3;
        }

        maxdp[1][0] = arr[1][0];
        maxdp[1][1] = arr[1][1];
        maxdp[1][2] = arr[1][2];

        for (int i = 2; i<=N; i++) {
            maxdp[i][0] = Math.max(maxdp[i-1][0], maxdp[i-1][1]) + arr[i][0];
            maxdp[i][1] = Math.max(maxdp[i-1][0], Math.max(maxdp[i-1][1], maxdp[i-1][2])) + arr[i][1];
            maxdp[i][2] = Math.max(maxdp[i-1][1], maxdp[i-1][2]) + arr[i][2];
        }

        mindp[1][0] = arr[1][0];
        mindp[1][1] = arr[1][1];
        mindp[1][2] = arr[1][2];

        for (int i = 2; i<=N; i++) {
            mindp[i][0] = Math.min(mindp[i-1][0], mindp[i-1][1]) + arr[i][0];
            mindp[i][1] = Math.min(mindp[i-1][0], Math.min(mindp[i-1][1], mindp[i-1][2])) + arr[i][1];
            mindp[i][2] = Math.min(mindp[i-1][1], mindp[i-1][2]) + arr[i][2];
        }

        max = Math.max(maxdp[N][0], Math.max(maxdp[N][1], maxdp[N][2]));
        min = Math.min(mindp[N][0], Math.min(mindp[N][1], mindp[N][2]));

        System.out.println(max + " " + min);
    }
}