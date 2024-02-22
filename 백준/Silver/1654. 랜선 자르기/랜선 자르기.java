// Binary Search
import java.io.*;
import java.util.*;

public class Main {
    public static int[] lan;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken()); // 가지고 있는 랜선의 개수
        int N = Integer.parseInt(st.nextToken()); // 필요한 랜선의 개수
        long max = 0;

        lan = new int[K];

        for(int i = 0; i<K; i++) {
            lan[i] = Integer.parseInt(br.readLine());
            if (max < lan[i]) max = lan[i];
        }

        long min = 0;
        long mid = 0;
        max++;

       while (min<max) {
            mid = (min+max)/2;

            long sum = 0;

            for (int l = 0; l < lan.length; l++) {
                sum += lan[l]/mid;
            }

            if (sum < N) {
                max = mid;
            } else {
                min = mid+1;
            }
        }
       System.out.println(min-1);
    }
}