/*
구간합 배열(Prefix Sum)
*/
import java.io.*;
import java.util.*;

public class Main {
    static int T, N, max;
    static int[] arr, sumArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for (int t = 0; t<T; t++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N+1];
            sumArr = new int[N+1];
            sumArr[0] = 0;
            max = Integer.MIN_VALUE;

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i<=N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                sumArr[i] = sumArr[i-1] + arr[i];
                max = Math.max(max, Math.max(arr[i], sumArr[i]));
            }

            for (int i = 1; i<=N; i++) {
                for (int j = N; j>i; j--) {
                    max = Math.max(max, sumArr[j] - sumArr[i]);
                }
            }
            System.out.println(max);
        }
    }
}