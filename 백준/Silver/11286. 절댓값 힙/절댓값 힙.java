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
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> minusQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> plusQ = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();
        int res;

        for (int i =0; i<N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) { // 출력
                if (minusQ.isEmpty() && plusQ.isEmpty()) {
                    sb.append(0).append("\n");
                } else if (minusQ.isEmpty()) {
                    sb.append(plusQ.poll()).append("\n");
                } else if (plusQ.isEmpty()) {
                    sb.append(minusQ.poll()).append("\n");
                } else { // 2개의 큐 모두 비어있지 않은 경우
                    int m = Math.abs(minusQ.peek());
                    int p = plusQ.peek();
                    res = m <= p ? minusQ.poll() : plusQ.poll();
                    sb.append(res).append("\n");
                }
            }
            else { // 삽입
                if (num>0) plusQ.add(num);
                else minusQ.add(num);
            }
        }
        System.out.println(sb.toString());
    }
}