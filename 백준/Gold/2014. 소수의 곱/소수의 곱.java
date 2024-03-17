/*
 # 우선순위 큐(Priority Queue)

 * push, top, pop 연산
 * top, pop에서 추출되는 원소는 현재 우선순위 큐 안에서 제일 우선순위가 높은 원소

 * 완전 이진 트리인 힙(heap)으로 표현한다.
 * 최대 힙은 모든 정점이 자신의 자식들보다 높다.

 */
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        PriorityQueue<Long> q = new PriorityQueue<>();
        List<Long> arr = new ArrayList<>();;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i<K; i++) {
            Long prime = Long.parseLong(st.nextToken());
            q.add(prime);
            arr.add(prime);
        }

        // heap의 top에 있는 원소를 빼고 -> 곱한 값을 다시 heap에 넣어줌
        for (int n = 0; n<N-1; n++) {
            long num = q.poll();
            for (int i = 0; i<K; i++) {
                long temp = num * arr.get(i);

                if (temp >= (long)2<<30) break;

                q.offer(temp);
                if (num % arr.get(i) == 0) break;
            }
        }

        System.out.println(q.poll());
    }
}
