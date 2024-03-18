/*
 # 유니온 파인드(Union-Find / disjoint-set)

 * union, find 2개의 연산만 지원하는 자료구조
 * disjoint한 집합들을 표현하는 자료구조
 * disjoint한 집합이란 어떤 두 집합 사이에도 교집합의 원소가 하나도 없고,
   모든 집합의 합집합은 전체집합인 집합을 의미함
 * 즉, 항상 여러 개의 트리 형태를 띄고 있음

 * find 연산: 어떤 정점의 루트를 찾아줌
 * union 연산: 두 집합을 하나로 합쳐줌

 */
import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    static int[] city;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        // 배열 -1로 초기화
        parent = new int[N+1];
        for (int i = 0; i<N+1; i++) {
            parent[i] = -1;
        }
        city = new int[M+1];

        for (int i = 1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j<=N; j++) {
                int c = Integer.parseInt(st.nextToken());
                if (c == 1) {
                    union(i, j);
                }
            }
        }

        boolean isPossible = true;

        st = new StringTokenizer(br.readLine());
        int prev = Integer.parseInt(st.nextToken());
        prev = find(prev);

        for (int i = 1; i<M; i++) {
            int c = find(Integer.parseInt(st.nextToken()));
            if (prev != c) {
                isPossible = false;
                break;
            } else {
                prev = c;
            }
        }

        if (isPossible) System.out.println("YES");
        else System.out.println("NO");

    }
    static void union (int a, int b) {
        // 각각의 루트 값 저장
        a = find(a);
        b = find(b);

        // 루트 값이 같다면 같은 트리 -> 종료
        if (a == b) return;

        // 루트 값이 다르다면 -> b의 루트의 부모를 a로 만들어 통합
        parent[b] = a;
    }

    static int find (int n) {
        if (parent[n] < 0) return n;
        parent[n] = find(parent[n]);
        return parent[n];
    }
}