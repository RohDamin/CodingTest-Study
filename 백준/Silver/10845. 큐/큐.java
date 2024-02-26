// 큐(Queue), 덱(Dequeue)
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<String> q = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());
        String last = "";

        for (int i = 0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            if (s.equals("push")) {
                last = st.nextToken();
                q.offer(last); // 다음 값 push

            } else if (s.equals("pop")) {
                if (!q.isEmpty()) System.out.println(q.poll()); // 큐가 비어 있지 않은 경우 출력후 삭제
                else System.out.println(-1); // 비어 있는 경우 -1 출력
            } else if (s.equals("size")) {
                System.out.println(q.size()); // 큐 사이즈 출력
            } else if (s.equals("empty")) {
                if (q.isEmpty()) System.out.println(1); // 큐가 비어 있는 경우 1 출력
                else System.out.println(0); // 비어 있지 않은 경우 0 출력
            } else if (s.equals("front")) {
                if (!q.isEmpty()) System.out.println(q.peek()); // 큐가 비어 있지 않은 경우 출력
                else System.out.println(-1); // 비어 있는 경우 -1 출력
            } else if (s.equals("back")) {
                if (!q.isEmpty()) System.out.println(last); // 큐가 비어 있지 않은 경우 가장 뒤에 있는 정수 출력
                else System.out.println(-1); // 비어 있는 경우 -1 출력
            }
        }
    }
}