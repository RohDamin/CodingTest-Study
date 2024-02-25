// 리스트(List), 배열(Array), 연결 리스트(Linked List)
import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int N, M, cnt;
    static Deque<Balloon> deque = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i<N; i++) {
            int v = Integer.parseInt(st.nextToken());
            deque.addLast(new Balloon(i, v));
        }

        Balloon balloon = deque.removeFirst();
        int pollValue = balloon.getValue();
        sb.append(balloon.getId()).append(" ");

        while (!deque.isEmpty()) {
            if (pollValue > 0) {
                for (int i = 1; i<pollValue; i++) {
                    balloon = deque.removeFirst();
                    deque.addLast(balloon);
                }
                balloon = deque.removeFirst();
            } else {
                pollValue = Math.abs(pollValue);
                for (int i = 1; i<pollValue; i++) {
                    balloon = deque.removeLast();
                    deque.addFirst(balloon);
                }
                balloon = deque.removeLast();
            }
            pollValue = balloon.getValue();
            sb.append(balloon.getId()).append(" ");
        }
        System.out.println(sb);
    }

    static class Balloon {
        private int id;
        private int value;

        private Balloon(int id, int value) {
            this.id = id;
            this.value = value;
        }
        public int getId() { return id+1; }
        public int getValue() { return value; }
    }
}