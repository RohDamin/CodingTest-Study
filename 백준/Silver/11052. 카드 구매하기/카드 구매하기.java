// Dynamic Programming

import java.io.*;
import java.util.*;

public class Main {
    public static int[] p; // 카드 저장 배열
    public static int[] d; // 금액의 최댓값 저장 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        p = new int [N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i<=N; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }

        d = new int [N+1];
        for (int i = 0; i<=N; i++) {
            d[i] = 0;
        }

        for (int i = 1; i<=N; i++) { //1~5
            for (int j = 0; j<i; j++) { //0~i-1
                d[i] = Math.max(d[i], d[j] + p[i-j]);
            }
        }

        System.out.println(d[N]);
    }
}