/*
 # 세그먼트 트리(Segment Tree)

 * 구간들을 보존하고 있는 트리
 * 리프 노드는 길이가 1인 각각의 구간을 갖고,
 * 부모 노드는 자식 노드들의 구간의 합을 가지고 있음
 * 모든 구간은 연속적이어야 함
 * disjoint한 집합들을 표현하는 자료구조
 * 보통 완전 이진 트리 형태를 사용해 전체적으로 동일한 재귀적 구조가 반복되도록 표현
 * 포화 이진 트리 형태로 사용하면 값이 N개일 때, 트리의 높이가 O(log N)으로 균형잡혀 있게 됨

 */
import java.io.*;
import java.util.*;

public class Main {
    static long[] tree, arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        arr = new long[N+1];
        tree = new long[N*4];

        for (int i = 1; i<=N; i++) {
            arr[i] = 0;
        }

        init(1, N, 1);

        for (int i = 0; i<Q; i++) {
            st = new StringTokenizer(br.readLine());

            int op = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int xq = Integer.parseInt(st.nextToken());

            if (op == 1) {
                long dif = arr[p] + xq;
                update(1, N, 1, p, dif);
            } else if (op == 2) {
                sb.append(value(1, N, 1, p, xq)).append('\n');
            }
        }

        System.out.println(sb);
        br.close();
    }

    // 구간 힙 트리 생성
    static long init (int start, int end, int node) {
        if (start == end) return tree[node] = arr[start];
        int mid = (start + end) / 2;
        return tree[node] = tree[node] = init(start, mid, node*2) + init(mid+1, end, node*2+1);
    }

    // 구간의 변화량 구하는 함수
    static long value (int start, int end, int node, int left, int right) {
        // 범위 밖에 있는 경우
        // [L..R] -- [start..End] -- [L..R]
        if (right < start || end < left ) return 0;

        // 범위 안에 있는 경우
        // [L.. -- [start..End] -- ..R]
        if (left <= start && end <= right) return tree[node];

        // 둘다 아니라면 더 아래 노드로 들어가야 함
        int mid = (start + end) / 2;
        return value(start, mid, node*2, left, right) + value(mid+1, end, node*2+1, left, right);
    }

    // 특정 원소의 값을 수정하는 함수
    static void update (int start, int end, int node, int index, long dif) {
        // 범위 밖에 있는 경우 -> 수정 X
        if (index < start || index > end) return;

        // 범위 안에 있는 경우 -> 수정 O
        tree[node] += dif;
        if (start == end) return;
        // 내려가면서 다른 원소도 갱신
        int mid = (start + end) / 2;
        update(start, mid, node*2, index, dif);
        update(mid+1, end, node*2+1, index, dif);
    }
}