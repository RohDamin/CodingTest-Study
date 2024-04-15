// 이분 탐색
import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<M; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (isExist(num)) sb.append(1).append("\n");
            else sb.append(0).append("\n");
        }

        System.out.println(sb);
    }

    static boolean isExist(int num) {
        int l = 0;
        int h = arr.length-1;

        while (l<=h) {
            int m =(l+h)/2;
            if (num>arr[m]) {
                l = m+1;
            } else if (num<arr[m]) {
                h = m-1;
            } else {
                return true;
            }
        }
        return false;
    }
}