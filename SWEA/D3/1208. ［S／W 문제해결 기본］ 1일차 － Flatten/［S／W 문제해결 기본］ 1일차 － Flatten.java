// 배열, 정렬
import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = 10;
        int[] arr;
        for (int t=0; t<T; t++) {
            int dump = Integer.parseInt(br.readLine());
            arr = new int[100];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i=0; i<100; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            ;
            for (int i=0; i<dump; i++) {
                Arrays.sort(arr);
                arr[99]--;
                arr[0]++;
            }
            Arrays.sort(arr);
            sb.append("#").append(t+1).append(" ").append(arr[99]-arr[0]).append("\n");
        }

        System.out.println(sb);
    }
}