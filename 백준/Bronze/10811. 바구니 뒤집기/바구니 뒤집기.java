// 배열
import java.util.*;
import java.io.*;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new int[N+1];


        for (int i=1; i<=N; i++) {
            arr[i] = i;
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            reverse(start, end);
        }
        for (int i=1; i<=N; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static void reverse(int s, int e) {
        if (s==e) return;
        if (s+1 == e) {
            int temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            return;
        }

        for (int i = 0; i<(e-s+1)/2; i++) {
            int ns = s+i;
            int ne = e-i;
            int temp = arr[ns];
            arr[ns] = arr[ne];
            arr[ne] = temp;
        }
    }
}