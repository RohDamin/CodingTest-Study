// Binary Search
import java.io.*;
import java.util.*;

public class Main {
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        long max = 0;
        long min = 1;
        long mid = 0;
        arr = new int[N];

        for(int i = 0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        max = arr[arr.length-1];

        while (min<=max) {
            mid = (min+max)/2;
            long last = arr[0] + mid;
            long cnt = 1; // 맨 왼쪽에 하나 설치

            for (int j = 1; j< arr.length; j++) {
                if (last <= arr[j]) {
                    last = arr[j] + mid; // 만약 +mid 거리에 집이 있다면 sum에 더해줌
                    cnt++;
                }
            }

            if (cnt >= C) { // 설치된 수 >= 설치해야 하는 수: 거리를 늘려야 함
                min = mid+1; // mid 증가
            } else {
                max = mid-1; // mid 감소
            }
        }
       System.out.println(min-1);
    }
}