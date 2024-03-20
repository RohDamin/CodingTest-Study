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
    static long[] minTree, maxTree, arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new long[N+1];
        minTree = new long[N*4];
        maxTree = new long[N*4];


        for (int i = 1; i<=N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        minInit(1, N, 1);
        maxInit(1, N, 1);


        for (int i = 0; i<M; i++) {
            st = new StringTokenizer(br.readLine());

            // 최솟값, 최댓값을 찾아야 하는 구간
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(min(1, N, 1, a, b)).append(' ');
            sb.append(max(1, N, 1, a, b)).append('\n');

        }

        System.out.println(sb);
        br.close();
    }

    // 구간 힙 트리 생성
    static long minInit (int start, int end, int node) {
        if (start == end) return minTree[node] = arr[start];
        int mid = (start + end) / 2;
        return minTree[node] = Math.min(minTree[node] = minInit(start, mid, node*2), minInit(mid+1, end, node*2+1));
    }

    static long maxInit (int start, int end, int node) {
        if (start == end) return maxTree[node] = arr[start];
        int mid = (start + end) / 2;
        return maxTree[node] = Math.max(maxTree[node] = maxInit(start, mid, node*2), maxInit(mid+1, end, node*2+1));
    }

    // 구간의 최솟값을 구하는 함수
    static long min (int start, int end, int node, int left, int right) {
        // 범위 밖에 있는 경우
        if (left > end || right < start) return Long.MAX_VALUE;

        // 범위 안에 있는 경우
        if (left <= start && end <= right) return minTree[node];

        // 둘다 아니라면 더 아래 노드로 들어가야 함
        int mid = (start + end) / 2;
        return Math.min(min(start, mid, node*2, left, right), min(mid+1, end, node*2+1, left, right));
    }

    // 구간의 최댓값을 구하는 함수
    static long max (int start, int end, int node, int left, int right) {
        // 범위 밖에 있는 경우
        if (left > end || right < start) return Long.MIN_VALUE;

        // 범위 안에 있는 경우
        if (left <= start && end <= right) return maxTree[node];

        // 둘다 아니라면 더 아래 노드로 들어가야 함
        int mid = (start + end) / 2;
        return Math.max(max(start, mid, node*2, left, right), max(mid+1, end, node*2+1, left, right));
    }
}