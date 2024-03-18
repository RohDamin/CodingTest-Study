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
    static int[] money;
    static boolean [] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int sum = 0;

        visited = new boolean[N+1];

        parent = new int[N+1];
        for (int i = 1; i<N+1; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        money = new int[N+1];
        for (int i = 1; i<=N; i++) {
            money[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            union(v, w);
        }

        for (int i = 1; i<=N; i++) {
            int root = find(i); // 루트 인덱스

            if (visited[root]) { // 루트의 인덱스를 방문했으면
                visited[i] = true; // 해당 인덱스 패스
                continue;
            }

            sum += money[root]; // 루트의 값(해당 트리의 최솟값)만 더해줌
            visited[i] = true;
            visited[root] = true;
        }

        if (sum <= K) System.out.println(sum);
        else System.out.println("Oh no");

    }
    static void union (int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return;

        // 루트에 트리의 최솟값 저장
        if (money[a] >= money[b]) parent[a] = b;
        else parent[b] = a;
    }

    static int find (int n) {
        if (parent[n] == n) return n;
        else return find(parent[n]);
    }
}