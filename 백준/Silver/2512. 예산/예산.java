// Binary Search
import java.io.*;
import java.util.*;

public class Main {
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 지반의 수
        long max = 0;
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken()); // 각 지방의 예산요청
            if (max < arr[i]) max = arr[i];
        }
        int M = Integer.parseInt(br.readLine()); // 총 예산


        long min = 0;
        long mid = 0;

       while (min<=max) {
            mid = (min+max)/2;

            long sum = 0;

            for (int l : arr) {
                if (l <= mid) sum += l;
                else sum += mid;
            }

            if (sum <= M) {
                min = mid+1;
            } else {
                max = mid-1;
            }
        }
       System.out.println(max);
    }
}