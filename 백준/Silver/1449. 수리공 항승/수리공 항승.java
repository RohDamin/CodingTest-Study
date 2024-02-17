// Greedy Algorithm
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s, " ");
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int arr[] = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int range = (int) (arr[0] - 0.5 + l);
        int count = 1;

        for (int i = 1; i<arr.length; i++) {
            if (range < (int)(arr[i] + 0.5)) { // 구멍이 테이프 범위 밖인 경우
                range = (int) (arr[i] - 0.5 + l);
                count++;
            }
        }
        System.out.println(count);

        bw.flush();
        bw.close();
        br.close();
    }
}

