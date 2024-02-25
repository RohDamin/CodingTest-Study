// 리스트(List), 배열(Array), 연결 리스트(Linked List)
import java.io.*;
import java.util.*;

public class Main {
    public static int[] arr;
    public static int N, M, cnt;
    public static LinkedList<Integer> list = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cnt = 0;

        arr = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i<M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i<=N; i++) {
            list.add(i);
        }

        for (int i = 0; i<M; i++) {
            if (check(arr[i])) { // 2번 연산
                while (arr[i] != list.get(0)) {
                    list.addLast(list.pollFirst());
                    cnt++;
                }
            } else { // 3번연산
                while (arr[i] != list.get(0)) {
                    list.addFirst(list.pollLast());
                    cnt++;
                }
            }
            list.poll();

        }

        System.out.println(cnt);
    }

    public static boolean check(int n) {
        for (int i = 0; i<=list.size()/2; i++) {
            if (n == list.get(i)) return true; // 3번연산
        }
        return false; // 2번연산
    };
}