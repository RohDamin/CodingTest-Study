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

            int depth;
            while(true) {
                int min = 101;
                int minIdx = 0;
                int max = -1;
                int maxIdx = 0;
                for (int i=0; i<100; i++) {
                    if (arr[i] < min) {
                        min = arr[i];
                        minIdx = i;
                    }
                    if (arr[i] > max) {
                        max = arr[i];
                        maxIdx = i;
                    }
                }
                depth = arr[maxIdx] - arr[minIdx];
                if (depth<=1 || dump<=0) break;
                arr[minIdx]++;
                arr[maxIdx]--;
                dump--;
            }
            sb.append("#").append(t+1).append(" ").append(depth).append("\n");
        }

        System.out.println(sb);
    }
}