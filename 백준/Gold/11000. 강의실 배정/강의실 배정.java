// Greedy Algorithm
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int arr[][] = new int [n][2];

        for (int i = 0; i<n; i++) {
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s, " ");

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        // 정렬
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1]-o2[1];
                } else {
                    return o1[0]-o2[0];
                }
            }
        });

        Queue<Integer> q = new PriorityQueue<>();
        q.add(arr[0][1]);

        for (int i = 1; i<n-1; i++) { // 배열 순회
            if (!q.isEmpty() && q.peek() <= arr[i][0]) { // 강의실의 가장 빠른 종료 시간 <= 현재 탐색 강의 시작 시간
                // 같은 강의실 배정
                q.poll();
                q.add(arr[i][1]);
            } else {
                q.add(arr[i][1]);
            }
        }

        System.out.println(q.size());

        bw.flush();
        bw.close();
        br.close();
    }
}

