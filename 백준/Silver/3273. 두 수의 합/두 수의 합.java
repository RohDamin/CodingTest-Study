import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int x = Integer.parseInt(br.readLine());
        int cnt = 0;

        for (int i = 0; i<n; i++) {
            int pos = arr[i];
            for (int j = i+1; j<n; j++) {
                int sum = pos + arr[j];
                if (sum == x) {
                    cnt++;
                    break;
                }
            }
        }
        System.out.println(cnt);
    }
}